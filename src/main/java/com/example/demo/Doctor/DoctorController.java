package com.example.demo.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService = new DoctorServiceImpl();

    @GetMapping("/gestion")
    public String listar(Model model) {
        model.addAttribute("paginaActiva", "personal");
        model.addAttribute("doctores", doctorService.obtenerTodos());
        return "Gestion-doctores";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("dni") String dni, Model model) {
        model.addAttribute("paginaActiva", "personal");
        List<Doctor> resultados = doctorService.buscarPorDni(dni);
        model.addAttribute("doctores", resultados);
        return "Gestion-doctores";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo() {
        return "Registrar-doctor";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Doctor doctor, RedirectAttributes redirectAttributes) {
        try {
            doctorService.agregar(doctor);
            return "redirect:/doctor/gestion";
        } catch (IllegalArgumentException e) {
            // Si hay error, lo atrapamos y mandamos el mensaje a la vista
            redirectAttributes.addFlashAttribute("errorValidacion", e.getMessage());
            return "redirect:/doctor/nuevo";
        }
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Editar-doctor";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Doctor doctor, RedirectAttributes redirectAttributes) {
        try {
            doctorService.actualizar(doctor);
            return "redirect:/doctor/gestion";
        } catch (IllegalArgumentException e) {
            // Si hay error al editar, mandamos el mensaje y volvemos al formulario
            redirectAttributes.addFlashAttribute("errorValidacion", e.getMessage());
            return "redirect:/doctor/editar?id=" + doctor.getId();
        }
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Eliminar-doctor";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id, RedirectAttributes redirectAttributes) {
        try {
            doctorService.eliminar(id);
            return "redirect:/doctor/gestion";
        } catch (IllegalArgumentException e) {
            // Para el REQ-D09 (cuando conectemos con citas)
            redirectAttributes.addFlashAttribute("errorEliminar", e.getMessage());
            return "redirect:/doctor/gestion";
        }
    }
}