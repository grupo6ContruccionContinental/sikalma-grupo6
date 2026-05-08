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

    /**
     * REQ-C08: Verifica si existe alguna cita para el doctor indicado
     * en la misma fecha y hora, excluyendo la cita con el id dado
     * (útil al actualizar para no comparar la cita consigo misma).
     * Al registrar se pasa idExcluir = -1.
     */
    boolean existeCruceHorario(int doctorId, LocalDate fecha, LocalTime hora, int idExcluir);
}
