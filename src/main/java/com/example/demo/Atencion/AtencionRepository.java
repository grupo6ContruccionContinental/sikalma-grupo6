package com.example.demo.Atencion;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AtencionRepository implements AtencionDAO {

    private List<Atencion> lista = new ArrayList<>();
    private int contador = 1;

    // Datos de prueba para poder probar Ver y Editar desde el inicio
    public AtencionRepository() {
        Atencion a1 = new Atencion(
                1, 1, 1, 1,
                "Adrial Gavidia", "Dra. Fernández", "Medicina General",
                LocalDate.of(2026, 4, 5),
                LocalTime.of(9, 0), LocalTime.of(9, 30),
                "Resfriado común con congestión nasal leve.",
                "Paracetamol 500mg cada 8 horas por 3 días. Reposo y abundante líquido.",
                60.00, "Completada",
                "Paciente recomienda control en 7 días si persisten síntomas."
        );

        Atencion a2 = new Atencion(
                3, 2, 2, 2,
                "Elizabeth Huamán", "Dra. Viviana Sánchez", "Odontología",
                LocalDate.of(2026, 4, 6),
                LocalTime.of(10, 0), LocalTime.of(10, 45),
                "Limpieza dental con remoción de sarro.",
                "Colutorio de clorhexidina 0.12% por 7 días.",
                80.00, "Completada",
                ""
        );

        Atencion a3 = new Atencion(
                4, 3, 3, 3,
                "Elias Chavez", "Dr. Marcos López", "Traumatología",
                LocalDate.of(2026, 4, 7),
                LocalTime.of(11, 30), LocalTime.of(12, 0),
                "Esguince de tobillo derecho grado I.",
                "Reposo, hielo local y vendaje compresivo.",
                90.00, "En curso",
                "Se indica radiografía de control en 5 días."
        );

        a1.setId(contador++);
        a2.setId(contador++);
        a3.setId(contador++);

        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
    }

    @Override
    public void save(Atencion a) {
        a.setId(contador++);
        lista.add(a);
    }

    @Override
    public List<Atencion> findAll() {
        return lista;
    }

    @Override
    public Atencion findById(int id) {
        return lista.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Atencion a) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == a.getId()) {
                // Preservar los datos de la cita origen (readonly) antes de actualizar
                Atencion existente = lista.get(i);
                a.setIdCita(existente.getIdCita());
                a.setIdPaciente(existente.getIdPaciente());
                a.setIdDoctor(existente.getIdDoctor());
                a.setIdServicio(existente.getIdServicio());
                a.setNombrePaciente(existente.getNombrePaciente());
                a.setNombreDoctor(existente.getNombreDoctor());
                a.setNombreServicio(existente.getNombreServicio());
                lista.set(i, a);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        lista.removeIf(a -> a.getId() == id);
    }
}
