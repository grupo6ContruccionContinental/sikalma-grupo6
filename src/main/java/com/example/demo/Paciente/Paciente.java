package com.example.demo.Paciente;

import com.example.demo.Cita.Cita;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private int id;
    private String nombres;
    private String dni;
    private String telefono;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private List<Cita> citas = new ArrayList<>();

    public Paciente () {}

    public Paciente (String nombres, String dni, String telefono, LocalDate fechaNacimiento){

        this.nombres = nombres;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;

    }

    public int getId () {
        return this.id;
    }

    public String getNombres(){
        return this.nombres;
    }

    public String getDni(){
        return this.dni;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public int getEdad(){

        return Period.between(this.fechaNacimiento , LocalDate.now()).getYears() ;

    }

    public LocalDate getFechaNacimiento () {
        return  this.fechaNacimiento;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
