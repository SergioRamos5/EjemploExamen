package com.example.ejemploexamen.RecyclerNormal;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemploexamen.Ciudades;
import com.example.ejemploexamen.R;

public class Holder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

    TextView nombre, pais;

    public Holder(@NonNull View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.tv_nombre);
        pais = itemView.findViewById(R.id.tv_pais);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void bind(Ciudades ciudades, int position)
    {
        nombre.setText(ciudades.getNombre());
        pais.setText(ciudades.getPais());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(v.getContext());
        menuInflater.inflate(R.menu.contextual_flotante, menu);
    }


}
