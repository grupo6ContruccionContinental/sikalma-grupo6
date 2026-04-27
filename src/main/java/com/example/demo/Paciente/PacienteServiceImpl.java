package com.example.demo.Paciente;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteDAO PacienteDAO;

    public PacienteServiceImpl(PacienteDAO PacienteDAO){
        this.PacienteDAO = PacienteDAO;
    }

    @Override
    public void agregar(Paciente p){
        PacienteDAO.save(p);
    }

    @Override
    public List<Paciente> listar() {
        return PacienteDAO.findAll();
    }

    @Override
    public Paciente buscarPorId(int id){
        return PacienteDAO.findById(id);
    }

    @Override
    public void actualizar(Paciente p){
        PacienteDAO.update(p);
    }

    @Override
    public void eliminar(int id) {
        PacienteDAO.delete(id);
    }

    @Override
    public List<Paciente> buscarPorDni(String dni){
        return PacienteDAO.findByDni(dni);
    }

}
