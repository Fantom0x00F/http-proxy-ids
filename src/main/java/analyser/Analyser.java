package analyser;

import notification.INotificator;
import org.apache.commons.lang3.tuple.Pair;
import request.RequestParameters;
import response.ResponseData;
import statistic.Measurement;
import statistic.ResponseStatisticRow;
import statistic.StatisticExtractor;
import storage.IStatisticStorage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analyser {

    private static final int REQUIRED_REQUESTS_FOR_STATISTIC = 10;
    private static final int RESPONSE_SIZE_MEASURE_SINGLE_RANGE_WIDTH = 10;

    private IStatisticStorage statisticStorage;
    private INotificator alertNotificator;
    private Map<Measurement, Double> thresholds;

    private StatisticExtractor statisticExtractor;

    public synchronized boolean processRequest(RequestParameters requestParameters, ResponseData responseData) {
        ResponseStatisticRow information = statisticExtractor.getInformation(responseData);

        int learnChunksCount = statisticStorage.learnChunksCount(requestParameters);
        if (learnChunksCount < REQUIRED_REQUESTS_FOR_STATISTIC) {
            alertNotificator.info("Request " + requestParameters +
                    " processed as trained request " + (learnChunksCount + 1) +
                    "/" + REQUIRED_REQUESTS_FOR_STATISTIC);
            statisticStorage.saveLearnChunk(requestParameters, information);
            learnChunksCount++;

            if (learnChunksCount >= REQUIRED_REQUESTS_FOR_STATISTIC) {
                afterTrained(requestParameters);
                alertNotificator.info("Fully trained for " + requestParameters);
            }
            return true;
        }

        if (criticalDeviationDetected(requestParameters, information)) {
            alertNotificator.error("Anomaly detected by " + requestParameters);
            return false;
        }
        return true;
    }

    public void setStatisticStorage(IStatisticStorage statisticStorage) {
        this.statisticStorage = statisticStorage;
    }

    public void setAlertNotificator(INotificator alertNotificator) {
        this.alertNotificator = alertNotificator;
    }

    public void setThresholds(Map<Measurement, Double> thresholds) {
        this.thresholds = thresholds;
    }

    public void setKeywords(List<String> keywords) {
        this.statisticExtractor = new StatisticExtractor(keywords);
    }

    private boolean criticalDeviationDetected(RequestParameters requestParameters, ResponseStatisticRow statisticChunk) {
        boolean violation;
        Double respCodeProbability = statisticStorage.getDiscreteDistribution(Measurement.response_code, requestParameters)
                .stream().filter(it -> it.getLeft() == statisticChunk.responseCode).findFirst().get().getRight();
        violation = ProbabilityChecker.violateByThreshold(respCodeProbability, thresholds.get(Measurement.response_code));
        if (violation) return true;

        Pair<Double, Double> params = statisticStorage.getDistributionParameters(Measurement.response_size, requestParameters);
        violation = ProbabilityChecker.violateByChebyshevCheck(statisticChunk.responseSize / RESPONSE_SIZE_MEASURE_SINGLE_RANGE_WIDTH,
                params.getLeft(), params.getRight(), thresholds.get(Measurement.response_size));
        if (violation) return true;

        Pair<Double, Double> tagsParams = statisticStorage.getDistributionParameters(Measurement.keywords_count, requestParameters);
        violation = ProbabilityChecker.violateByChebyshevCheck(statisticChunk.keywordsCount,
                tagsParams.getLeft(), tagsParams.getRight(), thresholds.get(Measurement.keywords_count));
        if (violation) return true;

        Pair<Double, Double> latencyParams = statisticStorage.getDistributionParameters(Measurement.latency, requestParameters);
        violation = ProbabilityChecker.violateByChebyshevCheck(statisticChunk.latencyInSec,
                latencyParams.getLeft(), latencyParams.getRight(), thresholds.get(Measurement.latency));

        return violation;
    }

    private void afterTrained(RequestParameters requestParameters) {
        List<ResponseStatisticRow> learnData = statisticStorage.getLearnChunk(requestParameters);
        List<Pair<Integer, Double>> respCodeDistribution = ProbabilityCalculator.getDistribution(learnData.stream().map(row -> row.responseCode).collect(Collectors.toList()));
        statisticStorage.saveDiscreteDistribution(Measurement.response_code, requestParameters, respCodeDistribution);

        Pair<Double, Double> respSizeDisParams = ProbabilityCalculator.getDistributionParameters(learnData.stream().map(row -> row.responseSize / RESPONSE_SIZE_MEASURE_SINGLE_RANGE_WIDTH).collect(Collectors.toList()));
        statisticStorage.saveDistributionParameters(Measurement.response_size, requestParameters, respSizeDisParams.getLeft(), respSizeDisParams.getRight());

        Pair<Double, Double> tagsCountDisParams = ProbabilityCalculator.getDistributionParameters(learnData.stream().map(row -> row.keywordsCount).collect(Collectors.toList()));
        statisticStorage.saveDistributionParameters(Measurement.keywords_count, requestParameters, tagsCountDisParams.getLeft(), tagsCountDisParams.getRight());

        Pair<Double, Double> latencyDisParams = ProbabilityCalculator.getNormalDistributionParameters(learnData.stream().map(row -> row.latencyInSec).collect(Collectors.toList()));
        statisticStorage.saveDistributionParameters(Measurement.latency, requestParameters, latencyDisParams.getLeft(), latencyDisParams.getRight());
    }

}
