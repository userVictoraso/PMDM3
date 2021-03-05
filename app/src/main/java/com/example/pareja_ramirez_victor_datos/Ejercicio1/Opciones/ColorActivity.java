package com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pareja_ramirez_victor_datos.Ejercicio1.MainActivity1;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityColorBinding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain1Binding;

public class ColorActivity extends AppCompatActivity {

    ActivityColorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityColorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Color");

        setYellowBackground();
        setBlueBackground();
        setGreenBackground();
    }

    public void setYellowBackground(){
        binding.redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity1.changeAppBackground(Color.parseColor("#FFFAE878"));
            }
        });
    }

    public void setBlueBackground(){
        binding.blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity1.changeAppBackground(Color.parseColor("#64AAFF"));
            }
        });
    }

    public void setGreenBackground(){
        binding.greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity1.changeAppBackground(Color.parseColor("#80FB6A"));
            }
        });
    }
}