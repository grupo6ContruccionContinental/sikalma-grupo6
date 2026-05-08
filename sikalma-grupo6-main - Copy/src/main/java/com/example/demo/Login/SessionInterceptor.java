package com.example.demo.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        // 1. Sin sesión → login
        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        String uri = request.getRequestURI();
        String ctx = request.getContextPath();

        // Rutas exclusivas de ADMIN (no accesibles por DOCTOR)
        boolean esRutaAdmin = uri.startsWith(ctx + "/doctor")
                || uri.startsWith(ctx + "/paciente")
                || uri.startsWith(ctx + "/servicio")
                || uri.startsWith(ctx + "/credenciales")
                || uri.startsWith(ctx + "/cita/r-citas")
                || uri.startsWith(ctx + "/cita/guardar")
                || uri.startsWith(ctx + "/cita/editar")
                || uri.startsWith(ctx + "/cita/actualizar")
                || uri.startsWith(ctx + "/cita/cancelar")
                || uri.startsWith(ctx + "/cita/eliminar");

        // Rutas exclusivas de DOCTOR (no accesibles por ADMIN)
        boolean esRutaDoctor = uri.startsWith(ctx + "/atencion")
                || uri.startsWith(ctx + "/cita/atender");

        if (usuario.getRol() == Usuario.Rol.DOCTOR && esRutaAdmin) {
            response.sendRedirect(ctx + "/acceso-denegado");
            return false;
        }

        if (usuario.getRol() == Usuario.Rol.ADMIN && esRutaDoctor) {
            response.sendRedirect(ctx + "/acceso-denegado");
            return false;
        }

        return true;
    }
}
