package analyser;

import notification.INotificator;
import request.RequestParameters;
import response.ResponseData;
import statistic.ResponseStatisticRow;
import statistic.StatisticExtractor;
import storage.IStatisticStorage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Analyser {

    private AnalyserMode analyserMode = AnalyserMode.ACTION;
    private IStatisticStorage statisticStorage;
    private INotificator alertNotificator;

    public synchronized void processRequest(RequestParameters requestParameters, ResponseData responseData) {
        ResponseStatisticRow information = StatisticExtractor.getInformation(responseData);
        if (analyserMode == AnalyserMode.TRAINING) {
            statisticStorage.save(requestParameters, information);
            return;
        }

        if (criticalDeviationDetected(requestParameters, information)) {
            alertNotificator.error("Alert");
        }
    }

    public synchronized void startTraining() {
        statisticStorage.clear();
        analyserMode = AnalyserMode.TRAINING;
        alertNotificator.info("Training started");
    }

    public synchronized void stopTraining() {
        analyserMode = AnalyserMode.ACTION;
        alertNotificator.info("Training completed");
    }

    public void setStatisticStorage(IStatisticStorage statisticStorage) {
        this.statisticStorage = statisticStorage;
    }

    public void setAlertNotificator(INotificator alertNotificator) {
        this.alertNotificator = alertNotificator;
    }


    private boolean criticalDeviationDetected(RequestParameters request, ResponseStatisticRow statisticChunk) {
        throw new NotImplementedException();
    }

}
