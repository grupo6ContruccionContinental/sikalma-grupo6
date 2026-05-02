package com.example.demo.Doctor;

import com.example.demo.Cita.Cita;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private int id;
    private String nombre;
    private String dni;
    private String especialidad;
    private String telefono;

    // Esta es la etiqueta que soluciona el Error 400
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private List<Cita> citas = new ArrayList<>();

    public Doctor () {}

    // Constructor con parámetros
    public Doctor(String nombre, String dni, String especialidad, String telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Cita> getCitas () {
        return citas;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}