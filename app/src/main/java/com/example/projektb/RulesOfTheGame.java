package com.example.projektb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesOfTheGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_of_the_game);
    }
    public void Return(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}