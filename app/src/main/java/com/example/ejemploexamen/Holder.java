package com.example.ejemploexamen;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    TextView nombre, pais;

    public Holder(@NonNull View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.tv_nombre);
        pais = itemView.findViewById(R.id.tv_pais);
    }

    public void bind(Ciudades ciudades, int position)
    {
        nombre.setText(ciudades.getNombre());
        pais.setText(ciudades.getPais());
    }
}
