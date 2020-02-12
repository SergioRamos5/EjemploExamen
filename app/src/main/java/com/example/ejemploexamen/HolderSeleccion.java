package com.example.ejemploexamen;

import android.view.View;
import android.view.ViewOverlay;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemploexamen.Ciudades;
import com.example.ejemploexamen.R;

public class HolderSeleccion extends RecyclerView.ViewHolder {

    TextView nombre, pais;
    View viewOverlay;

    public HolderSeleccion(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.tv_nombre);
        pais = itemView.findViewById(R.id.tv_pais);
        viewOverlay = itemView.findViewById(R.id.selected_overlay);
    }

    public void bind(Ciudades ciudades, int position)
    {
        nombre.setText(ciudades.getNombre());
        pais.setText(ciudades.getPais());
        viewOverlay.setVisibility(ciudades.isSeleccionado() ? View.VISIBLE : View.INVISIBLE);
    }
}
