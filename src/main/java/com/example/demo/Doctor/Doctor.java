package com.example.demo.Doctor;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class Doctor {

    private int id;
    private String nombre;
    private String dni;
    private String especialidad;
    private String telefono;
    private String correo; // NUEVO CAMPO REQ-D08

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    public Doctor() {
    }

    public Doctor(int id, String nombre, String dni, String especialidad, String telefono, String correo, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    // --- GETTERS Y SETTERS ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}