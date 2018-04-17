package com.example.rafaj.fragmentapp;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class Objetos implements Serializable {
    private String nombre;
    private String distancia;
    private int imagen;

    public Objetos(String nombre, String distancia, int imagen) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
