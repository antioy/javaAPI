package tests;

import api.PostRequests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPostEmployee {
    static String json;
    static String name = "Tony";
    static Integer salary = 4000;
    static Integer age = 23;

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
}

