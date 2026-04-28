package com.example.demo.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/gestion")
    public String gestionDoctor(Model model) {
        List<Doctor> doctores = doctorService.listar();
        model.addAttribute("doctores", doctores);
        model.addAttribute("paginaActiva", "doctor");
        return "Gestion-doctores";
    }

    @GetMapping("/nuevo")
    public String nuevoDoctor(Model model) {
        model.addAttribute("paginaActiva", "doctor");
        return "Registrar-doctor";
    }

    @PostMapping("/registrar")
    public String registrarDoctor(@ModelAttribute Doctor d) {
        doctorService.agregar(d);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/editar")
    public String editarDoctor(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        model.addAttribute("paginaActiva", "doctor");
        return "Editar-doctor";
    }

    @PostMapping("/editar")
    public String cambiarDoctor(@ModelAttribute Doctor d) {
        doctorService.actualizar(d);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Eliminar-doctor";
    }

    @GetMapping("/eliminar")
    public String eliminarDoctor(@RequestParam int id) {
        doctorService.eliminar(id);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/buscar")
    public String buscarDoctor(@RequestParam String dni, Model model) {
        model.addAttribute("doctores", doctorService.buscarPorDni(dni));
        model.addAttribute("paginaActiva", "doctor");
        return "Gestion-doctores";
    }
}