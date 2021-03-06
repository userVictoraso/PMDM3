package com.example.pareja_ramirez_victor_datos.Ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {
    ActivityMain4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}