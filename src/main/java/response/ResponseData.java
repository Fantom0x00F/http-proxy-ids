package response;

import java.util.Arrays;

public class ResponseData {
    public int responseCode;

    public String contentType = "raw";
    public byte[] responseContent;
    public int latencyInSec;

    @Override
    public String toString() {
        return "ResponseData{" +
                "responseCode=" + responseCode +
                ", contentType='" + contentType + '\'' +
                ", responseContent=" + getResponsePresentation() +
                ", latencyInSec=" + latencyInSec +
                '}';
    }

    private String getResponsePresentation() {
        return ((responseContent.length < 100) ? Arrays.toString(responseContent) : responseContent.length + "bytes");
    }
}
