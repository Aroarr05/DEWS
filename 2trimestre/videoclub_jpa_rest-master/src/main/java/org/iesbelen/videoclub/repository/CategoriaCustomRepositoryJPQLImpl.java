package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaCustomRepositoryJPQLImpl implements  CategoriaCustomRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List queryCustomCategoria(Optional<String> buscarOptional, Optional<String> ordenarOptional){
        StringBuilder queryBuilder = new StringBuilder("select c from Categoria c ");
        if(buscarOptional.isPresent()){
            queryBuilder.append(" ").append("Where c.nombre like :nombre ");
        }
        if(ordenarOptional.isPresent()){
            if(buscarOptional.isPresent() && "asc".equalsIgnoreCase(buscarOptional.get())){
                queryBuilder.append(" ").append("Order by c.nombre  asc");
            } else if (buscarOptional.isPresent() && "desc".equalsIgnoreCase(buscarOptional.get()) ){
                queryBuilder.append(" ").append("Order by c.nombre  desc");
            }
        }
        Query query = em.createQuery(queryBuilder.toString());
        if(buscarOptional.isPresent()){
            query.setParameter("nombre", "%"+buscarOptional.get()+"%");
        }
        return query.getResultList();
    }


}
