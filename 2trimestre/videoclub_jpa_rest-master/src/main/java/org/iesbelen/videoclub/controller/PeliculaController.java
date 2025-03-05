package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;
    private final CategoriaService categoriaService;

    public PeliculaController(PeliculaService peliculaService, CategoriaService categoriaService) {
        this.peliculaService = peliculaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio", "!orden", "!paginado"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }

    @GetMapping(value = {"","/"}, params = {"!orden", "!paginado"})
    public ResponseEntity<Map<String, Object>> all (@RequestParam(value = "pagina", defaultValue = "0")int pagina,
    @RequestParam(value = "tamanio", defaultValue = "3") int tamanio){
        log.info("Accediendo a todas las peliculas con paginación");
        Map<String, Object> responseAll= this.peliculaService.all(pagina,tamanio);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio", "!paginado"})
   public ResponseEntity<List<Pelicula>> obtenerPeliculasCuston(@RequestParam(value = "orden", required = false)String[] orden){
        log.info("Accediendo a todas las peliculas con ordenación: " + orden[0]);

    List<Pelicula> peliculas = this.peliculaService.obtenerPeliculasCuston(orden);
    return ResponseEntity.ok(peliculas);
   }

   @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio", "!orden"})
   public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "paginado", defaultValue = "0")String[] paginacion){
        log.info("Accediendo a todas las peliculas con paginado");
        Map<String,Object> responseAll = this.peliculaService.all(paginacion);
        return ResponseEntity.ok(responseAll);
   }

    @PostMapping({"","/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {
        return this.peliculaService.one(id);
    }

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }

    //añadir una categoria a una pelicula
    @PostMapping("/{id}/add/{id_categoria}")
    public void addCategoria(@PathVariable("id") Long idPelicula, @PathVariable("id_categoria") Long id_categoria) {

        Pelicula pelicula  = this.peliculaService.one(idPelicula);
        Categoria categoria = this.categoriaService.one(id_categoria);
        pelicula.getCategorias().add(categoria);
        this.peliculaService.replace(idPelicula, pelicula);

    }

//    public void addCategoria(@PathVariable("id") Long idPelicula,
//                              @PathVariable("id_categoria") Long id_categoria) {
//
//       return this.peliculaService.addCategoriaToPelicula(idPelicula , idCategoria);
//
//    }

}
