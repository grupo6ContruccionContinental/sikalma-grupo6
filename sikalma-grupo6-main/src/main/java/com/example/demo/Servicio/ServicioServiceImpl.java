package com.example.demo.Servicio;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioDAO servicioDAO;

    public ServicioServiceImpl(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    @Override
    public void agregar(Servicio s) {
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
        servicioDAO.update(s);
    }

    @Override
    public void eliminar(int id) {
        servicioDAO.delete(id);
    }

    @Override
    public List<Servicio> buscarPorNombre(String nombre) {
        return servicioDAO.findByNombre(nombre);
    }

}
