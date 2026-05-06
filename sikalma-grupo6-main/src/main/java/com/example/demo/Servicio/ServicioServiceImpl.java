package com.example.demo.Servicio;

import com.example.demo.Cita.CitaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioDAO servicioDAO;
    private final CitaService citaService;

    public ServicioServiceImpl(ServicioDAO servicioDAO, CitaService citaService) {
        this.servicioDAO = servicioDAO;
        this.citaService = citaService;
    }

    // REQ-S01, REQ-S02, REQ-S03
    private void validar(String nombre, String descripcion, double costo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio es obligatorio");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio es obligatoria");
        }
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a S/ 0.00");
        }
    }

    @Override
    public void agregar(Servicio s) {
        validar(s.getNombre(), s.getDescripcion(), s.getCosto());
        servicioDAO.save(s);
    }

    @Override
    public List<Servicio> listar() {
        return servicioDAO.findAll();
    }

    @Override
    public Servicio buscarPorId(int id) {
        return servicioDAO.findById(id);
    }

    @Override
    public void actualizar(Servicio s) {
        validar(s.getNombre(), s.getDescripcion(), s.getCosto());
        servicioDAO.update(s);
    }

    // REQ-S04
    @Override
    public void eliminar(int id) {
        boolean tieneCitas = citaService.listar().stream()
                .anyMatch(c -> c.getServicio().getId() == id);

        if (tieneCitas) {
            throw new IllegalStateException("No se puede eliminar el servicio porque tiene citas registradas");
        }
        servicioDAO.delete(id);
    }

    @Override
    public List<Servicio> buscarPorNombre(String nombre) {
        return servicioDAO.findByNombre(nombre);
    }

}

