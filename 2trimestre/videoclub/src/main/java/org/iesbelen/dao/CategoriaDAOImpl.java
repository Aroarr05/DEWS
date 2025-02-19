package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Categoria> getAll() {

        List<Categoria> listFab = jdbcTemplate.query(
                "SELECT * FROM categoria",
                (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                        rs.getString("nombre")

                )
        );

        log.info("Devueltos {} registros.", listFab.size());
        return listFab;
    }
    @Override
    public Optional<Categoria> find(int id) {

        Categoria fab =  jdbcTemplate
                .queryForObject("SELECT * FROM categoria WHERE id_categoria = ?"
                        , (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                                rs.getString("nombre"))
                        , id
                );

        if (fab != null) {
            return Optional.of(fab);}
        else {
            log.info("Categoria no encontrado.");
            return Optional.empty(); }
    }
}
