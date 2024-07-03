package tests;
import api.DeleteEmployee;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;

import static api.DeleteEmployee.DELETE_EMPLOYEE_URL;
import static api.PutRequest.UPDATE_EMPLOYEE_URL;
import static org.testng.Assert.assertEquals;

public class TestDelete {



    @Test
    public void testDeleteEmployee() {


        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(DELETE_EMPLOYEE_URL);
            httpDelete.setHeader("Content-type", "application/json");

            CloseableHttpResponse httpResponse = httpClient.execute((HttpUriRequest) httpDelete);

            // Validate the status code
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            Assert.assertEquals(200, statusCode, "Expected status code 200");

            // Print the response body
            StringBuilder responseContent = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line).append("\n");
                }
            }

            String responseBody = responseContent.toString();
            System.out.println("Response Body:");
            System.out.println(responseBody);

            // Check for expected response content (adjust as necessary based on actual API response)
            Assert.assertTrue(responseBody.contains("\"success\":\"true\""), "Response does not indicate success");
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

}

