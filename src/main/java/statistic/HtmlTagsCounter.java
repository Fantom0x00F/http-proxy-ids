package statistic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HtmlTagsCounter {
    private static final Pattern pattern = Pattern.compile("<([^/<])*>");

    static int calculateTagsCount(String content) {
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
