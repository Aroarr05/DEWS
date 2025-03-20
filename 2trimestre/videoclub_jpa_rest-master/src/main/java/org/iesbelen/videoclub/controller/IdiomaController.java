package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;

import org.iesbelen.videoclub.domain.Idioma;
import org.iesbelen.videoclub.service.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/idiomas")

public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping({"","/"})
    public List<Idioma> all() {
        log.info("Accediendo a todas los idiomas");
        return this.idiomaService.all();
    }

    @PostMapping({"","/"})
    public Idioma newPelicula(@RequestBody Idioma idioma) {
        return this.idiomaService.save(idioma);
    }

    @GetMapping("/{id}")
    public Idioma one(@PathVariable("id") Long id) {
        return this.idiomaService.one(id);
    }

    @PutMapping("/{id}")
    public Idioma replacePelicula(@PathVariable("id") Long id, @RequestBody Idioma idioma) {
        return this.idiomaService.replace(id, idioma);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.idiomaService.delete(id);
    }

}
