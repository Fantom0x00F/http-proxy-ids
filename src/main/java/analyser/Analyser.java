package analyser;

import notification.INotificator;
import request.RequestParameters;
import response.ResponseData;
import statistic.ResponseStatisticRow;
import statistic.StatisticExtractor;
import storage.IStatisticStorage;

import java.util.List;

public class Analyser {

    private static final int REQUIRED_REQUESTS_FOR_STATISTIC = 10;

    private IStatisticStorage statisticStorage;
    private INotificator alertNotificator;

    public synchronized boolean processRequest(RequestParameters requestParameters, ResponseData responseData) {
        ResponseStatisticRow information = StatisticExtractor.getInformation(responseData);

        List<ResponseStatisticRow> statistic = statisticStorage.getStatistic(requestParameters);
        if (statistic.size() < REQUIRED_REQUESTS_FOR_STATISTIC) {
            alertNotificator.info("Request " + requestParameters +
                    " processed as trained request " + (statistic.size() + 1) +
                    "/" + REQUIRED_REQUESTS_FOR_STATISTIC);
            statisticStorage.save(requestParameters, information);

            if (statistic.size() >= REQUIRED_REQUESTS_FOR_STATISTIC) {
                alertNotificator.info("Fully trained for " + requestParameters);
            }
            return true;
        }

        if (criticalDeviationDetected(statistic, information)) {
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

    private boolean criticalDeviationDetected(List<ResponseStatisticRow> statistic, ResponseStatisticRow statisticChunk) {
        return !statistic.contains(statisticChunk);
    }

}
