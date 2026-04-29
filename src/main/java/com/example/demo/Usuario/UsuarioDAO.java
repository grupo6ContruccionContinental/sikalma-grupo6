package com.example.demo.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void save(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(int id);

    Usuario login(String username,String password);

    void update(Usuario usuario);

    void delete(int id);

}