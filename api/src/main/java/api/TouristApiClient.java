
package api;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;


public class TouristApiClient {
    private static final String API_URL = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=jUMVqJ4%2FHzTNCMeYHOjF78hc5V%2BunS%2Be8WLo7ZrtlSjAHbVSxdXGIjIxMvqLjUF5VpdzxMPwZ0KF7xCCjBrgog%3D%3D\r\n"
    		+ "&pageNo=1&numOfRows=10&MobileApp=AppTest&MobileOS=ETC&arrange=A&contentTypeId=32"; // 실제 API URL로 변경
    
    public JsonArray fetchTouristData() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(API_URL);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String responseBody = EntityUtils.toString(entity);
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                    return jsonObject.getAsJsonArray("tourist");
                }
            }
        }
        return null;
    }
    
 
    
}
