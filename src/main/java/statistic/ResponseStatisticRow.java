package statistic;

public class ResponseStatisticRow {

    int responseCode = -1;
    int responseSize = -1;
    int htmlTagsCount = -1;

    @Override
    public String toString() {
        return "ResponseStatisticRow{" +
                "responseCode=" + responseCode +
                ", responseSize=" + responseSize +
                ", htmlTagsCount=" + htmlTagsCount +
                '}';
    }
}
