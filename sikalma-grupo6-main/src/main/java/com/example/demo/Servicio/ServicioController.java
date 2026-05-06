package com.example.demo.Servicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/gestion")
    public String gestionServicio(Model model) {
        model.addAttribute("servicios", servicioService.listar());
        model.addAttribute("paginaActiva", "servicios");
        return "Gestion-servicios";
    }

    @GetMapping("/nuevo")
    public String nuevoServicio(Model model) {
        model.addAttribute("paginaActiva", "servicios");
        return "Registrar-servicio";
    }

    // REQ-S01, REQ-S02, REQ-S03: el ServiceImpl valida y lanza excepción
    @PostMapping("/registrar")
    public String registrarServicio(@RequestParam String nombre,
                                    @RequestParam String descripcion,
                                    @RequestParam double costo,
                                    Model model) {
        try {
            servicioService.agregar(new Servicio(nombre, descripcion, costo));
            return "redirect:/servicio/gestion";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("nombre", nombre);
            model.addAttribute("descripcion", descripcion);
            model.addAttribute("costo", costo);
            return "Registrar-servicio";
        }
    }

    @GetMapping("/editar")
    public String editarServicio(@RequestParam int id, Model model) {
        model.addAttribute("servicio", servicioService.buscarPorId(id));
        model.addAttribute("paginaActiva", "servicios");
        return "Editar-servicio";
    }

    // REQ-S01, REQ-S02, REQ-S03: el ServiceImpl valida y lanza excepción
    @PostMapping("/editar")
    public String cambiarServicio(@RequestParam int id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion,
                                  @RequestParam double costo,
                                  Model model) {
        try {
            Servicio s = servicioService.buscarPorId(id);
            s.setNombre(nombre);
            s.setDescripcion(descripcion);
            s.setCosto(costo);
            servicioService.actualizar(s);
            return "redirect:/servicio/gestion";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("servicio", servicioService.buscarPorId(id));
            return "Editar-servicio";
        }
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("servicio", servicioService.buscarPorId(id));
        return "Eliminar-servicio";
    }

    // REQ-S04: el ServiceImpl verifica citas y lanza excepción
    @GetMapping("/eliminar")
    public String eliminarServicio(@RequestParam int id, Model model) {
        try {
            servicioService.eliminar(id);
            return "redirect:/servicio/gestion";
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("servicio", servicioService.buscarPorId(id));
            return "Eliminar-servicio";
        }
    }

    @GetMapping("/buscar")
    public String buscarServicio(@RequestParam String nombre, Model model) {
        model.addAttribute("servicios", servicioService.buscarPorNombre(nombre));
        model.addAttribute("paginaActiva", "servicios");
        return "Gestion-servicios";
    }

}
