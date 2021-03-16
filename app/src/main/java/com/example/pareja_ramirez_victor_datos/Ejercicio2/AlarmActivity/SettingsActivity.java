package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivitySettingsBinding;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {
    ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setTitle("Ajustes");
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new SettingsFragment() ,"fragment");
        transaction.addToBackStack(null);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            transaction.commit();
        }
    }
}