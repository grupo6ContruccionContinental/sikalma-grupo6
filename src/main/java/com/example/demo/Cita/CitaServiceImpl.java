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
    public String validarCitasExistentes(int idPaciente){

        if(!citaDAO.buscarPorPaciente(idPaciente).isEmpty()){

            return "El paciente tiene citas registradas";
        }

        return null;


    }

}