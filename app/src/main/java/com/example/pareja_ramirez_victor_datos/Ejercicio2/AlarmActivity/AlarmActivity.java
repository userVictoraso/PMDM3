package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio2.Alarm.Alarm;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.MainActivity2;
import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding;

import java.util.ArrayList;

public class AlarmActivity extends AppCompatActivity {
    ArrayList<Alarm> alarmArrayList;
    ActivityAlarmBinding binding;

    private CountDownTimer timer;
    private long remainTime = 0;
    private boolean currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.pareja_ramirez_victor_datos.databinding.ActivityAlarmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        alarmArrayList = MainActivity2.getArrayList();
        goBack();
    }

    public void goBack(){
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void startTimer(int time, String description, String sound) {
        setAlarmTime(time);
        binding.editTextDescription.setText(description);
        timer = new CountDownTimer(getRemainTime(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainTime = millisUntilFinished;
                actualizarTemporizador();
            }

            @Override
            public void onFinish() {
                //MediaPlayer mp = MediaPlayer.create(this, R.raw.menu);
            }
        };
    }

    public void setAlarmTime(int time) {
        remainTime = time * 60000;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public String getSound(String sound) {
        return "R.raw." + sound;
    }

    public void actualizarTemporizador() {
        int min = (int) remainTime / 60000;
        int sec = (int) remainTime % 60000 / 1000;
        String remainTimeString;
        remainTimeString = "" + min;
        remainTimeString += ":";
        if (sec < 10) remainTimeString += "0";
        remainTimeString += sec;

        if (remainTimeString.equals("0:00")) {
            binding.editTextTime.setText("");
        } else {
            binding.editTextTime.setText(remainTimeString);
        }
        binding.editTextTime.addTextChangedListener(comprobar);
    }

    private TextWatcher comprobar = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String time = binding.editTextTime.getText().toString().trim();
        }
    };


}