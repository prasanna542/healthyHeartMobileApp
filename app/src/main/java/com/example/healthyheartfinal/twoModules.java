package com.example.healthyheartfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class twoModules extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;

    Toolbar toolbar;
    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_modules);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Healthy Heart");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Healthy Heart");


        mAuth = FirebaseAuth.getInstance();
        user =  mAuth.getCurrentUser();
        username = findViewById(R.id.username1);

        if(user!= null){
            String text= "Welcome "+ user.getEmail();
            username.setText(text);

        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();

        if(itemId==R.id.logoutoption){

//            FirebaseUser currentUser = mAuth.getCurrentUser();
//            mAuth.setCurrentUser();
//            mAuth.signOut();

            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    //    private void setSupportActionBar() {
//    }

    public void goToHealthTips(View view){
        Intent intent = new Intent(this, HealthTips.class);
        startActivity(intent);
    }

    public void goToCardioCheckerOptions(View view){
        Intent intent= new Intent(this, CardioCheckerOptions.class);
        startActivity(intent);
    }
}