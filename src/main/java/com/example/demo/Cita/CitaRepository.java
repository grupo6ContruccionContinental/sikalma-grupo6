package com.example.demo.Cita;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CitaRepository implements CitaDAO {

    private List<Cita> listaCitas = new ArrayList<>();
    private int contador = 1;

    @Override
    public List<Cita> listar() {
        return listaCitas;
    }

    @Override
    public void guardar(Cita cita) {

        cita.setId(contador ++);
        listaCitas.add(cita);
    }

    @Override
    public Cita buscarPorId(int id) {
        return listaCitas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminar(int id) {
        listaCitas.removeIf(c -> c.getId() == id);
    }

    @Override
    public void actualizar(Cita cita) {
        for(int i = 0; i < listaCitas.size() ; i++) {
            if(listaCitas.get(i).getId() == cita.getId()) {
                listaCitas.set(i, cita);
                return;
            }
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