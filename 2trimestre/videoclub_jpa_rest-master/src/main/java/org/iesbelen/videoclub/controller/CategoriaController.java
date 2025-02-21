package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")

public class CategoriaController {

        private final CategoriaService categoriaService;

        public CategoriaController(CategoriaService categoriaService) {
            this.categoriaService = categoriaService;
        }

        @GetMapping(value = {"","/"}, params = {"!buscar", "!ordenar"})
        public List<Categoria> all() {
            log.info("Accediendo a todas las categorias");
            return this.categoriaService.all();
        }

        @GetMapping(value = {"","/"})
        public List<Categoria> all( @RequestParam("buscar") Optional<String> buscarOptional,
                                    @RequestParam("ordenar") Optional<String> ordenarOptional) {

            log.info("Accediendo a todas las peliculas con filtro buscar: %s y ordenar",
                    buscarOptional.orElse("VOID"),
                    ordenarOptional.orElse("VOID"));
            return this.categoriaService.allByQueryFiltersStream(buscarOptional, ordenarOptional);
        }

        //ver el numero de peliculas que tenemos de una categoria
        @GetMapping("/{id}/numeroPeliculas")
        public int getNumeroPeliculas(@PathVariable ("id") long id){
            return this.categoriaService.one(id).getPeliculas().size();
        }

        @PostMapping({"","/"})
        public Categoria newPelicula(@RequestBody Categoria categoria) {
            return this.categoriaService.save(categoria);
        }

        @GetMapping("/{id}")
        public Categoria one(@PathVariable("id") Long id) {
            return this.categoriaService.one(id);
        }

        @PutMapping("/{id}")
        public Categoria replacePelicula(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
            return this.categoriaService.replace(id, categoria);
        }

        @ResponseBody
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/{id}")
        public void deletePelicula(@PathVariable("id") Long id) {
            this.categoriaService.delete(id);
        }


    }


