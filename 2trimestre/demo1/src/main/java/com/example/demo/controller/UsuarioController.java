package com.example.demo.controller;

import com.example.demo.domain.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value ={" ","/"})
    public List<Usuario>all(){
        log.info ("Obteniendo todos los usuarios");
        return usuarioService.all();
    }

    @PostMapping({"", "/"})
    public Usuario newUsuario(@RequestBody("id")Long id){
        return this.usuarioService.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario one (@PathVariable("id")Long id){
        return this.usuarioService.one(id);
    }

    @PutMapping("/{id}")
    public Usuario replaceUsuario(@PathVariable("id")long id, @RequestBody Usuario usuario){
        return  this.usuarioService.replace(id,usuario);
    }

    @ResponseBody
    @ResponseStatus
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")long id){
        this.usuarioService.delete(id);
    }
}
