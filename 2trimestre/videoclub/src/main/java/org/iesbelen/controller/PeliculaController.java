package org.iesbelen.controller;

import jakarta.validation.Valid;
import org.iesbelen.modelo.Pelicula;
import org.iesbelen.service.CategoriaService;
import org.iesbelen.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private org.iesbelen.service.PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {this.peliculaService = peliculaService;}

    @GetMapping()
    public String listar(Model model) {
        System.out.println("Listando peliculas");
        List<Pelicula> listaPeliculas =  peliculaService.listAll();

       //me falta el idioma que se muestre por el nombre
        model.addAttribute("listaPeliculas", listaPeliculas);
        return "peliculas/peliculas";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "peliculas/crear-peliculas";
    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("pelicula", pelicula);
            return "peliculas/crear-peliculas";
        }
        peliculaService.newPelicula(pelicula);
        return "redirect:/peliculas";
    }

}
