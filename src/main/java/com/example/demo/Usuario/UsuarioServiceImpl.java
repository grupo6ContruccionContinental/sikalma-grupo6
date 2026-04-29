package com.example.demo.Usuario;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO){
        this.usuarioDAO=usuarioDAO;
    }

    public void agregar(Usuario u){
        usuarioDAO.save(u);
    }

    public List<Usuario> listar(){
        return usuarioDAO.findAll();
    }

    public Usuario buscarPorId(int id){
        return usuarioDAO.findById(id);
    }

    public Usuario login(String user,String pass){
        return usuarioDAO.login(user,pass);
    }

    public void actualizar(Usuario u){
        usuarioDAO.update(u);
    }

    public void eliminar(int id){
        usuarioDAO.delete(id);
    }

}