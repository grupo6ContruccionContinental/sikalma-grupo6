package com.example.demo.Cita;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Paciente.Paciente;
import com.example.demo.Servicio.Servicio;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Cita {

    /**
     * AtomicInteger garantiza que la generación de IDs sea segura
     * en entornos con múltiples hilos concurrentes (thread-safe),
     * evitando IDs duplicados por condiciones de carrera.
     */
    private static final AtomicInteger contador = new AtomicInteger(1);

    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private Servicio servicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime hora;

    private String estado;

    // ── Constructores ───────────────────────────────────────────────────────

    /** Constructor vacío requerido por Spring MVC para el binding del formulario. */
    public Cita() {
        this.id = contador.getAndIncrement();
    }

    /** Constructor completo para creación programática. */
    public Cita(Paciente paciente, Doctor doctor, Servicio servicio,
                LocalDate fecha, LocalTime hora, String estado) {
        this.id = contador.getAndIncrement();
        this.paciente = paciente;
        this.doctor   = doctor;
        this.servicio = servicio;
        this.fecha    = fecha;
        this.hora     = hora;
        this.estado   = estado;
    }

    // ── Getters ─────────────────────────────────────────────────────────────

    public int       getId()       { return id; }
    public Paciente  getPaciente() { return paciente; }
    public Doctor    getDoctor()   { return doctor; }
    public Servicio  getServicio() { return servicio; }
    public LocalDate getFecha()    { return fecha; }
    public LocalTime getHora()     { return hora; }
    public String    getEstado()   { return estado; }

    // ── Setters ─────────────────────────────────────────────────────────────

    public void setId(int id)               { this.id = id; }
    public void setPaciente(Paciente p)     { this.paciente = p; }
    public void setDoctor(Doctor d)         { this.doctor = d; }
    public void setServicio(Servicio s)     { this.servicio = s; }
    public void setFecha(LocalDate fecha)   { this.fecha = fecha; }
    public void setHora(LocalTime hora)     { this.hora = hora; }
    public void setEstado(String estado)    { this.estado = estado; }

    // ── Utilidades ──────────────────────────────────────────────────────────

    /**
     * Permite al CitaRepository reajustar el contador al valor máximo
     * existente en la lista, útil si en el futuro se carga data inicial
     * (ej: desde un archivo o base de datos en memoria) para evitar
     * colisiones de IDs.
     */
    public static void ajustarContador(int valorMaximoExistente) {
        contador.set(valorMaximoExistente + 1);
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id="        + id +
                ", paciente=" + paciente +
                ", doctor="   + doctor +
                ", servicio=" + servicio +
                ", fecha="    + fecha +
                ", hora="     + hora +
                ", estado='"  + estado + '\'' +
                '}';
    }
}