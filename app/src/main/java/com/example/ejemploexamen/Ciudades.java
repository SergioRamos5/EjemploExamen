package com.example.ejemploexamen;

import android.os.Parcel;
import android.os.Parcelable;

public class Ciudades implements Parcelable {

    private String nombre;
    private String pais;
    private String poblacion;
    private boolean seleccionado;

    public Ciudades() {
    }

    public Ciudades(String nombre, String pais, String poblacion, boolean seleccionado) {
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
        this.seleccionado = seleccionado;
    }

    protected Ciudades(Parcel in) {
        nombre = in.readString();
        pais = in.readString();
        poblacion = in.readString();
        seleccionado = in.readByte() != 0;
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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
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
        dest.writeByte((byte) (seleccionado ? 1 : 0));
    }
}
