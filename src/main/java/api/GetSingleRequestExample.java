package api;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetSingleRequestExample {

    private static String viewSingleEmp = "https://dummy.restapiexample.com/api/v1/employee/";
    public static HttpResponse getEmployee() throws IOException {
        HttpGet getEmployee = new HttpGet(viewSingleEmp);
        getEmployee.setHeader("Content-type", "application/json");
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(getEmployee);

        return httpResponse;
    }
}

