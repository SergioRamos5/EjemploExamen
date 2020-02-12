package com.example.ejemploexamen.BaseDatos;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemploexamen.Ciudades;
import com.example.ejemploexamen.MainActivity;


public class MiRecyclerAdapter extends CursorRecyclerAdapterAbs implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    private int mLayout;
    private int[] mFrom;
    private int[] mTo;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;
    private View.OnTouchListener listenerTouch;
    private View view;


    public MiRecyclerAdapter(int layout, Cursor cursor, String[] from, int[] to) {
        super(cursor);
        mLayout = layout;
        mTo = to;
        findColumns(cursor, from);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);

        SimpleViewHolder holder = new SimpleViewHolder(view, mTo);

        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Cursor cursor) {

            ((SimpleViewHolder) holder).bind(0, cursor.getString(mFrom[0]));
            ((SimpleViewHolder) holder).bind(1, cursor.getString(mFrom[1]));

            /*Bitmap theImage = MainActivity.convertirStringBitmap(cursor.getString(mFrom[4]));
            ((SimpleViewHolder) holder).bind(theImage);*/

    }


    private void findColumns(Cursor c, String[] from)
    {
        if (c != null) {
            int i;
            int count = from.length;
            if (mFrom == null || mFrom.length != count)
                mFrom = new int[count];
            for (i = 0; i < count; i++)
                mFrom[i] = c.getColumnIndexOrThrow(from[i]);
        }
        else
            mFrom = null;
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

    public Ciudades getItem(int position)
    {
        getCursor().moveToPosition(position);
        return getContactoFromCursor(getCursor());
    }

    private Ciudades getContactoFromCursor(Cursor cursor){
        Ciudades c = new Ciudades();
        c.setPais(cursor.getString(0));
        c.setNombre(cursor.getString(1));
        c.setPoblacion(cursor.getString(2));

        return c;
    }
}