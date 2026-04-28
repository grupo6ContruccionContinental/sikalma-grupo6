package com.example.demo.Doctor;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class Doctor {
    private int id;
    private String nombre;
    private String dni;
    private String especialidad;
    private String telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    // Constructor actualizado (sin id_usuario)
    public Doctor(int id, String nombre, String dni, String especialidad, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
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

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}