package com.example.demo.Atencion;

import org.springframework.stereotype.Service;

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
    public void agregar(int CitaId , LocalTime horaInicio, LocalTime horaFin , String diagnostico, String tratamiento , String estado) {

        Cita c = citaService.buscarPorId(CitaId);

        Atencion a = new Atencion(c, horaInicio,horaFin,diagnostico,tratamiento,estado);

        atencionDAO.save(atencion);
    }

    @Override
    public Atencion buscarPorId(int id) {
        return atencionDAO.findById(id);
    }

    @Override
    public void actualizar(int id, int citaId , LocalTime horaInicio, LocalTime horaFin , String diagnostico, String tratamiento , String estado) {

        Cita c = citaService.buscarPorId(citaId);

        Atencion a = new Atencion(c, horaInicio,horaFin,diagnostico,tratamiento,estado);
        a.setId(id);

        atencionDAO.update(atencion);
    }

    @Override
    public void eliminar(int id) {
        atencionDAO.delete(id);
    }
}
