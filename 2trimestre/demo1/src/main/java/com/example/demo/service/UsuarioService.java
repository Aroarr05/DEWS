package com.example.demo.service;

import com.example.demo.controller.UsuarioNotFoundAdvice;
import com.example.demo.domain.Usuario;
import com.example.demo.exception.UsuarioNotFoundException;
import com.example.demo.repository.UsuarioRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepsitory usuarioRepsitory;

    public List<Usuario>all(){
        return this.usuarioRepsitory.findAll();
    }

    public Usuario save (Usuario usuario){
        return this.usuarioRepsitory.save(usuario);
    }

    public Usuario one(Long id){
        return this.usuarioRepsitory.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundAdvice(id));
    }

    public Usuario replace(Long id, Usuario usuario){
        return this.usuarioRepsitory.findById(id).map(p->(id.equals(usuario.getId())?
                this.usuarioRepsitory.save(usuario): null))
                .orElseThrow(()->new UsuarioNotFoundException(id));
    }

    public Usuario delete(Long id){
        this.usuarioRepsitory.deleteById(id).map(p ->{this.usuarioRepsitory.delete(p);
        return p;})
                .orElseThrow(()-> new )
    }
}
