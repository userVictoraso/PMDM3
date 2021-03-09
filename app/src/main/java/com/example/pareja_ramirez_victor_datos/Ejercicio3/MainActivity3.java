package com.example.pareja_ramirez_victor_datos.Ejercicio3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio3.Adapter.MyAdapter;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Adapter.RecyclerTouchListener;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.CrearRegistroActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.ModifRegistroActivity;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.SQLite;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.Web;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Web> webArrayList = new ArrayList<>();
    CrearRegistroActivity crearRegistroActivity = new CrearRegistroActivity();
    ActivityMain3Binding binding;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        refreshList();
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, CrearRegistroActivity.class));
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(llm);
        myAdapter = new MyAdapter(this, getWebs());
        binding.recyclerView.setAdapter(myAdapter);
        setRecyclerActions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    public void setRecyclerActions(){
        binding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener
                (getApplicationContext(), binding.recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Web web = webArrayList.get(position);
                Intent intent = new Intent(MainActivity3.this, ModifRegistroActivity.class);
                intent.putExtra("nombre", web.getNombre());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                final Web web = webArrayList.get(position);
                AlertDialog dialog = new AlertDialog
                        .Builder(MainActivity3.this)
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                crearRegistroActivity.eliminar(web, getBaseContext());
                                refreshList();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setTitle("Confirmar")
                        .setMessage("¿Deseas eliminar la web " + web.getNombre() + "?")
                        .create();
                dialog.show();
            }
        }));
    }

    public ArrayList<Web> getWebs() {
        webArrayList.clear();
        final String tableName = "web";
        SQLite admin = new SQLite(this, "myDataBase", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String[] columns = {"nombre", "link", "email", "categoria", "imagen"};
        Cursor cursor = db.query(tableName, columns, null, null, null, null, null);

        if (cursor == null) {
            return webArrayList;
        }
        if (!cursor.moveToFirst()) return webArrayList;

        do {
            String webName = cursor.getString(0);
            String webLink = cursor.getString(1);
            String webEmail = cursor.getString(2);
            String webCategory = cursor.getString(3);
            String webImage = cursor.getString(4);

            Web web = new Web(webName, webLink, webEmail, webCategory, webImage);
            webArrayList.add(web);
        } while (cursor.moveToNext());

        cursor.close();
        return webArrayList;
    }

    public void refreshList() {
        if (myAdapter == null) return;
        webArrayList = getWebs();
        myAdapter.setWebs(webArrayList);
        myAdapter.notifyDataSetChanged();
    }
}