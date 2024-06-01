package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseReader {

    public static String convertStreamToString(InputStream is) {
        // This method is used to read the buffer and parse it as a text, i.e., to build a response body
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<>();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines.stream().collect(Collectors.joining("\n"));
    }
}