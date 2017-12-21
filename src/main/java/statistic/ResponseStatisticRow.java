package statistic;

public class ResponseStatisticRow {

    public final int responseCode;
    public final int responseSize;
    public final int htmlTagsCount;
    public final int latencyInSec;

    public ResponseStatisticRow(int responseCode, int responseSize, int htmlTagsCount, int latencyInSec) {
        this.responseCode = responseCode;
        this.responseSize = responseSize;
        this.htmlTagsCount = htmlTagsCount;
        this.latencyInSec = latencyInSec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseStatisticRow that = (ResponseStatisticRow) o;

        return responseCode == that.responseCode &&
                responseSize == that.responseSize &&
                htmlTagsCount == that.htmlTagsCount &&
                latencyInSec == that.latencyInSec;
    }

    @Override
    public int hashCode() {
        int result = responseCode;
        result = 31 * result + responseSize;
        result = 31 * result + htmlTagsCount;
        result = 31 * result + latencyInSec;
        return result;
    }
}
