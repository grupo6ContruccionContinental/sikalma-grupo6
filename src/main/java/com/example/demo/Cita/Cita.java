package com.example.demo.Cita;

import com.example.demo.Paciente.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private static int contador = 1;

    private int id;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    public Cita (Paciente paciente, LocalDate fecha, LocalTime hora, String estado){
        this.id = contador ++;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId () {
        return this.id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFecha (){
        return this.fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

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
