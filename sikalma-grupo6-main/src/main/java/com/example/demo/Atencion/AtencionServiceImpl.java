package com.example.demo.Atencion;

import org.springframework.stereotype.Service;
import com.example.demo.Cita.CitaService;
import com.example.demo.Cita.Cita;

import java.time.LocalTime;
import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    private final AtencionDAO atencionDAO;
    private final CitaService citaService;

    public AtencionServiceImpl(AtencionDAO atencionDAO, CitaService citaService) {
        this.atencionDAO = atencionDAO;
        this.citaService = citaService;
    }

    @Override
    public List<Atencion> obtenerTodos() {
        return atencionDAO.findAll();
    }

    @Override
    public void agregar(int citaId, LocalTime horaInicio, LocalTime horaFin,
                        String diagnostico, String tratamiento, String estado) {
        Cita c = citaService.buscarPorId(citaId);
        Atencion a = new Atencion(c, horaInicio, horaFin, diagnostico, tratamiento, estado);
        atencionDAO.save(a);
    }

    @Override
    public Atencion buscarPorId(int id) {
        return atencionDAO.findById(id);
    }

    @Override
    public void actualizar(int id, int citaId, LocalTime horaInicio, LocalTime horaFin,
                           String diagnostico, String tratamiento, String estado) {
        Cita c = citaService.buscarPorId(citaId);
        Atencion a = new Atencion(c, horaInicio, horaFin, diagnostico, tratamiento, estado);
        a.setId(id);
        atencionDAO.update(a);
    }

    @Override
    public void eliminar(int id) {
        atencionDAO.delete(id);
    }

    // ── Validaciones ──────────────────────────────────────────────────────────

    @Override
    public String validarDatosRegistro(LocalTime horaInicio, LocalTime horaFin,
                                       String diagnostico, String tratamiento) {
        return validacionesGenerales(horaInicio, horaFin, diagnostico, tratamiento);
    }

    @Override
    public String validarDatosEdicion(LocalTime horaInicio, LocalTime horaFin,
                                      String diagnostico, String tratamiento) {
        return validacionesGenerales(horaInicio, horaFin, diagnostico, tratamiento);
    }

    private String validacionesGenerales(LocalTime horaInicio, LocalTime horaFin,
                                         String diagnostico, String tratamiento) {

        // REQ-A01: diagnóstico obligatorio
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            return "El diagnóstico es obligatorio";
        }

        // REQ-A02: tratamiento obligatorio
        if (tratamiento == null || tratamiento.trim().isEmpty()) {
            return "El tratamiento es obligatorio";
        }

        // REQ-A03: hora de fin debe ser mayor a hora de inicio
        if (horaInicio != null && horaFin != null && !horaFin.isAfter(horaInicio)) {
            return "La hora de fin debe ser mayor a la hora de inicio";
        }

        return null;
    }
}
