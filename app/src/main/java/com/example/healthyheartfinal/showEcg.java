package com.example.healthyheartfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


public class showEcg extends AppCompatActivity {

    TextView bpmvalue;
    String variableValue;


    public void showResult(View view){
        sendGetRequest();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.bpmValue);

//        UbidotsApi.fetchSensorData(this);--------------------------------------------------------------------------------

    }

    private void sendGetRequest(){

        RequestQueue queue = Volley.newRequestQueue(showEcg.this);


        bpmvalue = findViewById(R.id.bpmValue);


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

























































//    private void parseResponse(JSONArray response) {
//        List<Entry> entries = new ArrayList<>();
//
//        try {
//            for (int i = 0; i < response.length(); i++) {
//                JSONObject dataPoint = response.getJSONObject(i);
//                long timestamp = dataPoint.getLong("timestamp");
//                float value = (float) dataPoint.getDouble("value");
//
//                // Add data to the lists
//                timestamps.add(timestamp);
//                ecgValues.add(value);
//
//                // Ensure we only keep the last MAX_DATA_POINTS data points
//                if (timestamps.size() > MAX_DATA_POINTS) {
//                    timestamps.remove(0);
//                    ecgValues.remove(0);
//                }
//
//                entries.add(new Entry(timestamp, value));
//            }
//
//            LineData lineData = ecgChart.getData();
//            ILineDataSet dataSet = lineData.getDataSetByIndex(0);
//            if (dataSet == null) {
//                dataSet = new LineDataSet(entries, "ECG Data");
//                lineData.addDataSet(dataSet);
//            } else {
//                dataSet.clear();
//                for (Entry entry : entries) {
//                    dataSet.addEntry(entry); // Correct method call
//                }
//
//            }

//            lineData.notifyDataChanged();
//            ecgChart.notifyDataSetChanged();
//            ecgChart.invalidate();
//
//            // Calculate BPM
//            if (timestamps.size() >= 2) {
//                long timeDifference = timestamps.get(timestamps.size() - 1) - timestamps.get(0);
//                float ecgRange = Collections.max(ecgValues) - Collections.min(ecgValues);
//                float bpm = (timestamps.size() - 1) * 60000 / timeDifference;
//
//
//                textView.setText((int) bpm);
//                // Update your UI or do something with the BPM value
//                Log.d("BPM", "Beats per minute: " + bpm);
//            }
//
//        } catch (JSONException e) {
//            Log.e("JSON_ERROR", "Error parsing JSON response: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        handler.removeCallbacks(updateRunnable);
//    }
//}