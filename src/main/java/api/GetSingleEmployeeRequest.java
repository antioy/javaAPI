package api;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleEmployeeRequest extends BaseTest {

    RequestSpecification httpRequest;
    Response response;

    @BeforeClass
    void getEmployeeData() throws InterruptedException
    {
        logger.info("*********Started TC002_Get_Single_Employee_Record **********");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/employee/"+empID);

        Thread.sleep(7000);
    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(empID), true);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }