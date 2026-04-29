package com.example.demo.cita;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CitaRepository implements CitaDAO {

    private List<Cita> lista = new ArrayList<>();
    private int contador = 1;

    @Override
    public List<Cita> listar() {
        return lista;
    }

    @Override
    public void agregar(Cita c) {
        c.setId(contador++);
        lista.add(c);
    }

    @Override
    public Cita buscarPorId(int id) {
        return lista.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(Cita c) {
        Cita aux = buscarPorId(c.getId());
        if (aux != null) {
            aux.setId_paciente(c.getId_paciente());
            aux.setId_doctor(c.getId_doctor());
            aux.setId_servicio(c.getId_servicio());
            aux.setFecha(c.getFecha());
            aux.setHora(c.getHora());
            aux.setEstado(c.getEstado());
        }
    }

    @Override
    public void eliminar(int id) {
        lista.removeIf(c -> c.getId() == id);
    }
}