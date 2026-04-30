package com.example.demo.Cita;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CitaRepository implements CitaDAO {

    private List<Cita> listaCitas = new ArrayList<>();

    // LISTAR
    @Override
    public List<Cita> listar() {
        return listaCitas;
    }

    // GUARDAR
    @Override
    public void guardar(Cita cita) {
        listaCitas.add(cita);
    }

    // BUSCAR POR ID
    @Override
    public Cita buscarPorId(int id) {
        for (Cita c : listaCitas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // ELIMINAR
    @Override
    public void eliminar(int id) {
        listaCitas.removeIf(c -> c.getId() == id);
    }

    // ACTUALIZAR
    @Override
    public void actualizar(Cita cita) {
        Cita existente = buscarPorId(cita.getId());

        if (existente != null) {
            existente.setPaciente(cita.getPaciente());
            existente.setFecha(cita.getFecha());
            existente.setHora(cita.getHora());
            existente.setEstado(cita.getEstado());
        }
    }
}