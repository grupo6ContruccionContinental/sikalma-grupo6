package com.example.demo.Cita;

import com.example.demo.Paciente.Paciente;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private static int contador = 1;

    private int id;
    private Paciente paciente;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hora;

    private String estado;

    // 🔥 CONSTRUCTOR VACÍO (IMPORTANTE PARA SPRING)
    public Cita() {
        this.id = contador++;
    }

    // Constructor con parámetros
    public Cita(Paciente paciente, LocalDate fecha, LocalTime hora, String estado){
        this.id = contador++;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    // 🔥 SETTER DE ID (IMPORTANTE PARA EDITAR)
    public void setId(int id) {
        this.id = id;
    }

    // SETTERS
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
