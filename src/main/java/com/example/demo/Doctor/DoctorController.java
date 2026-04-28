package com.example.demo.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

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

    @GetMapping("/nuevo")
    public String formularioNuevo() {
        return "Registrar-doctor";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam String nombre,
                          @RequestParam String dni,
                          @RequestParam String especialidad,
                          @RequestParam String telefono,
                          @RequestParam String fechaNacimiento) {
        // Se crea el objeto sin id_usuario
        Doctor nuevo = new Doctor(0, nombre, dni, especialidad, telefono, LocalDate.parse(fechaNacimiento));
        doctorService.agregar(nuevo);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Editar-doctor";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id,
                             @RequestParam String nombre,
                             @RequestParam String dni,
                             @RequestParam String especialidad,
                             @RequestParam String telefono,
                             @RequestParam String fechaNacimiento) {
        Doctor editado = new Doctor(id, nombre, dni, especialidad, telefono, LocalDate.parse(fechaNacimiento));
        doctorService.actualizar(editado);
        return "redirect:/doctor/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("doctor", doctorService.buscarPorId(id));
        return "Eliminar-doctor";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id) {
        doctorService.eliminar(id);
        return "redirect:/doctor/gestion";
    }
}