package com.example.demo.Cita;

import com.example.demo.Doctor.DoctorService;
import com.example.demo.Paciente.PacienteService;
import com.example.demo.Servicio.ServicioService;
import org.springframework.ui.Model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;
    private final ServicioService servicioService;

    public CitaController(CitaService citaService, PacienteService pacienteService,DoctorService doctorService, ServicioService servicioService ){
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
        this.servicioService = servicioService;
    }


    @GetMapping("/g-citas")
    public String mostrarCitas(Model model){

        model.addAttribute("paginaActiva", "citas");
        model.addAttribute("citas", citaService.listar());
        return "Gestion-citas";

    }


    @GetMapping("/r-citas")
    public String registrarCita(Model model){
        model.addAttribute("paginaActiva", "r-citas");
        model.addAttribute("pacientes" , pacienteService.listar());
        model.addAttribute("doctores" , doctorService.obtenerTodos());
        model.addAttribute("servicios" , servicioService.listar());

        return "Registrar-cita";
    }


    @PostMapping("/guardar")
    public String guardar(@RequestParam int paciente, @RequestParam int doctor, @RequestParam int servicio, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate  fecha, @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime hora, @RequestParam String estado, Model model){
        
        String error = citaService.validarDatosRegistro(paciente,doctor ,servicio,fecha,hora);
        if (error != null) {
    
            model.addAttribute("error", error);
            model.addAttribute("paginaActiva" , "citas");
            return "Registrar-cita";

        }

        citaService.guardar(paciente,doctor,servicio,fecha,hora,estado);
        return "redirect:/cita/g-citas";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id , Model model){

        model.addAttribute("cita" , citaService.buscarPorId(id));
        model.addAttribute("servicios" , servicioService.listar());
        model.addAttribute("doctores" , doctorService.obtenerTodos());
        model.addAttribute("paginaActiva" , "r-citas");

        return "Editar-cita";
    }


    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id,@RequestParam int paciente, @RequestParam int doctor, @RequestParam int servicio, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate  fecha, @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime hora, @RequestParam String estado, Model model){

        String error = citaService.validarDatosRegistro(paciente,doctor ,servicio,fecha,hora);
        if (error != null) {
    
            model.addAttribute("error", error);
            model.addAttribute("paginaActiva" , "citas");
            return "Editar-cita";

        }

        citaService.actualizar(id,paciente,doctor,servicio,fecha,hora,estado);
        return "redirect:/cita/g-citas";

    }

    @GetMapping("/atender")
    public String atenderCita(@RequestParam int id, Model model){


        model.addAttribute( "cita" , citaService.buscarPorId(id));
        model.addAttribute("paginaActiva", "citas");

        return "Registrar-atencion";
    }

    @GetMapping("/cancelar")
    public String cancelar(@RequestParam int id, Model model){

        model.addAttribute("cita", citaService.buscarPorId(id));

        return "Cancelar-cita";
    }

    
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id){
        citaService.eliminar(id);
        return "redirect:/cita/g-citas";
    }
}