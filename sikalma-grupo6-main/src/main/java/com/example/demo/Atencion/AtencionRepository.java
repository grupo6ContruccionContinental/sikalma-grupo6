package com.example.demo.Atencion;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AtencionRepository implements AtencionDAO {

    private List<Atencion> lista = new ArrayList<>();
    private int contador = 1;

    @Override
    public void save(Atencion a) {
        a.setId(contador++);
        lista.add(a);
    }

    @Override
    public List<Atencion> findAll() {
        return lista;
    }

    @Override
    public Atencion findById(int id) {
        return lista.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Atencion a) {
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == a.getId()) {
                lista.set(i, a);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        lista.removeIf(a -> a.getId() == id);
    }
}
