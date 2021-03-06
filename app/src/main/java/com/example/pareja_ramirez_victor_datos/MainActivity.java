package com.example.pareja_ramirez_victor_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio1.MainActivity1;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.MainActivity2;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.MainActivity3;
import com.example.pareja_ramirez_victor_datos.Ejercicio4.MainActivity4;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain3Binding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        activityOne();
        activityTwo();
        activityThree();
        activityFour();
    }

    public void activityOne(){
        binding.buttonA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity1.class));
            }
        });
    }
    public void activityTwo(){
        binding.buttonA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
    public void activityThree(){
        binding.buttonA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });
    }
    public void activityFour(){
        binding.buttonA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity4.class));
            }
        });
    }
}