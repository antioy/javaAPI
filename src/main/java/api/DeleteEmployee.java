package api;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;

import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static junit.runner.Version.id;

public class DeleteEmployee {
    public static final String deleteURL = "https://dummy.restapiexample.com/api/v1/delete/";

    public static HttpResponse deleteEmployee(Integer id) throws IOException {
        HttpDelete deleteEmployee = new HttpDelete(deleteURL+ id());
        deleteEmployee.setHeader("Content-type", "application/json");
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(deleteEmployee);
        return httpResponse;
    }
}

