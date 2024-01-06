package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.Gson;

import models.Product;

public class ResponseReader {

    public <T> T readResponse(Class<T> responseType, String url) {
        try {
            // Make an HTTP request
            URL apiUrl = new URI(url).toURL();
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            // Read the JSON response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    String test = response.toString();

                    // Parse JSON response
                    Gson gson = new Gson();
                    Product[] data = gson.fromJson(test, Product[].class);
                    return null;
                }
            } else {
                System.out.println("HTTP request failed with response code: " + responseCode);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
