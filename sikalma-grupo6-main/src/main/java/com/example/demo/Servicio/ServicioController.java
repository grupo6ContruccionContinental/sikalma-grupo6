package com.example.demo.Servicio;

import com.example.demo.Cita.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;
    private final CitaService citaService;

    public ServicioController(ServicioService servicioService, CitaService citaService) {
        this.servicioService = servicioService;
        this.citaService = citaService;
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

    // REQ-S01, REQ-S02, REQ-S03: Validaciones al registrar
    @PostMapping("/registrar")
    public String registrarServicio(@RequestParam String nombre,
                                    @RequestParam String descripcion,
                                    @RequestParam double costo,
                                    Model model) {

        if (nombre == null || nombre.trim().isEmpty()) {
            model.addAttribute("errorNombre", "El nombre del servicio es obligatorio");
            model.addAttribute("descripcion", descripcion);
            model.addAttribute("costo", costo);
            return "Registrar-servicio";
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            model.addAttribute("errorDescripcion", "La descripción del servicio es obligatoria");
            model.addAttribute("nombre", nombre);
            model.addAttribute("costo", costo);
            return "Registrar-servicio";
        }

        if (costo <= 0) {
            model.addAttribute("errorCosto", "El costo debe ser mayor a S/ 0.00");
            model.addAttribute("nombre", nombre);
            model.addAttribute("descripcion", descripcion);
            return "Registrar-servicio";
        }

        servicioService.agregar(new Servicio(nombre.trim(), descripcion.trim(), costo));
        return "redirect:/servicio/gestion";
    }

    @GetMapping("/editar")
    public String editarServicio(@RequestParam int id, Model model) {
        model.addAttribute("servicio", servicioService.buscarPorId(id));
        model.addAttribute("paginaActiva", "servicios");
        return "Editar-servicio";
    }

    // REQ-S01, REQ-S02, REQ-S03: Validaciones al editar
    @PostMapping("/editar")
    public String cambiarServicio(@RequestParam int id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion,
                                  @RequestParam double costo,
                                  Model model) {

        Servicio servicio = servicioService.buscarPorId(id);

        if (nombre == null || nombre.trim().isEmpty()) {
            model.addAttribute("errorNombre", "El nombre del servicio es obligatorio");
            model.addAttribute("servicio", servicio);
            return "Editar-servicio";
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            model.addAttribute("errorDescripcion", "La descripción del servicio es obligatoria");
            model.addAttribute("servicio", servicio);
            return "Editar-servicio";
        }

        if (costo <= 0) {
            model.addAttribute("errorCosto", "El costo debe ser mayor a S/ 0.00");
            model.addAttribute("servicio", servicio);
            return "Editar-servicio";
        }

        servicio.setNombre(nombre.trim());
        servicio.setDescripcion(descripcion.trim());
        servicio.setCosto(costo);
        servicioService.actualizar(servicio);
        return "redirect:/servicio/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {
        model.addAttribute("servicio", servicioService.buscarPorId(id));
        return "Eliminar-servicio";
    }

    // REQ-S04: Verificar citas asociadas antes de eliminar
    @GetMapping("/eliminar")
    public String eliminarServicio(@RequestParam int id, Model model) {

        boolean tieneCitas = citaService.listar().stream()
                .anyMatch(c -> c.getServicio().getId() == id);

        if (tieneCitas) {
            model.addAttribute("servicio", servicioService.buscarPorId(id));
            model.addAttribute("errorEliminar", "No se puede eliminar el servicio porque tiene citas registradas");
            return "Eliminar-servicio";
        }

        servicioService.eliminar(id);
        return "redirect:/servicio/gestion";
    }

    @GetMapping("/buscar")
    public String buscarServicio(@RequestParam String nombre, Model model) {
        model.addAttribute("servicios", servicioService.buscarPorNombre(nombre));
        model.addAttribute("paginaActiva", "servicios");
        return "Gestion-servicios";
    }

}