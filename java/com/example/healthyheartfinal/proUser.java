package com.example.healthyheartfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class proUser extends AppCompatActivity {

    EditText agef, sexf, cigsf, cholf, sBPf, diaf, dBPf, glucf, hRatef;
    //    Button predict;
    Button predict;
    TextView result;

    //    CardView predict;
//    String url = "https://final-version-healthy-heart.onrender.com/predict";


    public void showResult(View view){
        sendGetRequest();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pro_user_activity);
    }

    private void sendGetRequest(){

        RequestQueue queue = Volley.newRequestQueue(proUser.this);


        result = findViewById(R.id.result);
        agef = findViewById(R.id.age);
//        age, sex, cigs, chol, sBP, dia, dBP, gluc, hRate;
        sexf = findViewById(R.id.sex);
        cigsf = findViewById(R.id.cigs);
        cholf = findViewById(R.id.chol);
        sBPf = findViewById(R.id.sBP);
        diaf = findViewById(R.id.dia);
        dBPf = findViewById(R.id.dBP);
        glucf = findViewById(R.id.gluc);
        hRatef = findViewById(R.id.hRate);


        String age,sex,cigs,chol,sBP,dia,dBP,gluc,hRate;
        age= agef.getText().toString();
        sex= sexf.getText().toString();
        cigs = cigsf.getText().toString();
        chol = cholf.getText().toString();
        sBP= sBPf.getText().toString();
        dia= diaf.getText().toString();
        dBP = dBPf.getText().toString();
        gluc= glucf.getText().toString();
        hRate = hRatef.getText().toString();

        String url = "https://final-version-healthy-heart.onrender.com/predict?age="+age+"&sex="+sex+"&cigs="+cigs+"&chol="+chol+"&sBP="+sBP+"&dia="+dia+"&dBP="+dBP+"&gluc="+gluc+"&hRate="+hRate;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String pred = jsonObject.getString("prediction");
                    if(pred.equals("1")){
                        result.setText("high chances of having heart disease");
                    }
                    else {
                        result.setText("very low chances of having heart disease");
                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText("Sorry :(, please check your internet connection");

            }
        });
        queue.add(stringRequest);

    }

}










