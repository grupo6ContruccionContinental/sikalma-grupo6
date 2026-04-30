package com.example.demo.Cita;

import java.util.List;

public interface CitaService {

    List<Cita> listar();

    void guardar(Cita cita);

    Cita buscarPorId(int id);

    void eliminar(int id);

    void actualizar(Cita cita);
}