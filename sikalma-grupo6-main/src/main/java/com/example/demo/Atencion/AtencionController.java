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

    // REQ-A01..A03: validaciones al registrar
    @PostMapping("/nuevo")
    public String registrarAtencion(@RequestParam int citaId,
                                    @RequestParam LocalTime horaInicio,
                                    @RequestParam LocalTime horaFin,
                                    @RequestParam String diagnostico,
                                    @RequestParam String tratamiento,
                                    @RequestParam String estado,
                                    Model model) {

        String error = atencionService.validarDatosRegistro(horaInicio, horaFin,
                diagnostico, tratamiento);

        if (error != null) {
            // REQ-A04 ya se validó en CitaController antes de abrir este formulario,
            // pero necesitamos recargar la cita para volver al JSP con los datos
            model.addAttribute("error", error);
            model.addAttribute("cita",
                    // reutilizamos citaId para recargar la cita de origen
                    new com.example.demo.Cita.Cita());
            // Recargamos la cita completa a través del citaId guardado en el hidden
            model.addAttribute("citaId", citaId);
            model.addAttribute("paginaActiva", "citas");
            return "Registrar-atencion";
        }

        atencionService.agregar(citaId, horaInicio, horaFin, diagnostico, tratamiento, estado);
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

    // REQ-A01..A03: validaciones al editar
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id,
                             @RequestParam int citaId,
                             @RequestParam LocalTime horaInicio,
                             @RequestParam LocalTime horaFin,
                             @RequestParam String diagnostico,
                             @RequestParam String tratamiento,
                             @RequestParam String estado,
                             Model model) {

        String error = atencionService.validarDatosEdicion(horaInicio, horaFin,
                diagnostico, tratamiento);

        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("atencion", atencionService.buscarPorId(id));
            model.addAttribute("paginaActiva", "atencion");
            return "Editar-atencion";
        }

        atencionService.actualizar(id, citaId, horaInicio, horaFin, diagnostico, tratamiento, estado);
        return "redirect:/atencion/gestion";
    }
}
