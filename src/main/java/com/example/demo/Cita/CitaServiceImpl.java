package com.example.demo.Cita;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorService;
import com.example.demo.Paciente.Paciente;
import com.example.demo.Paciente.PacienteService;
import com.example.demo.Servicio.Servicio;
import com.example.demo.Servicio.ServicioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaDAO citaDAO;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;
    private final ServicioService servicioService;

    public CitaServiceImpl(CitaDAO citaDAO, PacienteService pacienteService ,DoctorService doctorService ,ServicioService servicioService ){
        this.citaDAO = citaDAO;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
        this.servicioService = servicioService;
    }


    @Override
    public List<Cita> listar() {
        return citaDAO.listar();
    }

    @Override
    public void guardar(int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora, String estado) {

        Paciente p = pacienteService.buscarPorId(pacienteId);
        Doctor d = doctorService.buscarPorId(doctorId);
        Servicio s = servicioService.buscarPorId(servicioId);

        Cita c = new Cita(p,d,s,fecha, hora,estado);

        citaDAO.guardar(c);
    }

    @Override
    public Cita buscarPorId(int id) {
        return citaDAO.buscarPorId(id);
    }

    @Override
    public void eliminar(int id) {
        citaDAO.eliminar(id);
    }

    @Override
    public void actualizar(int id ,int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora, String estado) {

        Paciente p = pacienteService.buscarPorId(pacienteId);
        Doctor d = doctorService.buscarPorId(doctorId);
        Servicio s = servicioService.buscarPorId(servicioId);

        Cita c = new Cita(p,d,s,fecha, hora,estado);
        c.setId(id);

        citaDAO.actualizar(c);
    }

    @Override
    public List<Cita> buscarCitaPorPaciente (int idPaciente) {
        return citaDAO.buscarPorPaciente(idPaciente);
    }


    // validaciones
    @Override
    public String validarDatosRegistro(int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora){

        String error = validacionesGenerales(pacienteId, doctorId,servicioId, fecha, hora);

        if(error != null ){

            return error;

        }
        
        return null;

    }

    @Override
    public String validarDatosEdicion(int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora){

        String error = validacionesGenerales(pacienteId , doctorId ,servicioId,fecha,hora);

        if(error != null ){

            return error;

        }
        
        return null;

    }


    @Override
    public String validarCitasExistentesPaciente(int idPaciente){

        if(!citaDAO.buscarPorPaciente(idPaciente).isEmpty()){

            return "El paciente tiene citas registradas";
        }

        return null;


    }

    @Override
    public String validarCitasExistentesDoctor(int idDoctor){

        if(!citaDAO.buscarPorDoctor(idDoctor).isEmpty()){

            return "El doctor tiene citas registradas";
        }

        return null;


    }



    public String validacionesGenerales(int pacienteId, int doctorId, int servicioId, LocalDate fecha, LocalTime hora) {

        if(pacienteId <= 0){
            
            return "Debe de seleccionar un paciente";

        }else if(doctorId <= 0 ){

            return "Debe de seleccionar un doctor";

        }else if(servicioId <= 0l ){

            return "Debe de seleccionar un servicio";

        }else if(fecha == null){

            return "La fecha de reserva es obligatorio";

        }else if(hora == null){

            return "La hora de reserva es obligatorio";

        }

        return null;

    }

}