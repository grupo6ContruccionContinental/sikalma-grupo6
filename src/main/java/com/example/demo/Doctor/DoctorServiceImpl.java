package com.example.demo.Doctor;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    public void agregar(Doctor d) {
        doctorDAO.save(d);
    }

    @Override
    public List<Doctor> listar() {
        return doctorDAO.findAll();
    }

    @Override
    public Doctor buscarPorId(int id) {
        return doctorDAO.findById(id);
    }

    @Override
    public void actualizar(Doctor d) {
        doctorDAO.update(d);
    }

    @Override
    public void eliminar(int id) {
        doctorDAO.delete(id);
    }

    @Override
    public List<Doctor> buscarPorDni(String dni) {
        return doctorDAO.findByDni(dni);
    }
}