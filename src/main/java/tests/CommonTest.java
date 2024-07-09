package tests;
import api.GetSingleRequestExample;
import helpers.ResponseReader;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import api.GetRequestExample;
import api.GetSingleRequestExample;
import helpers.ResponseReader;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import api.PostRequests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import api.PutRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;

import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonTest {

    private static String json;
    private static String name = "Simon";
    private static Integer salary = 5000;
    private static Integer age = 30;
    private static Integer id = 2;

    @BeforeTest
    public static void setup() {
        json = "{ \"name\": \""+name+"\", \"salary\": \""+salary+"\", \"age\": \""+age+"\" }";
    }

    @Test
    public void testCreateEmployee() throws IOException {
        // Initialise Post request
        PostRequests httpPost = new PostRequests();
        httpPost.execute(json);
        // Get the responseBody code
        Integer statusCode = httpPost.statusCode;
        // Get the responseBody body
        String responseBody = httpPost.responseBody;

        //System.out.println("Response code: " + statusCode);
        //System.out.println("Response body: " + responseBody);

        // Ensure the responseCode is 200
        assertEquals("ERROR: response not expected!", "200", statusCode.toString());
        // Ensure the response body is not null
        assertNotNull("ERROR: Response body should not be null", responseBody);
        // Ensure the response data contains the expected inputs - name, salary and age
        Assert.assertTrue(responseBody.contains(name), "ERROR: Response body does not contain the expected name Simon!");
        Assert.assertTrue(responseBody.contains(salary.toString()), "ERROR: Response body does not contain the expected salary of 5000!");
        Assert.assertTrue(responseBody.contains(age.toString()), "ERROR: Response body does not contain the expected age 30!");
    }



    @Test
    public void testUpdateEmployee() throws IOException {
        // Initialise Post request
        PutRequest putRequest = new PutRequest();
        putRequest.putNewUser(json, id);
        // Get the responseBody code
        Integer statusCode = putRequest.statusCode;
        // Get the responseBody body
        String responseBody = putRequest.responseBody;

        //System.out.println("Response code: " + statusCode);
        //System.out.println("Response body: " + responseBody);

        // Ensure the responseCode is 200
        assertEquals("ERROR: response not expected!", "200", statusCode.toString());
        // Ensure the response body is not null
        assertNotNull("ERROR: Response body should not be null", responseBody);
        // Ensure the response data contains the expected inputs - name, salary and age
        Assert.assertTrue(responseBody.contains(name), "ERROR: Response body does not contain the expected name Simon!");
        Assert.assertTrue(responseBody.contains(salary.toString()), "ERROR: Response body does not contain the expected salary of 5000!");
        Assert.assertTrue(responseBody.contains(age.toString()), "ERROR: Response body does not contain the expected age 30!");
    }

      @Test
      public void testDeleteEmployee() {
          try {
              // Call the method to get the employees
              HttpResponse deleteResponse = api.DeleteEmployee.deleteEmployee(2);

              // Call the method to get the employees
              HttpResponse getResponse = GetSingleRequestExample.getEmployee(id);

              // Call the method to get the employee
              HttpResponse response = GetSingleRequestExample.getEmployee(id);

              // Validate the status code
              int statusCode = response.getStatusLine().getStatusCode();
              Assert.assertEquals(statusCode, 200, "Expected status code 200");

              // Read the response body
              String responseBody = ResponseReader.convertStreamToString(response.getEntity().getContent());
              System.out.println("Response Body:");
              System.out.println(responseBody);

              // Validate the response body (adjust the check as necessary based on API response format)
              Assert.assertTrue(responseBody.contains("\"status\":\"success\""),
                      "Response does not indicate success");
          } catch (IOException e) {
              e.printStackTrace();
              Assert.fail("IOException occurred: " + e.getMessage());

          }
      }
}

