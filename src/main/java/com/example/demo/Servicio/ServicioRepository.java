package com.example.demo.Servicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioRepository implements ServicioDAO {

    private List<Servicio> lista = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public List<Servicio> listar() {
        return lista;
    }

    @Override
    public void guardar(Servicio servicio) {
        servicio.setId(contadorId++);
        lista.add(servicio);
    }

    @Override
    public Servicio buscarPorId(int id) {
        for (Servicio s : lista) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public void actualizar(Servicio servicio) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == servicio.getId()) {
                lista.set(i, servicio);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        lista.removeIf(s -> s.getId() == id);
    }
}