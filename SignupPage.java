package com.example.healthyheartfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupPage extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    EditText edittextname;
    EditText edittextage;
    EditText edittextsex;
    EditText edittextcigperday;
    EditText edittextcholesterol;
    EditText edittextdiabities;
    EditText edittextglucose;



    Button buttonSignup;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    public void goToLogin(View view){
        Intent intent = new Intent(this, loginActivityHere.class);
        startActivity(intent);
        finish();
    }
    public void sendData(){

        String email2 = String.valueOf(editTextEmail.getText());
        Intent intent = new Intent(this, customerInfo.class);
        intent.putExtra(customerInfo.username, email2);
        startActivity(intent);
        finish();
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail= findViewById(R.id.email2);
        editTextPassword= findViewById(R.id.password2);
        buttonSignup= findViewById(R.id.createAccountButton);
        progressBar= findViewById(R.id.progressBar2);
//        edittextname = findViewById(R.id.nameinrecord);
//        edittextage = findViewById(R.id.ageinrecord);
//        edittextsex = findViewById(R.id.sexinrecord);
//        edittextcigperday =  findViewById(R.id.cigsperdayinrecord);
//        edittextcholesterol =  findViewById(R.id.cholesterolinrecord);
//        edittextdiabities =  findViewById(R.id.diabitiesinrecord);
//        edittextglucose = findViewById(R.id.glucoseinrecord);



        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password,name, age, sex, cigperday, cholesterol, diabities, glucose;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
//                name= String.valueOf(edittextname.getText());
//                age= String.valueOf(edittextage.getText());
//                sex = String.valueOf(edittextsex.getText());
//                cigperday =  String.valueOf(edittextcigperday.getText());
//                cholesterol = String.valueOf(edittextcholesterol.getText());
//                diabities = String.valueOf(edittextdiabities.getText());
//                glucose = String.valueOf(edittextglucose.getText());




                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignupPage.this, "enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignupPage.this, "enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information


                                    Toast.makeText(SignupPage.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();

//                                    Intent intent = new Intent(packageContext:this, twoModules.class);
//                                    startActivity(intent);
//                                    finish();
//                                    goToInfo();
                                    sendData();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignupPage.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });



    }
}