package com.example.demo.Cita;

import com.example.demo.Paciente.Paciente;
import com.example.demo.Doctor.Doctor;
import com.example.demo.Servicio.Servicio;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private static int contador = 1;

    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private Servicio servicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hora;

    private String estado;

    // Constructor vacío
    public Cita() {
        this.id = contador++;
    }

    // Constructor completo
    public Cita(Paciente paciente, Doctor doctor, Servicio servicio,
                LocalDate fecha, LocalTime hora, String estado) {
        this.id = contador++;
        this.paciente = paciente;
        this.doctor = doctor;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    // GETTERS
    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public Servicio getServicio() { return servicio; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getEstado() { return estado; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setEstado(String estado) { this.estado = estado; }
}