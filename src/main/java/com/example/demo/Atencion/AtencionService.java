package com.example.demo.Atencion;

import java.util.List;

public interface AtencionService {
    List<Atencion> obtenerTodos();
    void agregar(Atencion atencion);
    Atencion buscarPorId(int id);
    void actualizar(Atencion atencion);
    void eliminar(int id);
}
