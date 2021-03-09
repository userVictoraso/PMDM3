package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pareja_ramirez_victor_datos.Ejercicio3.MainActivity3;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityCrearRegistroBinding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain3Binding;

public class CrearRegistroActivity extends AppCompatActivity {
    ActivityCrearRegistroBinding binding;
    MainActivity3 mainActivity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void finish(View view) {
        finish();
    }

    //DAR DE ALTA
    public void registrar(View view) {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = binding.editTextName.getText().toString();
        String link = binding.editTextLink.getText().toString();
        String email = binding.editTextEmail.getText().toString();
        String categoria = binding.editTextCategory.getText().toString();
        String imagen = binding.editTextImage.getText().toString();

        if (!nombre.isEmpty() && !link.isEmpty() && !email.isEmpty() && !categoria.isEmpty() && !imagen.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("link", link);
            registro.put("email", email);
            registro.put("categoria", categoria);
            registro.put("imagen", imagen);

            db.insert("web", null, registro);
            db.close();
            Toast.makeText(this, "Registro realizado", Toast.LENGTH_SHORT).show();
            limpiarCampos();
            finish();
        } else {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(Web web, Context context) {
        try {
            SQLite admin = new SQLite(context, "myDataBase", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            int cantidad = db.delete("web", "nombre=" + "'" + web.getNombre() + "'", null);
            db.close();
            Toast.makeText(this, "Web borrada", Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e){

        }

    }

    public void limpiarCampos() {
        binding.editTextName.setText("");
        binding.editTextLink.setText("");
        binding.editTextEmail.setText("");
        binding.editTextCategory.setText("");
    }
}