package com.example.demo.Atencion;

import com.example.demo.Cita.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/atencion")
public class AtencionController {

    private final AtencionService atencionService;
    private final CitaService citaService;

    public AtencionController(AtencionService atencionService, CitaService citaService) {
        this.atencionService = atencionService;
        this.citaService = citaService;
    }

    @GetMapping("/gestion")
    public String listar(Model model) {
        List<Atencion> atenciones = atencionService.obtenerTodos();
        model.addAttribute("atenciones", atenciones);
        model.addAttribute("paginaActiva", "atencion");
        return "Gestion-atenciones";
    }

    @PostMapping("/nuevo")
    public String registrarAtencion(
            @RequestParam int citaId,
            @RequestParam LocalTime horaInicio,
            @RequestParam LocalTime horaFin,
            @RequestParam String diagnostico,
            @RequestParam String tratamiento,
            @RequestParam String estado,
            Model model) {

        try {
            atencionService.agregar(citaId, horaInicio, horaFin, diagnostico, tratamiento, estado);
            return "redirect:/atencion/gestion";
        } catch (AtencionException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("cita", citaService.buscarPorId(citaId));
            model.addAttribute("paginaActiva", "atencion");
            return "Registrar-atencion";
        }
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
    public String actualizar(
            @RequestParam int id,
            @RequestParam int citaId,
            @RequestParam LocalTime horaInicio,
            @RequestParam LocalTime horaFin,
            @RequestParam String diagnostico,
            @RequestParam String tratamiento,
            @RequestParam String estado,
            Model model) {

        try {
            atencionService.actualizar(id, citaId, horaInicio, horaFin, diagnostico, tratamiento, estado);
            return "redirect:/atencion/gestion";
        } catch (AtencionException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("atencion", atencionService.buscarPorId(id));
            model.addAttribute("paginaActiva", "atencion");
            return "Editar-atencion";
        }
    }
}
