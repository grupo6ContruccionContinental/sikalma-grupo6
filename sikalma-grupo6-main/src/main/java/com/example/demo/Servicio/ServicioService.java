package com.example.demo.Servicio;

import java.util.List;

public interface ServicioService {

    void agregar(Servicio servicio);

    List<Servicio> listar();

    Servicio buscarPorId(int id);

    void actualizar(Servicio servicio);

    void eliminar(int id);

    List<Servicio> buscarPorNombre(String nombre);

    //validaciones

    String validarDatosRegistro(Servicio servicio);

    String validarDatosEdicion(Servicio servicio);

}
