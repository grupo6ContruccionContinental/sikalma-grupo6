package com.example.demo.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/g-citas")
    public String mostrarCitas() {
        return "Gestion-citas";
    }

    @GetMapping("/r-citas")
    public String registrarCita() {
        return "Registrar-cita";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita) {
        citaService.guardar(cita);
        return "redirect:/cita/g-citas";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Cita cita) {
        citaService.actualizar(cita);
        return "redirect:/cita/g-citas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        citaService.eliminar(id);
        return "redirect:/cita/g-citas";
    }
}