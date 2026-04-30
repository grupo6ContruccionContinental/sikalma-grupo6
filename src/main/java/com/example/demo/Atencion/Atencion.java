package com.example.demo.Atencion;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Atencion {

    private int id;
    private int idCita;
    private int idPaciente;
    private int idDoctor;
    private int idServicio;

    // Nombres para mostrar en vistas (se copian desde la Cita de origen)
    private String nombrePaciente;
    private String nombreDoctor;
    private String nombreServicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAtencion;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFin;

    private String diagnostico;
    private String tratamiento;
    private double costo;
    private String estado;        // Pendiente | En curso | Completada
    private String observaciones;

    // Constructor vacío requerido por @ModelAttribute de Spring
    public Atencion() {}

    // Constructor completo (útil al crear desde una Cita)
    public Atencion(int idCita, int idPaciente, int idDoctor, int idServicio,
                    String nombrePaciente, String nombreDoctor, String nombreServicio,
                    LocalDate fechaAtencion, LocalTime horaInicio, LocalTime horaFin,
                    String diagnostico, String tratamiento, double costo,
                    String estado, String observaciones) {
        this.idCita         = idCita;
        this.idPaciente     = idPaciente;
        this.idDoctor       = idDoctor;
        this.idServicio     = idServicio;
        this.nombrePaciente = nombrePaciente;
        this.nombreDoctor   = nombreDoctor;
        this.nombreServicio = nombreServicio;
        this.fechaAtencion  = fechaAtencion;
        this.horaInicio     = horaInicio;
        this.horaFin        = horaFin;
        this.diagnostico    = diagnostico;
        this.tratamiento    = tratamiento;
        this.costo          = costo;
        this.estado         = estado;
        this.observaciones  = observaciones;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public int getId()                  { return id; }
    public int getIdCita()              { return idCita; }
    public int getIdPaciente()          { return idPaciente; }
    public int getIdDoctor()            { return idDoctor; }
    public int getIdServicio()          { return idServicio; }
    public String getNombrePaciente()   { return nombrePaciente; }
    public String getNombreDoctor()     { return nombreDoctor; }
    public String getNombreServicio()   { return nombreServicio; }
    public LocalDate getFechaAtencion() { return fechaAtencion; }
    public LocalTime getHoraInicio()    { return horaInicio; }
    public LocalTime getHoraFin()       { return horaFin; }
    public String getDiagnostico()      { return diagnostico; }
    public String getTratamiento()      { return tratamiento; }
    public double getCosto()            { return costo; }
    public String getEstado()           { return estado; }
    public String getObservaciones()    { return observaciones; }

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setId(int id)                           { this.id = id; }
    public void setIdCita(int idCita)                   { this.idCita = idCita; }
    public void setIdPaciente(int idPaciente)           { this.idPaciente = idPaciente; }
    public void setIdDoctor(int idDoctor)               { this.idDoctor = idDoctor; }
    public void setIdServicio(int idServicio)           { this.idServicio = idServicio; }
    public void setNombrePaciente(String nombrePaciente){ this.nombrePaciente = nombrePaciente; }
    public void setNombreDoctor(String nombreDoctor)    { this.nombreDoctor = nombreDoctor; }
    public void setNombreServicio(String nombreServicio){ this.nombreServicio = nombreServicio; }
    public void setFechaAtencion(LocalDate fechaAtencion){ this.fechaAtencion = fechaAtencion; }
    public void setHoraInicio(LocalTime horaInicio)    { this.horaInicio = horaInicio; }
    public void setHoraFin(LocalTime horaFin)          { this.horaFin = horaFin; }
    public void setDiagnostico(String diagnostico)     { this.diagnostico = diagnostico; }
    public void setTratamiento(String tratamiento)     { this.tratamiento = tratamiento; }
    public void setCosto(double costo)                 { this.costo = costo; }
    public void setEstado(String estado)               { this.estado = estado; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
