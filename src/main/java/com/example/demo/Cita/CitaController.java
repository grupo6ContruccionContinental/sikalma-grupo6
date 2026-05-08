package com.example.demo.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/g-citas")
    public String mostrarCitas(Model model) {
        model.addAttribute("citas", citaService.listar());
        return "Gestion-citas";
    }

    @GetMapping("/r-citas")
    public String registrarCita() {
        return "Registrar-cita";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        String error = citaService.guardar(cita);
        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/cita/r-citas";
        }
        return "redirect:/cita/g-citas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        Cita cita = citaService.buscarPorId(id);
        model.addAttribute("cita", cita);
        return "Editar-cita";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        String error = citaService.actualizar(cita);
        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/cita/editar/" + cita.getId();
        }
        return "redirect:/cita/g-citas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        citaService.eliminar(id);
        return "redirect:/cita/g-citas";
    }

    // REQ-C07: Marcar "No asistió"
    @GetMapping("/no-asistio/{id}")
    public String marcarNoAsistio(@PathVariable int id, RedirectAttributes redirectAttributes) {
        String error = citaService.marcarNoAsistio(id);
        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
        }
        return "redirect:/cita/g-citas";
    }
}
