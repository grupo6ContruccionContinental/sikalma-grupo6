package com.example.demo.Cita;

import java.util.List;

public interface CitaDAO {

    List<Cita> listar();

    void guardar(Cita cita);

    Cita buscarPorId(int id);

    void eliminar(int id);

    void actualizar(Cita cita);

    List<Cita> buscarPorPaciente(int idPaciente);

}