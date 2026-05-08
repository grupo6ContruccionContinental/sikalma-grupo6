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
    public String validarDatosRegistro(Atencion atencion) {
        String error = validacionesGenerales(atencion);
        if (error != null) return error;
        return null;
    }

    @Override
    public String validarDatosEdicion(Atencion atencion) {
        String error = validacionesGenerales(atencion);
        if (error != null) return error;
        return null;
    }

    public String validacionesGenerales(Atencion atencion) {

        if (atencion.getDiagnostico() == null || atencion.getDiagnostico().trim().isEmpty()) {
            return "El diagnostico es obligatorio";
        } else if (atencion.getTratamiento() == null || atencion.getTratamiento().trim().isEmpty()) {
            return "El tratamiento es obligatorio";
        } else if (!atencion.getHoraFin().isAfter(atencion.getHoraInicio())) {
            return "La hora fin debe ser mayor a la hora de inicio";
        }

        return null;
    }
}
