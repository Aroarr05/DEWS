package com.example.pruebajdca.controller;

import com.example.pruebajdca.model.Empleado;
import com.example.pruebajdca.service.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping({"","/"})
    public List<Empleado> empleados(){
        return empleadoService.getAll();
    }

    @GetMapping("/crear")
    public Empleado crete(){
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Garcia");
        return  empleadoService.guardarEmpleados(empleado);
    }
}
