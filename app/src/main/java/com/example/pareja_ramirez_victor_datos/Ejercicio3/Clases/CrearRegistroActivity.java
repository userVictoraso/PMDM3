package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        String nombre = binding.editTextName.getText().toString();
        String link = binding.editTextLink.getText().toString();
        String email = binding.editTextEmail.getText().toString();
        String categoria = binding.editTextCategory.getText().toString();

        if(!nombre.isEmpty() && !link.isEmpty() && !email.isEmpty() && !categoria.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("link", link);
            registro.put("email", email);
            registro.put("categoria", categoria);

            db.insert("web", null, registro);
            db.close();
            Toast.makeText(this, "Registro realizado", Toast.LENGTH_SHORT).show();
            limpiarCampos();
        } else {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar(View view) {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = binding.editTextName.getText().toString();

        if (!nombre.isEmpty()) {
            Cursor cursor = db.rawQuery
                    ("select link, email from web where nombre=" + "'" + nombre + "'", null);

            if (cursor.moveToFirst()) {
                binding.editTextLink.setText(cursor.getString(0));
                binding.editTextEmail.setText(cursor.getString(1));
                db.close();
            } else {
                Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }
    }

    public void eliminar(View view) {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = binding.editTextName.getText().toString();

        if (!nombre.isEmpty()) {
            int cantidad = db.delete("web", "nombre=" + "'" + nombre + "'", null);
            db.close();

            limpiarCampos();

            if (cantidad == 1) {
                Toast.makeText(this, "Web eliminada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Web inexistente", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Introduce un nombre", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view) {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();


        String nombre = binding.editTextName.getText().toString();
        String link = binding.editTextLink.getText().toString();
        String email = binding.editTextEmail.getText().toString();
        String categoria = binding.editTextCategory.getText().toString();

        if(!nombre.isEmpty() && !link.isEmpty() && !email.isEmpty() && !categoria.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("nombre", nombre);
            registro.put("link", link);
            registro.put("email", email);
            registro.put("categoria", categoria);

            int cantidad = db.update("web", registro, "nombre=" + "'" + nombre + "'", null);
            db.close();

            if(cantidad == 1) {
                Toast.makeText(this, "Web modificada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarCampos(){
        binding.editTextName.setText("");
        binding.editTextLink.setText("");
        binding.editTextEmail.setText("");
        binding.editTextCategory.setText("");
    }
}