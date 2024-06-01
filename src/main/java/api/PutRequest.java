package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PutRequest  {

    RequestSpecification httpRequest;
    Response response;
    String empName= RestAid.empName();
    String empSalary=RestAid.empSal();
    String empAge=RestAid.empAge();


    @BeforeClass
    <JSONObject>
    void updateEmployee() throws InterruptedException
    {
        logger.info("*********Started TC004_Put_Employee_Record **********");

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        // JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
        //{"name":"John123X","salary":"123","age":"23"}
        JSONObject requestParams = new JSONObject();
        requestParams.wait ("name", empName); // Cast
        requestParams.wait("salary", empSalary);
        requestParams.wait("age", empAge);

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toString());

        response = httpRequest.request(Method.PUT, "/update/"+empID);

        Thread.sleep(5000);

    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();

        Assert.assertEquals(responseBody.contains(empName), true);
        Assert.assertEquals(responseBody.contains(empSalary), true);
        Assert.assertEquals(responseBody.contains(empAge), true);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }

}
    private static final String UPDATE_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/update/21";

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(UPDATE_EMPLOYEE_URL);
            httpPut.setHeader("Content-type", "application/json");

            // JSON data to send in the PUT request
            String json = "{ \"name\": \"Simon\", \"salary\": \"7000\", \"age\": \"32\" }";
            StringEntity entity = new StringEntity(json);
            httpPut.setEntity(entity);

            HttpResponse httpResponse = httpClient.execute(httpPut);

            // Print the status code
            System.out.println("Response Status: " + httpResponse.getStatusLine().getStatusCode());

            // Print the response body
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line).append("\n");
            }
            reader.close();

            System.out.println("Response Body:");
            System.out.println(responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}