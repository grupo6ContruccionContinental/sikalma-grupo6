package com.example.demo.Servicio;

import com.example.demo.Cita.Cita;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private int id;
    private String nombre;
    private String descripcion;
    private double costo;
    private List<Cita> citas = new ArrayList<>();

    public Servicio () {}

    public Servicio(String nombre, String descripcion, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
