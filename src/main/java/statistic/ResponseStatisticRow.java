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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseStatisticRow that = (ResponseStatisticRow) o;

        return responseCode == that.responseCode &&
                responseSize == that.responseSize &&
                htmlTagsCount == that.htmlTagsCount;
    }

    @Override
    public int hashCode() {
        int result = responseCode;
        result = 31 * result + responseSize;
        result = 31 * result + htmlTagsCount;
        return result;
    }
}
