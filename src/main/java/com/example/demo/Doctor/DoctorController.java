package com.example.demo.Doctor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @GetMapping("/g-doctores")
    public String mostrarDoctores(Model model){

        model.addAttribute("paginaActiva" , "personal");

        return "Gestion-personal";
    }
}
