package tests;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static api.DeleteEmployee.deleteEmployee;
import static org.testng.Assert.assertEquals;

public class DeleteEmployee {



    @Test
    public void testDeleteEmployee() {


        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse httpResponse = DeleteEmployee..deleteEmployee();;
            httpDelete.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpClient.execute(httpDelete);

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

