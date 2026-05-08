package com.example.demo.Atencion;

import java.time.LocalTime;
import java.util.List;

public interface AtencionService {

    List<Atencion> obtenerTodos();

    void agregar(int citaId, LocalTime horaInicio, LocalTime horaFin,
                 String diagnostico, String tratamiento, String estado);

    Atencion buscarPorId(int id);

    void actualizar(int id, int citaId, LocalTime horaInicio, LocalTime horaFin,
                    String diagnostico, String tratamiento, String estado);

    void eliminar(int id);

    // Validaciones (REQ-A01..A03)
    String validarDatosRegistro(LocalTime horaInicio, LocalTime horaFin,
                                String diagnostico, String tratamiento);

    String validarDatosEdicion(LocalTime horaInicio, LocalTime horaFin,
                               String diagnostico, String tratamiento);
}
