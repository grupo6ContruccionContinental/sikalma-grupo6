package com.example.demo.Usuario;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioDAO{

    List<Usuario> lista = new ArrayList<>();
    int contador=1;

    public UsuarioRepository(){
        save(new Usuario("admin","123","Administrador"));
    }

    @Override
    public void save(Usuario u){
        u.setId(contador++);
        lista.add(u);
    }

    @Override
    public List<Usuario> findAll(){
        return lista;
    }

    @Override
    public Usuario findById(int id){
        return lista.stream()
            .filter(u->u.getId()==id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Usuario login(String user,String pass){
        return lista.stream()
          .filter(u->u.getUsername().equals(user)
                 && u.getPassword().equals(pass))
          .findFirst()
          .orElse(null);
    }

    @Override
    public void update(Usuario usuario){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==usuario.getId()){
                lista.set(i,usuario);
                return;
            }
        }
    }

    @Override
    public void delete(int id){
        lista.removeIf(u->u.getId()==id);
    }

}