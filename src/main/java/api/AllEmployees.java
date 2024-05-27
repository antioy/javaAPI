package api;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllEmployees  extends BaseTest {
    @BeforeClass
    void getAllEmployees() throws InterruptedException
    {
        logger.info("*********Started TC001_Get_All_Employees **********");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/employees");

        Thread.sleep(5);
    }

    @Test
    void checkResposeBody()
    {
        logger.info("***********  Checking Respose Body **********");

        String responseBody = response.getBody().asString();
        logger.info("Response Body==>"+responseBody);
        Assert.assertTrue(responseBody!=null);

    }

    @Test
    void checkStatusCode()
    {
        logger.info("***********  Checking Status Code **********");

        int statusCode = response.getStatusCode(); // Gettng status code
        logger.info("Status Code is ==>" + statusCode); //200
        Assert.assertEquals(statusCode, 200);

    }
    }

