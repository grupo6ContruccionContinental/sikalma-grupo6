package com.example.demo.Atencion;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Cita.Cita;


import java.time.LocalTime;

public class Atencion {

    private int id;
    private Cita cita;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInicio;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFin;
    private String diagnostico;
    private String tratamiento;
    private String estado;       

    public Atencion() {}

    // Constructor completo (útil al crear desde una Cita)
    public Atencion(Cita cita, LocalTime horaInicio, LocalTime horaFin , String diagnostico, String tratamiento , String estado) {
        this.cita         = cita;
        this.horaInicio     = horaInicio;
        this.horaFin        = horaFin;
        this.diagnostico    = diagnostico;
        this.tratamiento    = tratamiento;
        this.estado         = estado;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public int getId()                  { return id; }
    public Cita getCita ()               { return cita;}
    public LocalTime getHoraInicio()    { return horaInicio;}
    public LocalTime getHoraFin()       { return horaFin;}
    public String getDiagnostico()      { return diagnostico;}
    public String getTratamiento()      { return tratamiento;}
    public String getEstado()           { return estado;}

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setId(int id)                          { this.id = id;}
    public void setCita(Cita cita)                     {this.cita = cita;}
    public void setHoraInicio(LocalTime horaInicio)    { this.horaInicio = horaInicio; }
    public void setHoraFin(LocalTime horaFin)          { this.horaFin = horaFin; }
    public void setDiagnostico(String diagnostico)     { this.diagnostico = diagnostico; }
    public void setTratamiento(String tratamiento)     { this.tratamiento = tratamiento; }
    public void setEstado(String estado)               { this.estado = estado; }
}
