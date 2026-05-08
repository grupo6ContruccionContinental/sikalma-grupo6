package com.example.demo.Cita;

import java.util.List;

public interface CitaService {

    List<Cita> listar();

    /** Retorna null si no hay error, o el mensaje de error si falla alguna validación. */
    String guardar(Cita cita);

    Cita buscarPorId(int id);

    void eliminar(int id);

    /** Retorna null si no hay error, o el mensaje de error si falla alguna validación. */
    String actualizar(Cita cita);

    /** REQ-C07: Marca la cita como "No asistió" si su estado es "Confirmada". */
    String marcarNoAsistio(int id);
}
