package com.example.projektb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void hraj(View view){
        startActivity(new Intent(getApplicationContext(), VolenieObtiaznosti.class));
    }
    public void pravidla(View view){
        startActivity(new Intent(getApplicationContext(), RulesOfTheGame.class));
    }
}