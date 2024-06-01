package tests;
import api.PostRequests;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import javax.swing.text.html.parser.DTD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static api.PostRequests.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PostEmployee {
    @Test
    public void testCreateEmployee() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PostRequests);

        // Check the status code


        // Check the response body
        HttpResponse httpResponse;
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

