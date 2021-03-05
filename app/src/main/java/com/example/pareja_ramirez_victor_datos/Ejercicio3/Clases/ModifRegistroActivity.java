package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pareja_ramirez_victor_datos.databinding.ActivityCrearRegistroBinding;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityModifRegistroBinding;

public class ModifRegistroActivity extends AppCompatActivity {
    ActivityModifRegistroBinding binding;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityModifRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        extras = getIntent().getExtras();
        if (extras == null) {
            finish();
        }

        buscar();
        binding.buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificar();
            }
        });

    }

    public void finish(View view) {
        finish();
    }

    public void modificar() {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = binding.editTextName.getText().toString();
        String link = binding.editTextLink.getText().toString();
        String email = binding.editTextEmail.getText().toString();
        String categoria = binding.editTextCategory.getText().toString();
        String imagen = binding.editTextImage.getText().toString();


        if (!nombre.isEmpty() && !link.isEmpty() && !email.isEmpty() && !categoria.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("nombre", nombre);
            registro.put("link", link);
            registro.put("email", email);
            registro.put("categoria", categoria);
            registro.put("imagen", imagen);

            int cantidad = db.update("web", registro, "nombre=" + "'" + extras.getString("nombre") + "'", null);
            db.close();

            if (cantidad == 1) {
                Toast.makeText(this, "Web modificada", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscar() {
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor cursor = db.rawQuery
                ("select nombre, link, email, categoria, imagen from web where nombre=" + "'" + extras.getString("nombre") + "'", null);

        if (cursor.moveToFirst()) {
            binding.editTextName.setText(cursor.getString(0));
            binding.editTextLink.setText(cursor.getString(1));
            binding.editTextEmail.setText(cursor.getString(2));
            binding.editTextCategory.setText(cursor.getString(3));
            binding.editTextImage.setText(cursor.getString(4));
            db.close();
        } else {
            Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
}
