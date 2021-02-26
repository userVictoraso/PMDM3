package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio2.Alarm.Alarm;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.MainActivity2;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding;

import java.util.ArrayList;

public class AlarmActivity extends AppCompatActivity {
    ArrayList<Alarm> alarmArrayList;
    ActivityAlarmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        alarmArrayList = MainActivity2.getArrayList();

    }
}