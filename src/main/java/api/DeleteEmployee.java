package api;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DeleteEmployee {
    private static final String DELETE_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/delete/2";

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(DELETE_EMPLOYEE_URL);
            httpDelete.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpClient.execute(httpDelete);

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