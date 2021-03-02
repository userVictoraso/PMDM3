package com.example.pareja_ramirez_victor_datos.Ejercicio3.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.AsyncTaskLoadImage;
import com.example.pareja_ramirez_victor_datos.Ejercicio3.Clases.Web;
import com.example.pareja_ramirez_victor_datos.R;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Web> webs;

    public MyAdapter(Context c, ArrayList<Web> models) {
        this.c = c;
        this.webs = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view); //this returns our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        holder.titulo.setText(webs.get(i).getNombre());
        holder.autor.setText(webs.get(i).getLink());
        new AsyncTaskLoadImage(holder.cover).execute(webs.get(i).getImagen());


        holder.setItemClickListener(new ItemClickListener() {
            public void onItemClickListener(View v, int position) {
                Context context = c.getApplicationContext();
                CharSequence text = webs.get(position).getNombre() + " - " + webs.get(position).getLink() + " - " + webs.get(position).getEmail();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    public Bitmap LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return webs.size();
    }
}

