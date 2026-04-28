package com.example.demo.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> obtenerTodos();
    void agregar(Doctor doctor);
    Doctor buscarPorId(int id);
    void actualizar(Doctor doctor);
    void eliminar(int id);
}