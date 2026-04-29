package com.example.demo.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping("/gestion")
    public String gestion(Model model){
        model.addAttribute("usuarios",
                usuarioService.listar());

        model.addAttribute("paginaActiva","usuario");

        return "Gestion-usuarios";
    }

    @PostMapping("/registrar")
    public String registrar(
          @ModelAttribute Usuario usuario){
        usuarioService.agregar(usuario);
        return "redirect:/usuario/gestion";
    }

    @PostMapping("/login")
    public String login(
       @RequestParam String username,
       @RequestParam String password){

        Usuario usuario=
         usuarioService.login(username,password);

        if(usuario!=null){
            return "redirect:/inicio";
        }

        return "redirect:/login?error";
    }

    @GetMapping("/eliminar")
    public String eliminar(int id){
        usuarioService.eliminar(id);
        return "redirect:/usuario/gestion";
    }

}