package tests;
import helpers.ResponseReader;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DeleteTest {



    @Test
    public void testDeleteEmployee() {
        try {
            // Call the method to get the employees
            HttpResponse response = api.DeleteEmployee.deleteEmployee(2);

            // Validate the status code
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, 200, "Expected status code 200");

            // Read the response body
            String responseBody = ResponseReader.convertStreamToString(response.getEntity().getContent());
         //   System.out.println("Response Body:");
         //   System.out.println(responseBody);

            // Validate the response body (adjust the check as necessary based on API response format)
            Assert.assertTrue(responseBody.contains("\"status\":\"success\""),
                    "Response does not indicate success");

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }
}




