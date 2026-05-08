package com.example.demo.Cita;

import com.example.demo.Doctor.DoctorService;
import com.example.demo.Paciente.PacienteService;
import com.example.demo.Servicio.ServicioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;
    private final ServicioService servicioService;

    public CitaController(CitaService citaService, PacienteService pacienteService,
                          DoctorService doctorService, ServicioService servicioService) {
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
        this.servicioService = servicioService;
    }

    // ─── Listar citas (filtradas por doctor si el rol es DOCTOR) ──────────────
    @GetMapping("/g-citas")
    public String mostrarCitas(HttpSession session, Model model) {
        model.addAttribute("paginaActiva", "citas");

        String rol = (String) session.getAttribute("rolUsuario");
        Object doctorIdObj = session.getAttribute("doctorIdSesion");

        if ("DOCTOR".equals(rol) && doctorIdObj instanceof Integer) {
            int doctorId = (Integer) doctorIdObj;
            if (doctorId > 0) {
                model.addAttribute("citas", citaService.buscarCitaPorDoctor(doctorId));
                return "Gestion-citas";
            }
        }

        model.addAttribute("citas", citaService.listar());
        return "Gestion-citas";
    }

    // ─── Formulario nueva cita (solo ADMIN llega aquí, interceptor lo protege) ─
    @GetMapping("/r-citas")
    public String registrarCita(Model model) {
        model.addAttribute("paginaActiva", "r-citas");
        model.addAttribute("pacientes", pacienteService.listar());
        model.addAttribute("doctores", doctorService.obtenerTodos());
        model.addAttribute("servicios", servicioService.listar());
        return "Registrar-cita";
    }

    // ─── Guardar nueva cita ───────────────────────────────────────────────────
    @PostMapping("/guardar")
    public String guardar(@RequestParam(defaultValue = "0") int paciente,
                          @RequestParam(defaultValue = "0") int doctor,
                          @RequestParam(defaultValue = "0") int servicio,
                          @RequestParam(required = false) LocalDate fecha,
                          @RequestParam(required = false) LocalTime hora,
                          @RequestParam String estado,
                          Model model) {

        String error = citaService.validarDatosRegistro(paciente, doctor, servicio, fecha, hora);

        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("paginaActiva", "r-citas");
            model.addAttribute("pacientes", pacienteService.listar());
            model.addAttribute("doctores", doctorService.obtenerTodos());
            model.addAttribute("servicios", servicioService.listar());
            return "Registrar-cita";
        }

        citaService.guardar(paciente, doctor, servicio, fecha, hora, estado);
        return "redirect:/cita/g-citas";
    }

    // ─── Editar cita ─────────────────────────────────────────────────────────
    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("cita", citaService.buscarPorId(id));
        model.addAttribute("servicios", servicioService.listar());
        model.addAttribute("doctores", doctorService.obtenerTodos());
        model.addAttribute("paginaActiva", "r-citas");
        return "Editar-cita";
    }

    // ─── Actualizar cita ──────────────────────────────────────────────────────
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id,
                             @RequestParam(defaultValue = "0") int paciente,
                             @RequestParam(defaultValue = "0") int doctor,
                             @RequestParam(defaultValue = "0") int servicio,
                             @RequestParam(required = false) LocalDate fecha,
                             @RequestParam(required = false) LocalTime hora,
                             @RequestParam String estado,
                             Model model) {

        String error = citaService.validarDatosEdicion(id, paciente, doctor, servicio, fecha, hora);

        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("cita", citaService.buscarPorId(id));
            model.addAttribute("servicios", servicioService.listar());
            model.addAttribute("doctores", doctorService.obtenerTodos());
            model.addAttribute("paginaActiva", "r-citas");
            return "Editar-cita";
        }

        citaService.actualizar(id, paciente, doctor, servicio, fecha, hora, estado);
        return "redirect:/cita/g-citas";
    }

    // ─── Atender cita (solo DOCTOR): valida estado y devuelve con citas del doctor ─
    @GetMapping("/atender")
    public String atenderCita(@RequestParam int id, HttpSession session, Model model) {

        Cita cita = citaService.buscarPorId(id);

        if (!cita.getEstado().equals("Confirmada")) {
            // Recargar lista filtrada para el doctor
            Object doctorIdObj = session.getAttribute("doctorIdSesion");
            List<Cita> citasDoctor = (doctorIdObj instanceof Integer && (Integer) doctorIdObj > 0)
                    ? citaService.buscarCitaPorDoctor((Integer) doctorIdObj)
                    : citaService.listar();

            model.addAttribute("errorAtender", "Solo se puede atender una cita en estado Confirmada");
            model.addAttribute("paginaActiva", "citas");
            model.addAttribute("citas", citasDoctor);
            return "Gestion-citas";
        }

        model.addAttribute("cita", cita);
        model.addAttribute("paginaActiva", "citas");
        return "Registrar-atencion";
    }

    // ─── Cancelar cita ────────────────────────────────────────────────────────
    @GetMapping("/cancelar")
    public String cancelar(@RequestParam int id, Model model) {
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "Cancelar-cita";
    }

    // ─── Eliminar cita ────────────────────────────────────────────────────────
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id) {
        citaService.eliminar(id);
        return "redirect:/cita/g-citas";
    }
}
