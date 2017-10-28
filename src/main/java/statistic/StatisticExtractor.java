package statistic;

import response.ResponseData;

import java.io.UnsupportedEncodingException;

import static statistic.HtmlTagsCounter.calculateTagsCount;

public class StatisticExtractor {

    public static ResponseStatisticRow getInformation(ResponseData responseData) {
        ResponseStatisticRow chunk = new ResponseStatisticRow();
        chunk.responseCode = responseData.responseCode;
        chunk.responseSize = responseData.responseContent.length;

        if (responseData.contentType.startsWith("text/html")) {
            try {
                chunk.htmlTagsCount = calculateTagsCount(new String(responseData.responseContent, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return chunk;
    }

}
