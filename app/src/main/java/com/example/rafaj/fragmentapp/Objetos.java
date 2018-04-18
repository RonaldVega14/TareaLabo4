package com.example.rafaj.fragmentapp;


import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Objetos implements Parcelable {
    private String nombre;
    private String distancia;
    private String info;
    private int imagen;

    public Objetos(String nombre, String distancia, int imagen, String info) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.imagen = imagen;
        this.info = info;
    }

    protected Objetos(Parcel in) {
        nombre = in.readString();
        distancia = in.readString();
        imagen = in.readInt();
        info = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(distancia);
        dest.writeInt(imagen);
        dest.writeString(info);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Objetos> CREATOR = new Creator<Objetos>() {
        @Override
        public Objetos createFromParcel(Parcel in) {
            return new Objetos(in);
        }

        @Override
        public Objetos[] newArray(int size) {
            return new Objetos[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getDistancia() {
        return distancia;
    }

    public String getInfo() {
        return info;
    }

    public int getImagen() {
        return imagen;
    }
}