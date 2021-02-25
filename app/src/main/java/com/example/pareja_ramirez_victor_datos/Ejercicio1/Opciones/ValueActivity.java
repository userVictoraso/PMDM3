package com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio1.MainActivity1;
import com.example.pareja_ramirez_victor_datos.MainActivity;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityColorBinding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityValueBinding;

public class ValueActivity extends AppCompatActivity {

    ActivityValueBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityValueBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Valor");

        binding.editTextValue.setText(String.valueOf(MainActivity1.getCoinValue()));
        setCoinValue();
    }

    public void setCoinValue(){
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity1.setCoinValue(Double.parseDouble(String.valueOf(binding.editTextValue.getText())));
                finish();
            }
        });
    }
}