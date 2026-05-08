package com.example.demo.Atencion;

import java.util.List;

public interface AtencionDAO {
    void save(Atencion a);
    List<Atencion> findAll();
    Atencion findById(int id);
    void update(Atencion a);
    void delete(int id);
}
