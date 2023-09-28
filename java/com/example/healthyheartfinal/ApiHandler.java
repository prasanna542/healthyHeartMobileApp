package com.example.healthyheartfinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ApiHandler {

    public String sendGetRequest(String apiUrl, Map<String, String> parameters) {
        try {
            // Construct the URL with parameters
            StringBuilder params = new StringBuilder();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                if (params.length() != 0) {
                    params.append("&");
                }
                params.append(entry.getKey()).append("=").append(entry.getValue());
            }
            URL url = new URL(apiUrl + "?" + params.toString());

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the connection properties
            connection.setRequestMethod("GET");
//            connection.setReadTimeout(15000);
//            connection.setConnectTimeout(15000);

            // Get the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
