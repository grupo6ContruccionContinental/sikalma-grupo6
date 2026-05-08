package com.example.demo.Cita;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CitaRepository implements CitaDAO {

    private List<Cita> lista = new ArrayList<>();

    @Override
    public List<Cita> listar() {
        return lista;
    }

    @Override
    public void guardar(Cita cita) {
        lista.add(cita);
    }

    @Override
    public Cita buscarPorId(int id) {
        for (Cita c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        lista.removeIf(c -> c.getId() == id);
    }

    @Override
    public void actualizar(Cita cita) {
        Cita c = buscarPorId(cita.getId());
        if (c != null) {
            c.setPaciente(cita.getPaciente());
            c.setDoctor(cita.getDoctor());
            c.setServicio(cita.getServicio());
            c.setFecha(cita.getFecha());
            c.setHora(cita.getHora());
            c.setEstado(cita.getEstado());
        }
    }

    /**
     * REQ-C08: Recorre la lista buscando si el doctor ya tiene
     * una cita en esa misma fecha y hora (ignorando la cita con idExcluir).
     */
    @Override
    public boolean existeCruceHorario(int doctorId, LocalDate fecha, LocalTime hora, int idExcluir) {
        for (Cita c : lista) {
            if (c.getId() == idExcluir) continue;
            if (c.getDoctor() != null
                    && c.getDoctor().getId() == doctorId
                    && fecha.equals(c.getFecha())
                    && hora.equals(c.getHora())) {
                return true;
            }
        }
        return false;
    }
}