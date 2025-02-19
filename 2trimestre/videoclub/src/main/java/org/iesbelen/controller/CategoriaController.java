package org.iesbelen.controller;

import org.iesbelen.modelo.Categoria;
import org.iesbelen.modelo.Pelicula;
import org.iesbelen.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {this.categoriaService = categoriaService;}

    @GetMapping()
    public String listar(Model model) {
        List<Categoria> listaCategorias =  categoriaService.listAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias/categorias";
    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {
        System.out.println("hola");
        Categoria categoria = categoriaService.one(id);
        model.addAttribute("categoria", categoria);
        return "categorias/detalle-categorias";
    }
}
