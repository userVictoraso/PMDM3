package com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {


    final String[] googleData = {"Google", "www.google.es", "google@gmail.com", "Web", "https://www.axarquiaplus.es/wp-content/uploads_cloud/2020/12/image-20150902-6700-t2axrz-1200x1200.jpg"};
    final String[] instagramData = {"Instagram", "www.instagram.es", "instagram@gmail.com", "Red Social", "https://cocemfealicante.org/wp-content/uploads/2015/06/Instagram-logo-300x169.png"};
    final String[] amazonData = {"Amazon", "www.amazon.es", "amazon@gmail.com", "Tienda", "https://images-eu.ssl-images-amazon.com/images/G/30/gc/designs/livepreview/amz_squid_noto_printfold_v2016_es-main._CB462074126_.png"};

    public SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase webDB) {
        webDB.execSQL("create table web(nombre text, link text, email text, categoria text, imagen text)");
        fillDB(googleData, webDB);
        fillDB(instagramData, webDB);
        fillDB(amazonData, webDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void fillDB(String[] data, SQLiteDatabase webDB) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", data[0]);
        contentValues.put("link", data[1]);
        contentValues.put("email", data[2]);
        contentValues.put("categoria", data[3]);
        contentValues.put("imagen", data[4]);
        webDB.insert("web", null, contentValues);
    }
}
