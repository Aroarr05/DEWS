package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Idioma;
import org.iesbelen.videoclub.domain.Socio;
import org.iesbelen.videoclub.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping({"","/"})
    public List<Socio> all() {
        log.info("Accediendo a todas los idiomas");
        return this.socioService.all();
    }

    @PostMapping({"","/"})
    public Socio newSocio(@RequestBody Socio socio) {
        return this.socioService.save(socio);
    }

    @GetMapping("/{id}")
    public Socio one(@PathVariable("id") Long id) {
        return this.socioService.one(id);
    }

    @PutMapping("/{id}")
    public Socio replaceSocio(@PathVariable("id") Long id, @RequestBody Socio socio) {
        return this.socioService.replace(id, socio);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable("id") Long id) {
        this.socioService.delete(id);
    }


}
