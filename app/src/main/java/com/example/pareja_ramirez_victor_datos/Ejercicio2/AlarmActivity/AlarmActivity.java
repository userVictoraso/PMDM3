package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.pareja_ramirez_victor_datos.Ejercicio2.Alarm.Alarm;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.MainActivity2;
import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AlarmActivity extends AppCompatActivity {
    ArrayList<Alarm> alarmArrayList;
    ActivityAlarmBinding binding;
    final String endAlarm = "0 min, 0 sec";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        alarmArrayList = MainActivity2.getArrayList();
        goBack();

        for (Alarm alarm : alarmArrayList) {
            //TODO: QUE NO SE SUPERPONGAN LAS ALARMAS, ESPERAR A QUE TERMINE LA ANTERIOR
            long time = alarm.getTime() * 60000;
            binding.editTextDescription.setText(alarm.getDesc());
            new CountDownTimer(time, 1000) {
                public void onTick(long millisUntilFinished) {
                    binding.editTextTime.setText("" + String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }
                public void onFinish() {
                    Toast.makeText(getBaseContext(), "Alarma finalizada",
                            Toast.LENGTH_SHORT).show();
                    //TODO: HACER QUE SUENE, QUE COJA BIEN EL ARCHIVO MP3
                }
            }.start();
        }
    }

    public void goBack() {
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}