package com.example.pareja_ramirez_victor_datos.Ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio2.AlarmActivity.AlarmActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio2.MainActivity2;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Adapter.MyAdapter;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.CrearRegistroActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.SQLite;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.Web;
import com.example.pareja_ramirez_victor_datos.R;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Web> webArrayList = new ArrayList<>();

    ActivityMain3Binding binding;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, CrearRegistroActivity.class));
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(llm);
        myAdapter = new MyAdapter(this, getMyList());
        binding.recyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Web> getMyList(){
        //TODO: Cargar el arraylist con los registros de la BD.
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Web web;

        //CREAMOS LOS LIBROS
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "http://l.yimg.com/a/i/us/we/52/21.gif");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);
        web = new Web("Google", "www.google.es", "google@gmail.com", "Buscador web", "https://www.hola.com/imagenes/estar-bien/20201027177994/cosas-asustan-gatos-gt/0-882-234/gato-m.jpg");
        webArrayList.add(web);

        return webArrayList;
    }
}