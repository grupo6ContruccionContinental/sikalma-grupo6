package com.example.demo.Servicio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServicioRepository implements ServicioDAO {

    private List<Servicio> lista = new ArrayList<>();
    private int contador = 1;

    @Override
    public void save(Servicio s) {
        s.setId(contador++);
        lista.add(s);
    }

    @Override
    public List<Servicio> findAll() {
        return lista;
    }

    @Override
    public Servicio findById(int id) {
        return lista.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Servicio s) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == s.getId()) {
                lista.set(i, s);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        lista.removeIf(s -> s.getId() == id);
    }

    @Override
    public List<Servicio> findByNombre(String nombre) {
        return lista.stream()
                .filter(s -> s.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

}
