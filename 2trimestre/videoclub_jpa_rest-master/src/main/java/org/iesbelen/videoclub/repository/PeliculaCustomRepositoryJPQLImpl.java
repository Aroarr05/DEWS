package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaCustomRepositoryJPQLImpl implements PeliculaCustomRepsitory {

 @Autowired
 private EntityManager em;

 @Override
 public List<Pelicula> pelisOrdenadabyColSentido(Optional<String[]> orden){
     StringBuilder queryBuilder = new StringBuilder("Select p from Pelicula as p");
    if (orden.isPresent()) {
        String[] ordenes = orden.get();
        if (ordenes.length == 2) {
            queryBuilder.append(" ORDER BY ");
            String column = ordenes[0];
            String direction = ordenes[1];
            queryBuilder.append("p."+column+ " ").append(direction.equalsIgnoreCase("asc") ? "ASC" : "DESC");

        }
    }
    return em.createQuery(queryBuilder.toString(), Pelicula.class).getResultList();
 }

}
