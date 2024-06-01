package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PostRequests  {
        public static final String CREATE_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/create";

        public static void main(String[] args) {
            try {
                HttpClient httpClient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(CREATE_EMPLOYEE_URL);
                httpPost.setHeader("Content-type", "application/json");

                // JSON data to send in the POST request
                String json = "{ \"name\": \"Simon\", \"salary\": \"5000\", \"age\": \"30\" }";
                StringEntity entity = new StringEntity(json);
                httpPost.setEntity(entity);

                HttpResponse httpResponse = httpClient.execute(httpPost);

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