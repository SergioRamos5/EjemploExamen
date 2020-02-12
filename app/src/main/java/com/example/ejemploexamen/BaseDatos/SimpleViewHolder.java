package com.example.ejemploexamen.BaseDatos;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    TextView[] view = new TextView[4];

    public SimpleViewHolder(@NonNull View itemView, int[] to) {
        super(itemView);
        view[0] = itemView.findViewById(to[0]);
        view[1] = itemView.findViewById(to[1]);


    }

    public void bind(int pos, String dato)
    {
        view[pos].setText(dato);
    }

    public void bind(Bitmap dato)
    {


    }

}