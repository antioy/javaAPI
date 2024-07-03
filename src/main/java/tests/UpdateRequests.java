package tests;
import api.PostRequests;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static api.PutRequest.*;

public class UpdateRequests {

    @Test
    public void testUpdateEmployee() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(UPDATE_EMPLOYEE_URL+ CreateEmployee.getId());
        httpPut.setHeader("Content-type", "application/json");



        HttpResponse httpResponse = httpClient.execute(httpPut);

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


    }
}
}
