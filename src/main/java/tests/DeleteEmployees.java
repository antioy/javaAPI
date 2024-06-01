package tests;
import com.sun.glass.ui.Accessible;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static api.DeleteEmployee.*;
public class DeleteEmployees {
    @Test
    public void testDeleteEmployee() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(DeleteEmployees.*);
        httpDelete.setHeader("Content-type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpDelete);

        // Check the status code
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());



        System.out.println("Response Body:");
        Accessible responseContent;
        System.out.println(responseContent.toString());

        // Ensure the response body is not empty
        assertNotNull("Response body should not be null", responseContent.toString());


    }
}
