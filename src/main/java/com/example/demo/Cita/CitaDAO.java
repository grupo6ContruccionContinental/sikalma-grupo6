package com.example.demo.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaDAO {

    List<Cita> listar();

    void guardar(Cita cita);

    Cita buscarPorId(int id);

    void eliminar(int id);

    void actualizar(Cita cita);

    List<Cita> buscarPorPaciente(int idPaciente);

    List<Cita> buscarPorDoctor(int idDoctor);

    void cambiarEstado(int id, String estado);

    boolean existeCitaDoctor(int doctorId, LocalDate fecha, LocalTime hora);

    boolean existeCitaDoctorExcluyendo(int doctorId, LocalDate fecha, LocalTime hora, int citaId);

}