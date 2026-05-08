package com.example.demo.Login;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepository {

    private final List<Usuario> lista = new ArrayList<>();
    private int contador = 1;

    public UsuarioRepository() {
        // Admin predeterminado — doctorId = 0 (sin doctor asociado)
        lista.add(new Usuario(contador++, "admin@sikalma.com", "admin123", Usuario.Rol.ADMIN, "Administrador", 0));
    }

    public void save(Usuario u) {
        u.setId(contador++);
        lista.add(u);
    }

    public List<Usuario> findAll() {
        return lista;
    }

    public List<Usuario> findByRol(Usuario.Rol rol) {
        return lista.stream()
                .filter(u -> u.getRol() == rol)
                .collect(Collectors.toList());
    }

    public Optional<Usuario> findById(int id) {
        return lista.stream().filter(u -> u.getId() == id).findFirst();
    }

    public Optional<Usuario> findByCorreo(String correo) {
        return lista.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .findFirst();
    }

    public Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena) {
        return lista.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo)
                          && u.getContrasena().equals(contrasena))
                .findFirst();
    }

    public boolean existsByCorreo(String correo) {
        return lista.stream().anyMatch(u -> u.getCorreo().equalsIgnoreCase(correo));
    }

    public boolean existsByDoctorId(int doctorId) {
        if (doctorId == 0) return false;
        return lista.stream().anyMatch(u -> u.getDoctorId() == doctorId);
    }

    public void delete(int id) {
        lista.removeIf(u -> u.getId() == id);
    }
}
