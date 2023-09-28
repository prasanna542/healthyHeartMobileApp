package com.example.healthyheartfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CardioCheckerOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_checker_options);
    }

    public void goToProUser(View view){
        Intent intent = new Intent(this, proUser.class);
        startActivity(intent);
//        finish();
    }

    public void goToHealthguard(View view){
        Intent intent = new Intent(this, healthGuard.class);
        startActivity(intent);
//        finish();
    }

}