package com.example.demo.Paciente;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping("/gestion")
    public String gestionPaciente(Model model){

        List<Paciente> pacientes = pacienteService.listar();
        model.addAttribute("pacientes" , pacientes);
        model.addAttribute("paginaActiva", "paciente");

        return "Gestion-pacientes";
    }

    @GetMapping("/nuevo")
    public String nuevoPaciente(Model model){

        model.addAttribute("paginaActiva" , "paciente");

        return "Registrar-paciente";
    }

    @PostMapping("/registrar")
    public String registrarPaciente(@ModelAttribute Paciente p){

        pacienteService.agregar(p);

        return "redirect:/paciente/gestion";
    }

    @GetMapping("/editar")
    public String editarPaciente(@RequestParam int id , Model model){

        model.addAttribute("paciente" , pacienteService.buscarPorId(id));
        model.addAttribute("paginaActiva" , "paciente");

        return "Editar-paciente";

    }

    @PostMapping("/editar")
    public String cambiarPaciente(@ModelAttribute Paciente p){

        pacienteService.actualizar(p);

        return "redirect:/paciente/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model){

        model.addAttribute("paciente" , pacienteService.buscarPorId(id));

        return "Eliminar-paciente";
    }

    @GetMapping("/eliminar")
    public String eliminarPaciente(@RequestParam int id){

        pacienteService.eliminar(id);

        return "redirect:/paciente/gestion";
    }

    @GetMapping("/buscar")
    public String buscarPaciente(@RequestParam String dni,Model model){

        model.addAttribute("pacientes" , pacienteService.buscarPorDni(dni));
        model.addAttribute("paginaActiva" , "paciente");

        return "Gestion-pacientes";
    }


}
