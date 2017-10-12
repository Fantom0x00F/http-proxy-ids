package response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseData {
    int responseCode;
    List<String> headers = new ArrayList<String>();

    String contentType = "raw";
    byte[] responseContent;

    @Override
    public String toString() {
        return "ResponseData{" +
                "responseCode=" + responseCode +
                ", headers=" + headers +
                ", contentType='" + contentType + '\'' +
                ", responseContent=" + getResponsePresentation() +
                '}';
    }

    private String getResponsePresentation() {
        return ((responseContent.length < 100) ? Arrays.toString(responseContent) : responseContent.length + "bytes");
    }
}
