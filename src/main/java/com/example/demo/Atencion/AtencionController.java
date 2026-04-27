package com.example.demo.Atencion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atencion")
public class AtencionController {

    @GetMapping("/g-atenciones")
    public String mostrarAtenciones(Model model){

        model.addAttribute("paginaActiva" , "atenciones");

        return "Gestion-atenciones";
    }
}
