package com.example.pareja_ramirez_victor_datos.Ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.RecyclerView;

import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.Web;
import com.example.pareja_ramirez_victor_datos.Ejercicio4.Adapter.MyAdapter;
import com.example.pareja_ramirez_victor_datos.databinding.ActivityMain4Binding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    ActivityMain4Binding binding;
    MyAdapter myAdapter;
    RecyclerView rv_list;

    private static final String AUTHORITY = "com.example.pareja_ramirez_victor_datos.Ejercicio3";
    private static final String BASE_PATH = "web";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    private static final int CONTACTS = 1;
    private static final int CONTACT_ID = 2;
    private boolean firstTimeLoaded = false;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, CONTACTS);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", CONTACT_ID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //TODO: que cargue el adapter
    }

    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        if (id == 0) {
            return new CursorLoader(this, CONTENT_URI, null, null, null, null);
        }
        return null;

    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        ArrayList<Web> list = new ArrayList<>();

        while (cursor.moveToNext()) {

            String name = cursor.getString(0);
            String link = cursor.getString(1);
            String email = cursor.getString(2);
            String category = cursor.getString(3);
            String image = cursor.getString(4);

            Web web = new Web(name, link, email, category, image);
            list.add(web);
        }

        myAdapter = new MyAdapter(this, list);
        rv_list.setAdapter(myAdapter);


    }
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}