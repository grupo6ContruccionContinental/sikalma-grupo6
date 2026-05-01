package com.example.demo.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cita")
public class    CitaController {

    @Autowired
    private CitaService citaService;

    // 👉 GESTION (LISTAR)
    @GetMapping("/g-citas")
    public String mostrarCitas(Model model){
        model.addAttribute("paginaActiva", "citas");
        model.addAttribute("citas", citaService.listar()); // 🔥 IMPORTANTE
        return "Gestion-citas";
    }

    // 👉 IR A REGISTRAR
    @GetMapping("/r-citas")
    public String registrarCita(Model model){
        model.addAttribute("paginaActiva", "r-citas");
        return "Registrar-cita";
    }

    // 👉 GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita){
        citaService.guardar(cita);
        return "redirect:/cita/g-citas";
    }

    // 👉 EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "Editar-cita";
    }

    // 👉 ACTUALIZAR
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Cita cita){
        citaService.actualizar(cita);
        return "redirect:/cita/g-citas";
    }

    // 👉 CANCELAR (mostrar modal JSP)
    @GetMapping("/cancelar/{id}")
    public String cancelar(@PathVariable int id, Model model){
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "Cancelar-cita";
    }

    // 👉 ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        citaService.eliminar(id);
        return "redirect:/cita/g-citas";
    }
}