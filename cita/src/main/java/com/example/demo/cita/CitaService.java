package com.example.demo.cita;

import java.util.List;

public interface CitaService {

    List<Cita> listar();
    void agregar(Cita c);
    Cita buscarPorId(int id);
    void actualizar(Cita c);
    void eliminar(int id);
}