package com.example.demo.Servicio;

import java.util.List;

public interface ServicioDAO {

    void save(Servicio s);

    List<Servicio> findAll();

    Servicio findById(int id);

    void update(Servicio s);

    void delete(int id);

    List<Servicio> findByNombre(String nombre);

}
