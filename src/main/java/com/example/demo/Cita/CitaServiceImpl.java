package com.example.demo.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDAO citaDAO;

    @Override
    public List<Cita> listar() {
        return citaDAO.listar();
    }

    @Override
    public void guardar(Cita cita) {
        citaDAO.guardar(cita);
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
    public void actualizar(Cita cita) {
        citaDAO.actualizar(cita);
    }
}