package com.example.demo.Cita;

import org.springframework.stereotype.Repository;
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

    @Override
    public List<Cita> buscarPorPaciente( int idPaciente) {

        List<Cita> resultado = new ArrayList<>();

        List<Cita> citas = listaCitas;

        for(Cita c : citas){

            if(c.getPaciente().getId() == idPaciente){

                resultado.add(c);

            }

        }

        return resultado;


    }

    @Override
    public List<Cita> buscarPorDoctor( int idDoctor) {

        List<Cita> resultado = new ArrayList<>();

        List<Cita> citas = listaCitas;

        for(Cita d : citas){

            if(d.getDoctor().getId() == idDoctor){

                resultado.add(d);

            }

        }

        return resultado;


    }

    @Override
    public List<Cita> buscarPorServicio( int idServicio) {

        List<Cita> resultado = new ArrayList<>();

        List<Cita> citas = listaCitas;

        for(Cita s : citas){

            if(s.getServicio().getId() == idServicio){

                resultado.add(s);

            }

        }

        return resultado;


    }
}