package org.iesbelen.pruebajpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.pruebajpa.model.Empleado;
import org.iesbelen.pruebajpa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value= "/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({"","/"})
    public List<Empleado> empleados(){

        return empleadoService.findAll();
    }

    @GetMapping("/create")
    public Empleado create(Model model){
        Empleado empleado = new Empleado();
        empleado.setNombre("Ricardo");
        empleado.setApellido("Villa Brieva");
        return empleadoService.save(empleado);
    }

}
