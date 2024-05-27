package api;

import base.BaseTest;
import helpers.RestAid;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PostRequests extends BaseTest {

    RequestSpecification httpRequest;
    Response response;

    String empName = RestAid.empName();
    String empSalary = RestAid.empSal();
    String empAge = RestAid.empAge();


    @BeforeClass
    void createEmployee() throws InterruptedException {
        logger.info("*********Started TC003_Post_Employee_Record **********");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        // JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
        //{"name":"John123X","salary":"123","age":"23"}
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", empName); // Cast
        requestParams.put("salary", empSalary);
        requestParams.put("age", empAge);

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        response = httpRequest.request(Method.POST, "/create");

        Thread.sleep(5000);

    }

    @Test
    void checkResposeBody() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(empName), true);
        Assert.assertEquals(responseBody.contains(empSalary), true);
        Assert.assertEquals(responseBody.contains(empAge), true);
    }

    @Test
    void checkStatusCode() {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }
}
