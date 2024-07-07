package tests;
import api.GetRequestExample;
import api.GetSingleRequestExample;
import helpers.ResponseReader;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetEmployees {
    @Test
    public void testGetEmployee() {
        try {
            // Call the method to get the employee
            HttpResponse response = GetRequestExample.getEmployees();;

            // Validate the status code
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals (200, statusCode, "Expected status code 200");

            // Read the response body
            String responseBody = ResponseReader.convertStreamToString(response.getEntity().getContent());
            System.out.println("Response Body:");
            System.out.println(responseBody);

            // Validate the response body (adjust the check as necessary based on API response format)
            Assert.assertTrue(responseBody.contains("\"status\":\"success\"") || responseBody.contains("\"employee_name\""),
                    "Response does not indicate success or does not contain employee details");


        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }
}


