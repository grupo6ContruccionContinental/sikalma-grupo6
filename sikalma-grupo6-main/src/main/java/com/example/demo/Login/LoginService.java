package com.example.demo.Login;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    Optional<Usuario> autenticar(String correo, String contrasena);

    /** Registra un nuevo usuario doctor. Retorna null si OK, mensaje de error si falla. */
    String registrar(Usuario usuario);

    List<Usuario> listarDoctores();

    void eliminar(int id);

    boolean doctorYaTieneCredencial(int doctorId);
}
