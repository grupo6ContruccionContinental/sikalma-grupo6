package com.example.demo.Doctor;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static List<Doctor> listaDoctores = new ArrayList<>();
    private static int contadorId = 1;

    // --- MÉTODO PRIVADO PARA VALIDACIONES COMUNES (REQ-D01 al D06) ---
    private void validarCampos(Doctor doctor) {
        if (doctor.getNombre() == null || doctor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del doctor es obligatorio");
        }
        if (doctor.getEspecialidad() == null || doctor.getEspecialidad().trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        if (doctor.getTelefono() == null || doctor.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del doctor es obligatorio");
        }
        if (doctor.getFechaNacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        if (doctor.getDni() == null || !doctor.getDni().matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos numéricos");
        }
        if (!doctor.getTelefono().matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono solo debe contener números");
        }
    }

    @Override
    public List<Doctor> obtenerTodos() {
        return listaDoctores;
    }

    @Override
    public void agregar(Doctor doctor) {
        validarCampos(doctor); // Validaciones básicas

        // REQ-D07: Validar DNI duplicado
        if (listaDoctores.stream().anyMatch(d -> d.getDni().equals(doctor.getDni()))) {
            throw new IllegalArgumentException("Ya existe un doctor registrado con ese DNI");
        }

        // REQ-D08: Validar correo duplicado
        if (listaDoctores.stream().anyMatch(d -> d.getCorreo() != null && d.getCorreo().equalsIgnoreCase(doctor.getCorreo()))) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con ese correo");
        }

        doctor.setId(contadorId++);
        listaDoctores.add(doctor);
    }

    @Override
    public Doctor buscarPorId(int id) {
        return listaDoctores.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(Doctor doctor) {
        validarCampos(doctor); // Validaciones básicas

        // Validar DNI duplicado al editar (asegurándonos de que no choque con otro doctor)
        if (listaDoctores.stream().anyMatch(d -> d.getDni().equals(doctor.getDni()) && d.getId() != doctor.getId())) {
            throw new IllegalArgumentException("Ya existe otro doctor registrado con ese DNI");
        }

        for (int i = 0; i < listaDoctores.size(); i++) {
            if (listaDoctores.get(i).getId() == doctor.getId()) {
                listaDoctores.set(i, doctor);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        // REQ-D09: Por ahora lo dejamos listo para cuando integremos las citas
        listaDoctores.removeIf(d -> d.getId() == id);
    }

    @Override
    public List<Doctor> buscarPorDni(String dni) {
        return listaDoctores.stream()
                .filter(d -> d.getDni().equals(dni))
                .collect(Collectors.toList());
    }
}