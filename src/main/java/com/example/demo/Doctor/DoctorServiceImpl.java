package com.example.demo.Doctor;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    // Usamos la lista en memoria como veníamos haciendo
    private static List<Doctor> listaDoctores = new ArrayList<>();
    private static int contadorId = 1;

    @Override
    public void agregar(Doctor doctor) {
        doctor.setId(contadorId++);
        listaDoctores.add(doctor);
    }

    @Override
    public List<Doctor> obtenerTodos() {
        return listaDoctores;
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


    // VALIDACIONES


    @Override
    public String validarDatosRegistro(Doctor doctor) {
        String error = validacionesGenerales(doctor);

        if (error != null) {
            return error;
        } else if (listaDoctores.stream().anyMatch(d -> d.getDni().equals(doctor.getDni()))) {
            return "Ya existe un doctor registrado con ese DNI";
        } else if (listaDoctores.stream().anyMatch(d -> d.getCorreo() != null && d.getCorreo().equalsIgnoreCase(doctor.getCorreo()))) {
            return "Ya existe un usuario registrado con ese correo";
        }

        return null;
    }

    @Override
    public String validarDatosEdicion(Doctor doctor) {
        String error = validacionesGenerales(doctor);

        if (error != null) {
            return error;
        } else if (listaDoctores.stream().anyMatch(d -> d.getDni().equals(doctor.getDni()) && d.getId() != doctor.getId())) {
            return "Ya existe otro doctor registrado con ese DNI";
        }

        return null;
    }

    public String validacionesGenerales(Doctor doctor) {
        if (doctor.getNombre() == null || doctor.getNombre().trim().isEmpty()) {
            return "El nombre del doctor es obligatorio";
        } else if (doctor.getEspecialidad() == null || doctor.getEspecialidad().trim().isEmpty()) {
            return "La especialidad es obligatoria";
        } else if (doctor.getTelefono() == null || doctor.getTelefono().trim().isEmpty()) {
            return "El teléfono del doctor es obligatorio";
        } else if (doctor.getFechaNacimiento() == null) {
            return "La fecha de nacimiento es obligatoria";
        } else if (!doctor.getDni().matches("\\d{8}")) {
            return "El DNI debe tener exactamente 8 dígitos numéricos";
        } else if (!doctor.getTelefono().matches("\\d+")) {
            return "El teléfono solo debe contener números";
        }

        return null;
    }
}