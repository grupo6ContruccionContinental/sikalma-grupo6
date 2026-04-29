package com.example.demo.cita;

public class Cita {

    private int id;
    private int id_paciente;
    private int id_doctor;
    private int id_servicio;
    private String fecha;
    private String hora;
    private String estado;

    private String nombrePaciente;
    private String nombreDoctor;
    private String nombreServicio;

    public Cita(){}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_paciente() { return id_paciente; }
    public void setId_paciente(int id_paciente) { this.id_paciente = id_paciente; }

    public int getId_doctor() { return id_doctor; }
    public void setId_doctor(int id_doctor) { this.id_doctor = id_doctor; }

    public int getId_servicio() { return id_servicio; }
    public void setId_servicio(int id_servicio) { this.id_servicio = id_servicio; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }

    public String getNombreDoctor() { return nombreDoctor; }
    public void setNombreDoctor(String nombreDoctor) { this.nombreDoctor = nombreDoctor; }

    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }
}