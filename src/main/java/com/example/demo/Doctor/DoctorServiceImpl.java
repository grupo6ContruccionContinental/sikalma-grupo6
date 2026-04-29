package com.example.demo.Doctor;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static List<Doctor> listaDoctores = new ArrayList<>();
    private static int contadorId = 1;

    @Override
    public List<Doctor> obtenerTodos() {
        return listaDoctores;
    }

    @Override
    public void agregar(Doctor doctor) {
        doctor.setId(contadorId++);
        listaDoctores.add(doctor);
    }

    @Override
    public Doctor buscarPorId(int id) {
        return listaDoctores.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(Doctor doctor) {
        for (int i = 0; i < listaDoctores.size(); i++) {
            if (listaDoctores.get(i).getId() == doctor.getId()) {
                listaDoctores.set(i, doctor);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        listaDoctores.removeIf(d -> d.getId() == id);
    }

    @Override
    public List<Doctor> buscarPorDni(String dni) {
        return listaDoctores.stream()
                .filter(d -> d.getDni().equals(dni))
                .collect(Collectors.toList());
    }
}