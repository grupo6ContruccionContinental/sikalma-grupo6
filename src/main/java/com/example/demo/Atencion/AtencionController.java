package com.example.demo.Atencion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/atencion")
public class AtencionController {

    private final AtencionService atencionService;

    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    // ── GET /atencion/gestion ─────────────────────────────────────────────────
    @GetMapping("/gestion")
    public String listar(Model model) {
        List<Atencion> atenciones = atencionService.obtenerTodos();
        model.addAttribute("atenciones", atenciones);
        model.addAttribute("paginaActiva", "atencion");
        return "Gestion-atenciones";
    }

    // ── GET /atencion/ver?id=X ────────────────────────────────────────────────
    @GetMapping("/ver")
    public String ver(@RequestParam int id, Model model) {
        model.addAttribute("atencion", atencionService.buscarPorId(id));
        model.addAttribute("paginaActiva", "atencion");
        return "Ver-atencion";
    }

    // ── GET /atencion/editar?id=X ─────────────────────────────────────────────
    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("atencion", atencionService.buscarPorId(id));
        model.addAttribute("paginaActiva", "atencion");
        return "Editar-atencion";
    }

    // ── POST /atencion/actualizar ─────────────────────────────────────────────
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Atencion atencion) {
        atencionService.actualizar(atencion);
        return "redirect:/atencion/gestion";
    }

    // ── GET /atencion/eliminar?id=X ───────────────────────────────────────────
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id) {
        atencionService.eliminar(id);
        return "redirect:/atencion/gestion";
    }
}
