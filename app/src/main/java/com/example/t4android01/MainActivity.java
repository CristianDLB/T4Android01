package com.example.t4android01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Btn1Crear = findViewById(R.id.btnCrear);
        Button Btn2Sincro = findViewById(R.id.btnSincronizar);
        Button Btn3Mostrar = findViewById(R.id.btnMostrar);

        Btn3Mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Mostrar.class);
                startActivity(intent);
            }
        });

        Btn1Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Crear.class);
                startActivity(intent);
            }
        });

        Btn2Sincro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sincronizar.class);
                startActivity(intent);
            }
        });


    }
}