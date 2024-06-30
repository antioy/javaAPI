package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PutRequest  {


    private static final String UPDATE_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/update/21";

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(UPDATE_EMPLOYEE_URL);
            httpPut.setHeader("Content-type", "application/json");

            // JSON data to send in the PUT request
            String json = "{ \"name\": \"Simon\", \"salary\": \"7000\", \"age\": \"32\" }";
            StringEntity entity = new StringEntity(json);
            httpPut.setEntity(entity);

            HttpResponse httpResponse = httpClient.execute(httpPut);

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