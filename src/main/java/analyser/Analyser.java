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

    public synchronized boolean processRequest(RequestParameters requestParameters, ResponseData responseData) {
        ResponseStatisticRow information = StatisticExtractor.getInformation(responseData);

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

    private boolean criticalDeviationDetected(RequestParameters requestParameters, ResponseStatisticRow statisticChunk) {
        boolean violation;
        Double respCodeProbability = statisticStorage.getDiscreteDistribution(Measurement.RESPONSE_CODE, requestParameters)
                .stream().filter(it -> it.getLeft() == statisticChunk.responseCode).findFirst().get().getRight();
        violation = ProbabilityChecker.violateByThreshold(respCodeProbability, thresholds.get(Measurement.RESPONSE_CODE));
        if (violation) return true;

        Pair<Double, Double> params = statisticStorage.getDistributionParameters(Measurement.RESPONSE_SIZE, requestParameters);
        violation = ProbabilityChecker.violateByChebyshevCheck(statisticChunk.responseSize / RESPONSE_SIZE_MEASURE_SINGLE_RANGE_WIDTH,
                params.getLeft(), params.getRight(), thresholds.get(Measurement.RESPONSE_SIZE));
        if (violation) return true;

        Pair<Double, Double> tagsParams = statisticStorage.getDistributionParameters(Measurement.HTML_TAGS_COUNT, requestParameters);
        violation = ProbabilityChecker.violateByChebyshevCheck(statisticChunk.htmlTagsCount,
                tagsParams.getLeft(), tagsParams.getRight(), thresholds.get(Measurement.HTML_TAGS_COUNT));

        return violation;
    }

    private void afterTrained(RequestParameters requestParameters) {
        List<ResponseStatisticRow> learnData = statisticStorage.getLearnChunk(requestParameters);
        List<Pair<Integer, Double>> respCodeDistribution = ProbabilityCalculator.getDistribution(learnData.stream().map(row -> row.responseCode).collect(Collectors.toList()));
        statisticStorage.saveDiscreteDistribution(Measurement.RESPONSE_CODE, requestParameters, respCodeDistribution);

        Pair<Double, Double> respSizeDisParams = ProbabilityCalculator.getDistributionParameters(learnData.stream().map(row -> row.responseSize / RESPONSE_SIZE_MEASURE_SINGLE_RANGE_WIDTH).collect(Collectors.toList()));
        statisticStorage.saveDistributionParameters(Measurement.RESPONSE_SIZE, requestParameters, respSizeDisParams.getLeft(), respSizeDisParams.getRight());

        Pair<Double, Double> tagsCountDisParams = ProbabilityCalculator.getDistributionParameters(learnData.stream().map(row -> row.htmlTagsCount).collect(Collectors.toList()));
        statisticStorage.saveDistributionParameters(Measurement.HTML_TAGS_COUNT, requestParameters, tagsCountDisParams.getLeft(), tagsCountDisParams.getRight());
    }

}
