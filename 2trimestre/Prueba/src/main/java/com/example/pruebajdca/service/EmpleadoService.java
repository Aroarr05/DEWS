package com.example.pruebajdca.service;

import com.example.pruebajdca.model.Empleado;
import com.example.pruebajdca.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll() {
        return empleadoRepository.findAll();

        //crear un metodo nuevo
        //return empleadoRepository.getEmpleadoApellidoAndNombre();
    }

    public Empleado guardarEmpleados(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
