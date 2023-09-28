package com.example.healthyheartfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivityHere extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
//            reload();
            Intent intent = new Intent(getApplicationContext(), twoModules.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_here);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail= findViewById(R.id.email1);
        editTextPassword= findViewById(R.id.password1);
        buttonLogin= findViewById(R.id.login_button1);
        progressBar= findViewById(R.id.progressBar1);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String getEmail, getPassword;
                getEmail = editTextEmail.getText().toString();
                getPassword = editTextPassword.getText().toString();

                if(TextUtils.isEmpty(getEmail)){
                    Toast.makeText(loginActivityHere.this, "enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(getPassword)){
                    Toast.makeText(loginActivityHere.this, "enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(getEmail, getPassword)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(loginActivityHere.this, "Login Successful",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), twoModules.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(loginActivityHere.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

    }



    public void goToTwoModules(View view){
        Intent intent1 = new Intent(this, twoModules.class);
        startActivity(intent1);
        Toast.makeText(this, "nice working so far", Toast.LENGTH_SHORT).show();
    }

    public void goToSignupPage(View view){
        Intent intent = new Intent(this, SignupPage.class);
        startActivity(intent);
    }

}