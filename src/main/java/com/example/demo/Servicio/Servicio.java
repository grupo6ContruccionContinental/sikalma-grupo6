package com.example.demo.Servicio;

public class Servicio {

    private int id;
    private String nombre;

    public Servicio() {}

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}