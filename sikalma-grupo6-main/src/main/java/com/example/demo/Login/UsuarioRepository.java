package com.example.demo.Login;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private final List<Usuario> lista = new ArrayList<>();
    private int contador = 1;

    // ─── Usuarios precargados ─────────────────────────────────────────────────
    // Admin predeterminado: admin@sikalma.com / admin123
    // Los doctores se registran desde la pantalla de gestión con su correo.
    // Puedes agregar más aquí o crear un endpoint de registro de admin.
    public UsuarioRepository() {
        lista.add(new Usuario(contador++, "admin@sikalma.com",  "admin123",  Usuario.Rol.ADMIN,  "Administrador"));
        lista.add(new Usuario(contador++, "doctor@sikalma.com", "doctor123", Usuario.Rol.DOCTOR, "Doctor Demo"));
    }

    // ─── CRUD básico ─────────────────────────────────────────────────────────

    public void save(Usuario u) {
        u.setId(contador++);
        lista.add(u);
    }

    public List<Usuario> findAll() {
        return lista;
    }

    public Optional<Usuario> findByCorreo(String correo) {
        return lista.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .findFirst();
    }

    /**
     * Busca un usuario por correo Y contraseña.
     * Retorna el usuario si las credenciales son válidas, o empty si no.
     */
    public Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena) {
        return lista.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo)
                          && u.getContrasena().equals(contrasena))
                .findFirst();
    }

    public boolean existsByCorreo(String correo) {
        return lista.stream().anyMatch(u -> u.getCorreo().equalsIgnoreCase(correo));
    }
}
