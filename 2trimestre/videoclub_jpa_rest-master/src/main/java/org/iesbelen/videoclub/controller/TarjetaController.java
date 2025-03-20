package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Tarjeta;
import org.iesbelen.videoclub.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping({"","/"})
    public List<Tarjeta> all() {
        log.info("Accediendo a todas los idiomas");
        return this.tarjetaService.all();
    }

    @PostMapping({"","/"})
    public Tarjeta newSocio(@RequestBody Tarjeta tarjeta) {
        return this.tarjetaService.save(tarjeta);
    }

    @GetMapping("/{id}")
    public Tarjeta one(@PathVariable("id") Long id) {
        return this.tarjetaService.one(id);
    }

    @PutMapping("/{id}")
    public Tarjeta replaceSocio(@PathVariable("id") Long id, @RequestBody Tarjeta tarjeta) {
        return this.tarjetaService.replace(id, tarjeta);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable("id") Long id) {
        this.tarjetaService.delete(id);
    }

}
