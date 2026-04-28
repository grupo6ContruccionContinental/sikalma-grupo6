package com.example.demo.Cita;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cita")
public class CitaController {

    @GetMapping("/g-citas")
    public String mostrarCitas (Model model){
        model.addAttribute("paginaActiva", "citas");
        return "Gestion-citas";
    }

    @GetMapping("/r-citas")
    public String registrarCita (Model model){
        model.addAttribute("paginaActiva", "r-citas");
        return "Registrar-cita";
    }

}
