package com.example.demo.Login;

import java.util.Optional;

public interface LoginService {

    /**
     * Valida las credenciales. Retorna el Usuario si son correctas.
     */
    Optional<Usuario> autenticar(String correo, String contrasena);

    /**
     * Registra un nuevo usuario (útil si quieres crear doctores con acceso).
     * Retorna null si OK, o un mensaje de error si falla.
     */
    String registrar(Usuario usuario);
}
