package com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import androidx.annotation.Nullable;
import com.example.pareja_ramirez_victor_datos.R;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
