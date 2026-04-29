package com.example.demo.Servicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class Servicio {

    @GetMapping("/g-servicios")
    public String mostrarServicios(Model model){

        model.addAttribute("paginaActiva" , "servicios");

        return "Gestion-servicios";
    }

}
