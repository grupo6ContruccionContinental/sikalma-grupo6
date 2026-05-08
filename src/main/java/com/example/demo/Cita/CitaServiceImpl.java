package com.example.demo.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDAO citaDAO;

    @Override
    public List<Cita> listar() {
        return citaDAO.listar();
    }

    // REQ-C01 a REQ-C08: Validaciones al guardar
    @Override
    public String guardar(Cita cita) {
        String error = validarCita(cita, -1);
        if (error != null) return error;
        citaDAO.guardar(cita);
        return null;
    }

    @Override
    public Cita buscarPorId(int id) {
        return citaDAO.buscarPorId(id);
    }

    @Override
    public void eliminar(int id) {
        citaDAO.eliminar(id);
    }

    // REQ-C01 a REQ-C08: Validaciones al actualizar (se excluye la cita actual del chequeo de cruce)
    @Override
    public String actualizar(Cita cita) {
        String error = validarCita(cita, cita.getId());
        if (error != null) return error;
        citaDAO.actualizar(cita);
        return null;
    }

    // REQ-C07: Marcar "No asistió" solo si el estado actual es "Confirmada"
    @Override
    public String marcarNoAsistio(int id) {
        Cita cita = citaDAO.buscarPorId(id);
        if (cita == null) {
            return "Cita no encontrada.";
        }
        if (!"Confirmada".equals(cita.getEstado())) {
            return "Solo se puede marcar como 'No asistió' una cita con estado Confirmada.";
        }
        cita.setEstado("No asistió");
        citaDAO.actualizar(cita);
        return null;
    }

    // ── Validaciones centralizadas ──────────────────────────────────────────

    private String validarCita(Cita cita, int idExcluir) {
        // REQ-C01
        if (cita.getPaciente() == null || cita.getPaciente().getId() == 0) {
            return "Debe seleccionar un paciente.";
        }
        // REQ-C02
        if (cita.getDoctor() == null || cita.getDoctor().getId() == 0) {
            return "Debe seleccionar un doctor.";
        }
        // REQ-C03
        if (cita.getServicio() == null || cita.getServicio().getId() == 0) {
            return "Debe seleccionar un servicio.";
        }
        // REQ-C04
        if (cita.getFecha() == null) {
            return "La fecha de la cita es obligatoria.";
        }
        // REQ-C05
        if (cita.getHora() == null) {
            return "La hora de la cita es obligatoria.";
        }
        // REQ-C06
        if (cita.getFecha().isBefore(LocalDate.now())) {
            return "La fecha de la cita no puede ser anterior a hoy.";
        }
        // REQ-C08: cruce de horario del doctor
        for (Cita c : citaDAO.listar()) {
            if (c.getId() == idExcluir) continue; // al actualizar, se excluye la misma cita
            if (c.getDoctor() != null
                    && c.getDoctor().getId() == cita.getDoctor().getId()
                    && c.getFecha() != null && c.getFecha().equals(cita.getFecha())
                    && c.getHora() != null && c.getHora().equals(cita.getHora())) {
                return "El doctor ya tiene una cita registrada en esa fecha y hora.";
            }
        }
        return null;
    }
}
