package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.Gson;

public class ResponseReader {

    public <T> T readResponse(Class<T> responseType, String url) {
        try {
            // Make an HTTP request
            URL apiUrl = new URI(url).toURL();
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            // Read the JSON response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON response
                Gson gson = new Gson();
                T data = gson.fromJson(response.toString(), responseType);

                return data;

            } else {
                System.out.println("HTTP request failed with response code: " + responseCode);
            }

            // Close the HTTP connection
            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

}
