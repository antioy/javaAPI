package tests;

import api.GetRequestExample;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

import static org.junit.Assert.assertEquals;

public class GetEmployees {

    @Test
    public void testGetEmployees() throws IOException {
        HttpGet httpGet = new HttpGet(GetRequestExample);


        Executor httpClient;
        HttpResponse httpResponse = httpClient.execute(httpGet);

                // Check the status code
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        // Check the response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        StringBuilder responseContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)) {
            responseContent.append(line).append("\n");
        }
        reader.close();

        System.out.println("Response Body:");
        System.out.println(responseContent.toString());

       
    }
}