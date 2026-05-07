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

        // REQ-A04: La cita debe estar en estado "Confirmada"
        if (c == null || !"Confirmada".equals(c.getEstado())) {
            throw new AtencionException("Solo se puede atender una cita en estado Confirmada");
        }

        // REQ-A01: Diagnóstico obligatorio
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            throw new AtencionException("El diagnóstico es obligatorio");
        }

        // REQ-A02: Tratamiento obligatorio
        if (tratamiento == null || tratamiento.trim().isEmpty()) {
            throw new AtencionException("El tratamiento es obligatorio");
        }

        // REQ-A03: horaFin debe ser estrictamente mayor a horaInicio
        if (horaFin == null || horaInicio == null || !horaFin.isAfter(horaInicio)) {
            throw new AtencionException("La hora de fin debe ser mayor a la hora de inicio");
        }

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

        // REQ-A01: Diagnóstico obligatorio
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            throw new AtencionException("El diagnóstico es obligatorio");
        }

        // REQ-A02: Tratamiento obligatorio
        if (tratamiento == null || tratamiento.trim().isEmpty()) {
            throw new AtencionException("El tratamiento es obligatorio");
        }

        // REQ-A03: horaFin debe ser estrictamente mayor a horaInicio
        if (horaFin == null || horaInicio == null || !horaFin.isAfter(horaInicio)) {
            throw new AtencionException("La hora de fin debe ser mayor a la hora de inicio");
        }

        Atencion a = new Atencion(c, horaInicio, horaFin, diagnostico, tratamiento, estado);
        a.setId(id);
        atencionDAO.update(a);
    }

    @Override
    public void eliminar(int id) {
        atencionDAO.delete(id);
    }
}
