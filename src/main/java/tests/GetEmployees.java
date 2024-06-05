package tests;

import api.GetRequestExample;
import helpers.ResponseReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.Executor;

import static api.GetRequestExample.responseString;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class GetEmployees {

    @Test
    public void testGetEmployees() throws IOException {
        GetRequestExample response = new GetRequestExample();
        // HttpGet httpGet = new HttpGet(GetRequestExample);

        GetRequestExample responseString = new GetRequestExample();



       // Executor httpClient;
       // HttpResponse httpResponse = httpClient.execute(httpGet);

                // Check the status code
        // assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        Integer responseCode = response.getResponseCode();
        assertEquals(200, Optional.ofNullable(responseCode));

        // Check the response body


        // Print the response body
        HttpResponse httpResponse = new BasicHttpResponse;
        String responseBody = ResponseReader.convertStreamToString(httpResponse.getEntity().getContent());
        String line;
        StringBuilder responseContent = new StringBuilder();
        BufferedReader reader = null;
        while ((line = reader.readLine()) != null) {
            responseContent.append(line).append("\n");
        }
        reader.close();

        //  System.out.println("Response Body:");
        //  System.out.println(responseContent.toString());
        // Assign response content

        assertNotNull(responseString);

        System.out.println("Response Body:");
        System.out.println(responseString);


    }
}