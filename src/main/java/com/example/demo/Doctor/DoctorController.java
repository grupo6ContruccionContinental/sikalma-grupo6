package com.example.demo.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("doctores", doctorService.buscarPorDni(dni));
        return "Gestion-doctores";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("paginaActiva", "personal");
        return "Registrar-doctor";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Doctor doctor, Model model) {


        String error = doctorService.validarDatosRegistro(doctor);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("doctor", doctor); // Devuelve los datos para que no se borren
            model.addAttribute("paginaActiva", "personal");
            return "Registrar-doctor";
        }

        doctorService.agregar(doctor);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        model.addAttribute("paginaActiva", "personal");
        return "Editar-doctor";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Doctor doctor, Model model) {


        String error = doctorService.validarDatosEdicion(doctor);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("doctor", doctor); // Devuelve los datos
            model.addAttribute("paginaActiva", "personal");
            return "Editar-doctor";
        }

        doctorService.actualizar(doctor);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Eliminar-doctor";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id) {
        // El REQ-D09 se agregará aquí cuando haya un CitaService
        doctorService.eliminar(id);
        return "redirect:/doctor/gestion";
    }
}