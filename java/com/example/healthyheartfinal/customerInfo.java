package com.example.healthyheartfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthyheartfinal.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customerInfo extends AppCompatActivity {

    public static final String username=  "username";
    private String userName;


//    ActivityMainBinding binding;
    String name, age, sex, cigperday, cholesterol, diabities, glucose;
    FirebaseDatabase db;
    DatabaseReference reference;

    EditText edittextname;
    EditText edittextage;
    EditText edittextsex;
    EditText edittextcigperday;
    EditText edittextcholesterol;
    EditText edittextdiabities;
    EditText edittextglucose;
    Button buttonSubmit;

    public void goToLogin(){
        Intent intent = new Intent(this, loginActivityHere.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_customer_info);

        Intent i = getIntent();
        userName = i.getStringExtra(username);


        buttonSubmit= findViewById(R.id.infoSubmit);
        edittextname = findViewById(R.id.infoName);
        edittextage = findViewById(R.id.infoAge);
        edittextcholesterol = findViewById(R.id.infoCholesterol);
        edittextglucose =  findViewById(R.id.infoGlucose);
        edittextdiabities = findViewById(R.id.infoDiabities);
        edittextsex =  findViewById(R.id.infoSex);
        edittextcigperday =  findViewById(R.id.infoCigperday);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, age, sex, cigperday, cholesterol, diabities, glucose;
//                email = String.valueOf(editTextEmail.getText());
//                password = String.valueOf(editTextPassword.getText());
                name= String.valueOf(edittextname.getText());
                age= String.valueOf(edittextage.getText());
                sex = String.valueOf(edittextsex.getText());
                cigperday =  String.valueOf(edittextcigperday.getText());
                cholesterol = String.valueOf(edittextcholesterol.getText());
                diabities = String.valueOf(edittextdiabities.getText());
                glucose = String.valueOf(edittextglucose.getText());

                if(!name.isEmpty() && !age.isEmpty() && !sex.isEmpty() && !cigperday.isEmpty() && !cholesterol.isEmpty() && !diabities.isEmpty() && !glucose.isEmpty()){

                    Users users =  new Users(userName,name, age, sex, cigperday, cholesterol,diabities, glucose );
                    db = FirebaseDatabase.getInstance();
                    reference =  db.getReference("Users");
                    reference.child(userName).setValue(users);

                    goToLogin();


                }
            }
        });
    }
}