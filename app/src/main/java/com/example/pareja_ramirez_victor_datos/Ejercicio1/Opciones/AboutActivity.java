package com.example.pareja_ramirez_victor_datos.Ejercicio1.Opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio1.Perfil.Perfil;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {
    Perfil myProfile;
    ActivityAboutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("About Us");

        createProfile();
        binding.nombre.setText(myProfile.getNombre());
        binding.apellidos.setText(myProfile.getApellidos());
        binding.edad.setText(String.valueOf(myProfile.getEdad()));
        binding.colegio.setText(myProfile.getColegio());
        binding.profesor.setText(myProfile.getProfesor());
    }

    public void createProfile(){
        myProfile = new Perfil("Victor", "Pareja Ramirez", 23, "IES Portada", "Paco García");
    }
}