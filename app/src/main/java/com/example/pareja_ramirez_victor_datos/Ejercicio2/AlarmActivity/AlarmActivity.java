package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
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
    int countAlarms = 0;
    int remainsAlarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Alarmas");
        alarmArrayList = MainActivity2.getArrayList();
        remainsAlarms = getAlarmArrayList().size();
        goBack();

        if(!getAlarmArrayList().isEmpty()){
            executeAlarm();
        }
    }

    public void executeAlarm() {
        Alarm currentAlarm = getAlarmArrayList().get(getCountAlarms());
        long time = currentAlarm.getTime() * 60000;
        binding.editTextDescription.setText(currentAlarm.getDesc());
        binding.textViewNumberOfRemainAlarms.setText(String.valueOf(remainsAlarms));

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
                String soundName = getAlarmArrayList().get(getCountAlarms()).getSound();
                Uri uri = Uri.parse("android.resource://com.example.pareja_ramirez_victor_datos/raw/" + soundName);

                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), uri);
                    mp.start();
                setCountAlarms(getCountAlarms() + 1);
                remainsAlarms = remainsAlarms - 1;
                if (remainsAlarms == 1) {
                    remainsAlarms = 0;
                }
                if (getCountAlarms() < getAlarmArrayList().size()) {
                    executeAlarm();
                }
            }
        }.start();
    }

    public void goBack() {
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public ArrayList<Alarm> getAlarmArrayList() {
        return alarmArrayList;
    }

    public int getCountAlarms() {
        return countAlarms;
    }

    public void setCountAlarms(int countAlarms) {
        this.countAlarms = countAlarms;
    }


}