package com.example.ejemploexamen.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OHCategoria extends SQLiteOpenHelper {

    String sentencia = "Create table if not exists Contactos(id INTEGER PRIMARY KEY AUTOINCREMENT ,pais TEXT, nombre TEXT, poblacion TEXT)";

    public OHCategoria(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}