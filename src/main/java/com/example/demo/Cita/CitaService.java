package com.example.demo.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaService {

    List<Cita> listar();

    void guardar(int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora, String estado);

    Cita buscarPorId(int id);

    void eliminar(int id);

    void actualizar(int id ,int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora, String estado);

    List<Cita> buscarCitaPorPaciente( int idPaciente);


    // validaciones 
    String validarCitasExistentes(int idPaciente);
}