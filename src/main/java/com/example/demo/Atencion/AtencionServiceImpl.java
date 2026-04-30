package com.example.demo.Atencion;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    private final AtencionDAO atencionDAO;

    public AtencionServiceImpl(AtencionDAO atencionDAO) {
        this.atencionDAO = atencionDAO;
    }

    @Override
    public List<Atencion> obtenerTodos() {
        return atencionDAO.findAll();
    }

    @Override
    public void agregar(Atencion atencion) {
        atencionDAO.save(atencion);
    }

    @Override
    public Atencion buscarPorId(int id) {
        return atencionDAO.findById(id);
    }

    @Override
    public void actualizar(Atencion atencion) {
        atencionDAO.update(atencion);
    }

    @Override
    public void eliminar(int id) {
        atencionDAO.delete(id);
    }
}
