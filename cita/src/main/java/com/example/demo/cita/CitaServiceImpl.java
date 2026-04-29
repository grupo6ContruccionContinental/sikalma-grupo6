package com.example.demo.cita;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaDAO citaDAO;

    public CitaServiceImpl(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    @Override
    public List<Cita> listar() {
        return citaDAO.listar();
    }

    @Override
    public void agregar(Cita c) {
        c.setEstado("Pendiente");
        citaDAO.agregar(c);
    }

    @Override
    public Cita buscarPorId(int id) {
        return citaDAO.buscarPorId(id);
    }

    @Override
    public void actualizar(Cita c) {
        citaDAO.actualizar(c);
    }

    @Override
    public void eliminar(int id) {
        citaDAO.eliminar(id);
    }
}