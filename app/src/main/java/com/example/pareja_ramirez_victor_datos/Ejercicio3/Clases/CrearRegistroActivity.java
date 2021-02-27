package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.databinding.ActivityCrearRegistroBinding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain3Binding;

public class CrearRegistroActivity extends AppCompatActivity {
    ActivityCrearRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    //DAR DE ALTA
    public void registrar(View view) {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
    }
}