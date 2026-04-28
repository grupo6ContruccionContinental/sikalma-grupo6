package com.example.demo.Doctor;

import java.util.List;

public interface DoctorService {
    void agregar(Doctor d);
    List<Doctor> listar();
    Doctor buscarPorId(int id);
    void actualizar(Doctor d);
    void eliminar(int id);
    List<Doctor> buscarPorDni(String dni);
}