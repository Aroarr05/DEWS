package org.iesbelen.pruebajpa.repository;

import org.iesbelen.pruebajpa.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository
        extends JpaRepository <Empleado, Long> {

    Empleado getEmpleadosById(Long id);
    
}
