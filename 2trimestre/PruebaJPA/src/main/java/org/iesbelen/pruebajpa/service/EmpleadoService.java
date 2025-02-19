package org.iesbelen.pruebajpa.service;

import org.iesbelen.pruebajpa.model.Empleado;
import org.iesbelen.pruebajpa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public Empleado findEmpleadoById(Long id){
        Empleado empleado = empleadoRepository.getEmpleadosById(id);
        return empleado;
    }

    public List<Empleado> findAll(){

        return empleadoRepository.findAll();
    }

    public Empleado save(Empleado empleado){

        return empleadoRepository.saveAndFlush(empleado);
 //       return empleadoRepository.save(empleado);
    }
}
