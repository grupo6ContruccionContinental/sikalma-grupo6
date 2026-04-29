package com.example.demo.cita;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService){
        this.citaService = citaService;
    }

    @GetMapping("/gestion")
    public String gestion(Model model){
        model.addAttribute("citas", citaService.listar());
        return "Gestion-citas";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "FUNCIONA";
    }

    @GetMapping("/nuevo")
    public String nuevo(){
        return "Registrar-cita";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Cita c){
        citaService.agregar(c);
        return "redirect:/cita/gestion";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model){
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "Editar-cita";
    }

    @PostMapping("/editar")
    public String actualizar(@ModelAttribute Cita c){
        citaService.actualizar(c);
        return "redirect:/cita/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model){
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "Eliminar-cita";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id){
        citaService.eliminar(id);
        return "redirect:/cita/gestion";
    }
}
