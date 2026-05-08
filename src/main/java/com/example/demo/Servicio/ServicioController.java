package com.example.demo.Servicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Cita.CitaService;

import java.util.List;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;
    private final CitaService citaService;

    public ServicioController(ServicioService servicioService , CitaService citaService) {
        this.servicioService = servicioService;
        this.citaService = citaService;
    }

    @GetMapping("/gestion")
    public String gestionServicio(Model model) {
        List<Servicio> servicios = servicioService.listar();
        model.addAttribute("servicios", servicios);
        model.addAttribute("paginaActiva", "servicios");
        return "Gestion-servicios";
    }

    @GetMapping("/nuevo")
    public String nuevoServicio(Model model) {
        model.addAttribute("paginaActiva", "servicios");
        return "Registrar-servicio";
    }

    @PostMapping("/registrar")
    public String registrarServicio(@ModelAttribute Servicio s, Model model) {

        String error = servicioService.validarDatosRegistro(s);
        if(error != null){

            model.addAttribute("error", error);
            model.addAttribute("servicio" , s);
            model.addAttribute("paginaActiva" , "servicios");
            return "Registrar-servicio";

        } 

        servicioService.agregar(s);

        return "redirect:/servicio/gestion";
    }

    @GetMapping("/editar")
    public String editarServicio(@RequestParam int id, Model model) {
        model.addAttribute("servicio", servicioService.buscarPorId(id));
        model.addAttribute("paginaActiva", "servicios");
        return "Editar-servicio";
    }

    @PostMapping("/editar")
    public String cambiarServicio(@ModelAttribute Servicio s, Model model) {

        String error = servicioService.validarDatosEdicion(s);
        if (error != null) {
    
            model.addAttribute("error", error);
            model.addAttribute("servicio" , s);
            model.addAttribute("paginaActiva" , "servicios");
            return "Editar-servicio";

        }

        servicioService.actualizar(s);
        return "redirect:/servicio/gestion";
    }

    @GetMapping("/advertir")
    public String advertir(@RequestParam int id, Model model) {

        String error = citaService.validarCitasExistentesServicio(id);
        if(error != null){

            model.addAttribute("error" ,error);
            
            return "Eliminar-servicio-error-message";
        }

        model.addAttribute("servicio", servicioService.buscarPorId(id));
        
        return "Eliminar-servicio";
    }

    @GetMapping("/eliminar")
    public String eliminarServicio(@RequestParam int id) {
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