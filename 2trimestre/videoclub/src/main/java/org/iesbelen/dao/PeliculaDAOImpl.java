package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public synchronized void create(Pelicula pelicula) {

        String sqlInsert = """
							INSERT INTO pelicula (titulo, descripcion, anyo_lanzamiento, id_idioma, duracion) 
							VALUES  (     ?,         ?,         ?,       ?,         ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id_pelicula" });
            int idx = 1;
            ps.setString(idx++, pelicula.getTitulo());
            ps.setString(idx++, pelicula.getDescripcion());
            ps.setInt(idx++, pelicula.getAnyo_lanzamiento());
            ps.setInt(idx++, pelicula.getId_idioma());
            ps.setInt(idx, pelicula.getDuracion());
            return ps;
        },keyHolder);

        pelicula.setId_pelicula(keyHolder.getKey().intValue());


        log.info("Insertados {} registros.", rows);
    }
    @Override
    public List<Pelicula> getAll() {

        List<Pelicula> listPel = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("anyo_lanzamiento"),
                        rs.getInt("id_idioma"),
                        rs.getInt("duracion")
                )
        );

        log.info("Devueltos {} registros.", listPel.size());
        return listPel;
    }
}
