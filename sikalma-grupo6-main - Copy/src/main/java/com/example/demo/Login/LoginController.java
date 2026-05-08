package com.example.demo.Login;

import com.example.demo.Doctor.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final DoctorService doctorService;

    public LoginController(LoginService loginService, DoctorService doctorService) {
        this.loginService = loginService;
        this.doctorService = doctorService;
    }

    // ─── Raíz ────────────────────────────────────────────────────────────────
    @GetMapping("/")
    public String raiz(HttpSession session) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
        if (u != null) return redirigirSegunRol(u);
        return "redirect:/login";
    }

    // ─── GET /login ───────────────────────────────────────────────────────────
    @GetMapping("/login")
    public String mostrarLogin(HttpSession session) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
        if (u != null) return redirigirSegunRol(u);
        return "Login";
    }

    // ─── POST /login ──────────────────────────────────────────────────────────
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                @RequestParam String contrasena,
                                HttpServletRequest request,
                                Model model) {

        Optional<Usuario> resultado = loginService.autenticar(correo, contrasena);

        if (resultado.isEmpty()) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            model.addAttribute("correo", correo);
            return "Login";
        }

        Usuario usuario = resultado.get();

        HttpSession vieja = request.getSession(false);
        if (vieja != null) vieja.invalidate();

        HttpSession nueva = request.getSession(true);
        nueva.setAttribute("usuarioLogueado", usuario);
        nueva.setAttribute("rolUsuario",      usuario.getRol().name());
        nueva.setAttribute("nombreUsuario",   usuario.getNombre());
        nueva.setAttribute("doctorIdSesion",  usuario.getDoctorId());

        return redirigirSegunRol(usuario);
    }

    // ─── GET /logout ──────────────────────────────────────────────────────────
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // ─── GET /acceso-denegado ─────────────────────────────────────────────────
    @GetMapping("/acceso-denegado")
    public String accesoDenegado(HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
        if (u != null) {
            model.addAttribute("urlRetorno", u.getRol() == Usuario.Rol.ADMIN
                    ? "/metricas/g-metricas" : "/cita/g-citas");
        }
        return "Acceso-denegado";
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  GESTIÓN DE CREDENCIALES (solo ADMIN — protegido por SessionInterceptor)
    // ═══════════════════════════════════════════════════════════════════════════

    @GetMapping("/credenciales/gestion")
    public String gestionCredenciales(Model model) {
        model.addAttribute("credenciales", loginService.listarDoctores());
        model.addAttribute("doctores",     doctorService.obtenerTodos());
        model.addAttribute("paginaActiva", "credenciales");
        return "Gestion-credenciales";
    }

    @GetMapping("/credenciales/nueva")
    public String nuevaCredencial(Model model) {
        model.addAttribute("doctores",     doctorService.obtenerTodos());
        model.addAttribute("paginaActiva", "credenciales");
        return "Registrar-credencial";
    }

    @PostMapping("/credenciales/guardar")
    public String guardarCredencial(@RequestParam String correo,
                                    @RequestParam String contrasena,
                                    @RequestParam String nombre,
                                    @RequestParam int doctorId,
                                    Model model) {

        Usuario u = new Usuario();
        u.setCorreo(correo.trim());
        u.setContrasena(contrasena);
        u.setNombre(nombre.trim());
        u.setDoctorId(doctorId);
        u.setRol(Usuario.Rol.DOCTOR);

        String error = loginService.registrar(u);
        if (error != null) {
            model.addAttribute("error",    error);
            model.addAttribute("doctores", doctorService.obtenerTodos());
            model.addAttribute("correo",   correo);
            model.addAttribute("nombre",   nombre);
            model.addAttribute("doctorId", doctorId);
            model.addAttribute("paginaActiva", "credenciales");
            return "Registrar-credencial";
        }

        // Redirige con ?ok=1 para mostrar mensaje de éxito en la lista
        return "redirect:/credenciales/gestion?ok=1";
    }

    @GetMapping("/credenciales/eliminar")
    public String eliminarCredencial(@RequestParam int id) {
        loginService.eliminar(id);
        return "redirect:/credenciales/gestion";
    }

    // ─── Util ─────────────────────────────────────────────────────────────────
    private String redirigirSegunRol(Usuario usuario) {
        return usuario.getRol() == Usuario.Rol.ADMIN
                ? "redirect:/metricas/g-metricas"
                : "redirect:/cita/g-citas";
    }
}
