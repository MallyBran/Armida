package com.example.projektb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VolenieObtiaznosti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volenie_obtiaznosti);
    }
    public void lahka(View view){
        startActivity(new Intent(getApplicationContext(),LahkaObtiaznost.class));
    }
    public void tazka(View view){
        startActivity(new Intent(getApplicationContext(), GameActual.class));
    }
    public void doMenu(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}