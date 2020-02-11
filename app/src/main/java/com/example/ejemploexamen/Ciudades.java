package com.example.ejemploexamen;

import android.os.Parcel;
import android.os.Parcelable;

public class Ciudades implements Parcelable {

    private String nombre;
    private String pais;
    private String poblacion;

    public Ciudades() {
    }

    public Ciudades(String nombre, String pais, String poblacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
    }

    protected Ciudades(Parcel in) {
        nombre = in.readString();
        pais = in.readString();
        poblacion = in.readString();
    }

    public static final Creator<Ciudades> CREATOR = new Creator<Ciudades>() {
        @Override
        public Ciudades createFromParcel(Parcel in) {
            return new Ciudades(in);
        }

        @Override
        public Ciudades[] newArray(int size) {
            return new Ciudades[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(pais);
        dest.writeString(poblacion);
    }
}
