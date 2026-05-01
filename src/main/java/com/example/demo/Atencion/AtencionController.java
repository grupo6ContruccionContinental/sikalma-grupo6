package com.example.demo.Atencion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/atencion")
public class AtencionController {

    private final AtencionService atencionService;

    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    
    @GetMapping("/gestion")
    public String listar(Model model) {
        List<Atencion> atenciones = atencionService.obtenerTodos();
        model.addAttribute("atenciones", atenciones);
        model.addAttribute("paginaActiva", "atencion");
        return "Gestion-atenciones";
    }

    @PostMapping("/nuevo")
    public String registrarAtencion(@RequestParam int citaId , @RequestParam LocalTime horaInicio, @RequestParam LocalTime horaFin, @RequestParam String diagnostico, @RequestParam String tratamiento, @RequestParam String estado) {

        atencionService.agregar(citaId,horaInicio,horaFin,diagnostico,tratamiento,estado);

        return "redirect:/atencion/gestion";
    }


    @GetMapping("/ver")
    public String ver(@RequestParam int id, Model model) {
        model.addAttribute("atencion", atencionService.buscarPorId(id));
        model.addAttribute("paginaActiva", "atencion");
        return "Ver-atencion";
    }

    
    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("atencion", atencionService.buscarPorId(id));
        model.addAttribute("paginaActiva", "atencion");
        return "Editar-atencion";
    }

    
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id, @RequestParam int citaId , @RequestParam LocalTime horaInicio, @RequestParam LocalTime horaFin, @RequestParam String diagnostico, @RequestParam String tratamiento, @RequestParam String estado) {
        atencionService.actualizar(id, citaId, horaInicio,horaFin,diagnostico,tratamiento,estado);
        return "redirect:/atencion/gestion";
    }

    
}
