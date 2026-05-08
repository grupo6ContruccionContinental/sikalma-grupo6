package com.example.demo.Login;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // ─── Página de login ──────────────────────────────────────────────────────

    @GetMapping("/login")
    public String mostrarLogin(HttpSession session) {
        // Si ya hay sesión activa, redirigir según rol
        if (session.getAttribute("usuarioLogueado") != null) {
            return redirigirSegunRol((Usuario) session.getAttribute("usuarioLogueado"));
        }
        return "Login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                @RequestParam String contrasena,
                                HttpSession session,
                                Model model) {

        Optional<Usuario> resultado = loginService.autenticar(correo, contrasena);

        if (resultado.isEmpty()) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            model.addAttribute("correo", correo); // conserva el correo escrito
            return "Login";
        }

        Usuario usuario = resultado.get();
        session.setAttribute("usuarioLogueado", usuario);
        session.setAttribute("rolUsuario", usuario.getRol().name());
        session.setAttribute("nombreUsuario", usuario.getNombre());

        return redirigirSegunRol(usuario);
    }

    // ─── Cerrar sesión ────────────────────────────────────────────────────────

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // ─── Raíz del sitio → redirige al login ───────────────────────────────────

    @GetMapping("/")
    public String raiz(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") != null) {
            return redirigirSegunRol((Usuario) session.getAttribute("usuarioLogueado"));
        }
        return "redirect:/login";
    }

    // ─── Util ─────────────────────────────────────────────────────────────────

    private String redirigirSegunRol(Usuario usuario) {
        if (usuario.getRol() == Usuario.Rol.ADMIN) {
            return "redirect:/metricas/g-metricas";
        } else {
            // DOCTOR va a la gestión de citas
            return "redirect:/cita/g-citas";
        }
    }
}
