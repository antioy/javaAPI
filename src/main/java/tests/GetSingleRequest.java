package tests;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetSingleRequest {
    @Test
    public void testGetEmployee() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(GetSingleRequest.getEmployee();


        HttpResponse httpResponse = httpClient.execute(httpGet);

        // Check the status code
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        // Read and check the response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        StringBuilder responseContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseContent.append(line).append("\n");
        }
        reader.close();

        System.out.println("Response Body:");
        System.out.println(responseContent.toString());

        // Ensure the response body is not empty
        assertNotNull("Response body should not be null", responseContent.toString());

        // Additional assertions or processing of the response data can be added here
    }

    private static String getEmployee() {
    }
}
}
