package statistic;

import response.ResponseData;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatisticExtractor {

    private Pattern pattern;

    public StatisticExtractor(List<String> keywords) {
        StringJoiner compile = new StringJoiner("|", "(", ")");
        keywords.forEach(compile::add);
        pattern = Pattern.compile(compile.toString());
    }

    public ResponseStatisticRow getInformation(ResponseData responseData) {
        int keywordsCount = 0;
        if (responseData.contentType.startsWith("text/html")) {
            try {
                Matcher matcher = pattern.matcher(new String(responseData.responseContent, "UTF-8"));
                while (matcher.find()) keywordsCount++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return new ResponseStatisticRow(responseData.responseCode,
                responseData.responseContent.length,
                keywordsCount,
                responseData.latencyInSec);
    }

}
