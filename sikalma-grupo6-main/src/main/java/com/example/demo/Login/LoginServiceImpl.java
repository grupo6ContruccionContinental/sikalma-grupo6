package com.example.demo.Login;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> autenticar(String correo, String contrasena) {
        if (correo == null || correo.isBlank() || contrasena == null || contrasena.isBlank()) {
            return Optional.empty();
        }
        return usuarioRepository.findByCorreoAndContrasena(correo.trim(), contrasena);
    }

    @Override
    public String registrar(Usuario usuario) {
        if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
            return "El correo es obligatorio";
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().length() < 6) {
            return "La contraseña debe tener al menos 6 caracteres";
        }
        if (!usuario.getCorreo().matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
            return "El formato del correo no es válido";
        }
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            return "Ya existe un usuario registrado con ese correo";
        }
        usuarioRepository.save(usuario);
        return null; // sin error
    }
}
