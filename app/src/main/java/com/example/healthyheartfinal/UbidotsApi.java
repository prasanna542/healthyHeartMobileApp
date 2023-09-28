package com.example.healthyheartfinal;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UbidotsApi {

//    private static final String api_url = "https://industrial.api.ubidots.com/api/v1.6/devices/ecg_monitoring_system/heart_device1/values/?page_size=1&token=BBFF-n68A35Z6Riw5c1Osm9vNtpUTNfvgz4";


    public static void fetchSensorData(Context context) {
        String url = "https://industrial.api.ubidots.com/api/v1.6/devices/ecg_monitoring_system/heart_device1/values/?page_size=1&token=BBFF-n68A35Z6Riw5c1Osm9vNtpUTNfvgz4";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            if (response.length() > 0) {
                                JSONObject data = response.getJSONObject(0);
                                // Parse the data and do something with it
                                String sensorValue = data.getString("value");
                                // Display the sensor value in your app
                                Toast.makeText(context, "Sensor Value: " + sensorValue, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Add the request to the Volley request queue
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }




}
//    ============================================================================================================================================
//    private static final String BASE_URL = "https://industrial.api.ubidots.com/api/v1.6/";
//    private static final String DEVICE_LABEL = "ecg_monitoring_system";
//    private static final String VARIABLE_LABEL = "heart_device1";
////    private static final String[] VARIABLE_LABELS = {"variable1-label", "variable2-label", "variable3-label"};
//    private static final String API_TOKEN = "BBFF-n68A35Z6Riw5c1Osm9vNtpUTNfvgz4";


