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
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaDAO citaDAO;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;
    private final ServicioService servicioService;

    public CitaServiceImpl(CitaDAO citaDAO, PacienteService pacienteService,
                           DoctorService doctorService, ServicioService servicioService) {
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
    public void guardar(int pacienteId, int doctorId, int servicioId,
                        LocalDate fecha, LocalTime hora, String estado) {
        Paciente p = pacienteService.buscarPorId(pacienteId);
        Doctor d = doctorService.buscarPorId(doctorId);
        Servicio s = servicioService.buscarPorId(servicioId);
        Cita c = new Cita(p, d, s, fecha, hora, estado);
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
    public void actualizar(int id, int pacienteId, int doctorId, int servicioId,
                           LocalDate fecha, LocalTime hora, String estado) {
        Paciente p = pacienteService.buscarPorId(pacienteId);
        Doctor d = doctorService.buscarPorId(doctorId);
        Servicio s = servicioService.buscarPorId(servicioId);
        Cita c = new Cita(p, d, s, fecha, hora, estado);
        c.setId(id);
        citaDAO.actualizar(c);
    }

    @Override
    public List<Cita> buscarCitaPorPaciente(int idPaciente) {
        return citaDAO.buscarPorPaciente(idPaciente);
    }

    @Override
    public List<Cita> buscarCitaPorDoctor(int idDoctor) {
        return citaDAO.buscarPorDoctor(idDoctor);
    }

    // ── Validaciones de eliminación ───────────────────────────────────────────

    @Override
    public String validarCitasExistentesPaciente(int idPaciente) {
        if (!citaDAO.buscarPorPaciente(idPaciente).isEmpty()) {
            return "No se puede eliminar al paciente porque tiene citas registradas";
        }
        return null;
    }

    @Override
    public String validarCitasExistentesDoctor(int idDoctor) {
        if (!citaDAO.buscarPorDoctor(idDoctor).isEmpty()) {
            return "No se puede eliminar al doctor porque tiene citas asignadas";
        }
        return null;
    }

    @Override
    public String validarCitasExistentesServicio(int idServicio) {
        if (!citaDAO.buscarPorServicio(idServicio).isEmpty()) {
            return "No se puede eliminar el servicio porque tiene citas registradas";
        }
        return null;
    }

    // ── Validaciones de registro ──────────────────────────────────────────────

    @Override
    public String validarDatosRegistro(int pacienteId, int doctorId, int servicioId,
                                       LocalDate fecha, LocalTime hora) {
        if (pacienteId == 0) return "Debe seleccionar un paciente";
        if (doctorId == 0)   return "Debe seleccionar un doctor";
        if (servicioId == 0) return "Debe seleccionar un servicio";
        if (fecha == null)   return "La fecha de la cita es obligatoria";
        if (hora == null)    return "La hora de la cita es obligatoria";
        if (fecha.isBefore(LocalDate.now())) return "La fecha de la cita no puede ser anterior a hoy";

        boolean haycruce = citaDAO.listar().stream()
                .anyMatch(c -> c.getDoctor().getId() == doctorId
                        && c.getFecha().equals(fecha)
                        && c.getHora().equals(hora));
        if (haycruce) return "El doctor ya tiene una cita registrada en esa fecha y hora";

        return null;
    }

    // ── Validaciones de edición ───────────────────────────────────────────────

    @Override
    public String validarDatosEdicion(int citaId, int pacienteId, int doctorId, int servicioId,
                                      LocalDate fecha, LocalTime hora) {
        if (doctorId == 0)   return "Debe seleccionar un doctor";
        if (servicioId == 0) return "Debe seleccionar un servicio";
        if (fecha == null)   return "La fecha de la cita es obligatoria";
        if (hora == null)    return "La hora de la cita es obligatoria";
        if (fecha.isBefore(LocalDate.now())) return "La fecha de la cita no puede ser anterior a hoy";

        boolean haycruce = citaDAO.listar().stream()
                .anyMatch(c -> c.getId() != citaId
                        && c.getDoctor().getId() == doctorId
                        && c.getFecha().equals(fecha)
                        && c.getHora().equals(hora));
        if (haycruce) return "El doctor ya tiene una cita registrada en esa fecha y hora";

        return null;
    }
}
