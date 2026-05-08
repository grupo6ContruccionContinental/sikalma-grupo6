package com.example.demo.Servicio;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioDAO servicioDAO;

    public ServicioServiceImpl(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    @Override
    public void agregar(Servicio s) {
        servicioDAO.save(s);
    }

    @Override
    public List<Servicio> listar() {
        return servicioDAO.findAll();
    }

    @Override
    public Servicio buscarPorId(int id) {
        return servicioDAO.findById(id);
    }

    @Override
    public void actualizar(Servicio s) {
        servicioDAO.update(s);
    }

    @Override
    public void eliminar(int id) {
        servicioDAO.delete(id);
    }

    @Override
    public List<Servicio> buscarPorNombre(String nombre) {
        return servicioDAO.findByNombre(nombre);
    }

    // validaciones

    @Override
    public String validarDatosRegistro(Servicio servicio){

        String error = validacionesGenerales(servicio);

        if(error != null ){

            return error;

        }else if(!servicioDAO.findByNombre(servicio.getNombre()).isEmpty()){

            return "Ya existe un servicio con ese nombre";

        }
        
        return null;
        
    }

    @Override
    public String validarDatosEdicion(Servicio servicio){

        String error = validacionesGenerales(servicio);

        if(error != null ){

            return error;

        }
        
        return null;
    }
 
    public String validacionesGenerales(Servicio servicio) {

        if(servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()){
            
            return "El nombre del servicio es obligatorio";

        }else if(servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()){

            return "La descripcion del servicio es obligatorio";

        }else if(servicio.getCosto() <= 0){

            return "El costo debe ser mayor a S/ 0.00";

        }

        return null;

    }

}
