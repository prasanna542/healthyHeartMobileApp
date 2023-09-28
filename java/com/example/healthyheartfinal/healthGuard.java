package com.example.healthyheartfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class healthGuard extends AppCompatActivity {

//    VideoView ecgVideo;
//    LineChart lineChart;
    TextView bpmvalue;

    public void showResult(View view){
        sendGetRequest();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_guard);
    }


    private void sendGetRequest(){

        RequestQueue queue = Volley.newRequestQueue(healthGuard.this);
        bpmvalue = findViewById(R.id.resulttext);


        String url = "https://industrial.api.ubidots.com/api/v1.6/devices/ecg_monitoring_system/heart_device1/values/?page_size=1&token=BBFF-n68A35Z6Riw5c1Osm9vNtpUTNfvgz4";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray resultsArray = jsonObject.getJSONArray("results");

                    if (resultsArray.length() > 0) {
                        JSONObject firstResult = resultsArray.getJSONObject(0);
                        double sensorValue = firstResult.getDouble("value");
                        String sensorValue2 = String.valueOf(sensorValue);
//                        bpmvalue.setText((int) sensorValue);
                        // Create and display a short duration toast
                        Toast.makeText(getApplicationContext(), "BPM:"+ sensorValue, Toast.LENGTH_SHORT).show();
                        bpmvalue.setText("BPM:"+ sensorValue2);


//                        Toast.makeText("Sensor Value: "+ sensorValue, Toast.LENGTH_SHORT).show();
//                        Toast.makeText( "Sensor Value: " + sensorValue, Toast.LENGTH_SHORT).show();
                        // Now 'sensorValue' contains the ECG sensor value (e.g., 65.0)
                        // You can use it as needed, such as displaying it in your app's UI
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                bpmvalue.setText("Sorry :(, please check your internet connection");

            }
        });
        queue.add(stringRequest);

    }
}