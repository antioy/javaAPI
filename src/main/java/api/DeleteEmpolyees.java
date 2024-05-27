package api;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteEmpolyees  extends BaseTest {
    RequestSpecification httpRequest;
    Response response;

    @BeforeClass
    void deleteEmployee() throws InterruptedException
    {
        logger.info("*********Started TC005_Delete_Employee_Record **********");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        response = httpRequest.request(Method.GET, "/employees");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        //Capture id
        String empID=jsonPathEvaluator.get("[0].id");
        response = httpRequest.request(Method.DELETE, "/delete/"+empID); //Pass ID to delete record

        Thread.sleep(3000);
    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);

    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }
}
