package com.example.demo.Cita;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CitaRepository implements CitaDAO {

    private List<Cita> listaCitas = new ArrayList<>();
    private int contador = 1;

    // LISTAR
    @Override
    public List<Cita> listar() {
        return listaCitas;
    }

    // GUARDAR
    @Override
    public void guardar(Cita cita) {

        cita.setId(contador ++);
        listaCitas.add(cita);
    }

    // BUSCAR POR ID
    @Override
    public Cita buscarPorId(int id) {
        return listaCitas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ELIMINAR
    @Override
    public void eliminar(int id) {
        listaCitas.removeIf(c -> c.getId() == id);
    }

    // ACTUALIZAR
    @Override
    public void actualizar(Cita cita) {
        for(int i = 0; i < listaCitas.size() ; i++) {
            if(listaCitas.get(i).getId() == cita.getId()) {
                listaCitas.set(i, cita);
                return;
            }
        }
    }
}