package com.example.pareja_ramirez_victor_datos.Ejercicio3.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pareja_ramirez_victor_datos.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView cover;
    TextView titulo, autor;
    ItemClickListener itemClickListener;

    MyHolder(@NonNull View itemView) {
        super(itemView);

        this.cover = itemView.findViewById(R.id.imageTv);
        this.titulo = itemView.findViewById(R.id.tituloLibro);
        this.autor = itemView.findViewById(R.id.autorLibro);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }

}
