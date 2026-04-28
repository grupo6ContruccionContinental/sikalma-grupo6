package com.example.demo.Servicio;

import java.util.List;

public interface ServicioDAO {

    List<Servicio> listar();
    void guardar(Servicio servicio);
    Servicio buscarPorId(int id);
    void actualizar(Servicio servicio);
    void eliminar(int id);
}