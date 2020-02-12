package com.example.ejemploexamen.RecyclerNormal;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemploexamen.Ciudades;
import com.example.ejemploexamen.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    private Holder holder;
    private ArrayList<Ciudades> ciudades;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;
    private View.OnTouchListener listenerTouch;

    public Adaptador(ArrayList<Ciudades> ciudades) {
        this.ciudades = ciudades;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hodler, parent, false);

        holder = new Holder(v);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).bind(ciudades.get(position), position);
    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }

    public void setClickListener(View.OnClickListener listener)
    {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(v);
    }

    public void setLongListener(View.OnLongClickListener longListener)
    {
        if (longListener != null)
            this.longListener = longListener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (longListener != null)
            longListener.onLongClick(v);
        return true;
    }

    public void setTouchListener(View.OnTouchListener listenerTouch)
    {
        if (listenerTouch != null)
            this.listenerTouch = listenerTouch;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        if (listenerTouch != null)
            listenerTouch.onTouch(view, motionEvent);
        return false;
    }
}
