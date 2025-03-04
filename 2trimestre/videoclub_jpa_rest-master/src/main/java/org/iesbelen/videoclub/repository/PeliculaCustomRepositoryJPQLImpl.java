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
        queryBuilder.append(" ORDER BY ");

        for (int i = 0; i < ordenes.length; i++) {
            String[] parts = ordenes[i].split(",");
            String column = parts[0];
            String direction = parts[1];
            queryBuilder.append("p."+column+ " ").append(direction);
            if (i < ordenes.length -1){
                queryBuilder.append(", ");
            }
        }
    }
    return em.createQuery(queryBuilder.toString(), Pelicula.class).getResultList();
 }

}
