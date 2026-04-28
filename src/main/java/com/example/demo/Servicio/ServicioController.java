package com.example.demo.Servicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private ServicioService service = new ServicioServiceImpl();

    @GetMapping("/listar")
    public String listar() {
        return "servicio";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam String nombre) {
        Servicio s = new Servicio();
        s.setNombre(nombre);
        service.guardar(s);
        return "redirect:/servicio/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/servicio/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id) {
        return "editarServicio";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Servicio servicio) {
        service.actualizar(servicio);
        return "redirect:/servicio/listar";
    }
}