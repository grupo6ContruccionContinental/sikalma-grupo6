package com.example.demo.Servicio;

import java.util.List;

public class ServicioServiceImpl implements ServicioService {

    private ServicioDAO dao;

    public ServicioServiceImpl() {
        this.dao = new ServicioRepository();
    }

    @Override
    public List<Servicio> listar() {
        return dao.listar();
    }

    @Override
    public void guardar(Servicio servicio) {
        dao.guardar(servicio);
    }

    @Override
    public Servicio buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    @Override
    public void actualizar(Servicio servicio) {
        dao.actualizar(servicio);
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }
}