package statistic;

import response.ResponseData;

import java.io.UnsupportedEncodingException;

import static statistic.HtmlTagsCounter.calculateTagsCount;

public class StatisticExtractor {

    public static ResponseStatisticRow getInformation(ResponseData responseData) {
        int htmlTagsCount = -1;
        if (responseData.contentType.startsWith("text/html")) {
            try {
                htmlTagsCount = calculateTagsCount(new String(responseData.responseContent, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return new ResponseStatisticRow(responseData.responseCode, responseData.responseContent.length, htmlTagsCount);
    }

}
