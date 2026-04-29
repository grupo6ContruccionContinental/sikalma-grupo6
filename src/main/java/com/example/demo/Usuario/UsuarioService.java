package com.example.demo.Usuario;

import java.util.List;

public interface UsuarioService {

    void agregar(Usuario usuario);

    List<Usuario> listar();

    Usuario buscarPorId(int id);

    Usuario login(String user,String pass);

    void actualizar(Usuario usuario);

    void eliminar(int id);

}