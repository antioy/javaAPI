package api;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetRequestExample {

    private static final String URL = "https://dummy.restapiexample.com/api/v1/employees";

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URL);
            httpGet.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpClient.execute(httpGet);

            // Print the status code
            System.out.println("Response Status: " + httpResponse.getStatusLine().getStatusCode());

            // Print the response body
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line).append("\n");
            }
            reader.close();

            System.out.println("Response Body:");
            System.out.println(responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}