package org.iesbelen.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor

public class PedidoDAOImpl implements PedidoDAO {

    private JdbcTemplate jdbcTemplate;
    @Override
    public synchronized void create(Pedido pedido) {

        String sqlInsert = """
							INSERT INTO pedido (total, fecha, id_cliente, id_comercial) 
							VALUES  (     ?,         ?,         ?,       ?)
						   """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setDouble(idx++, pedido.getTotal());
            ps.setDate(idx++, Date.valueOf(pedido.getFecha()));
            ps.setInt(idx++, pedido.getId_cliente());
            ps.setInt(idx++, pedido.getId_comercial());
            return ps;
        },keyHolder);

        pedido.setId(keyHolder.getKey().intValue());
        log.info("Insertados {} registros.", rows);
    }

    @Override
    public Optional<Pedido> find(int id) {
        Pedido com = jdbcTemplate.queryForObject("SELECT * FROM pedido WHERE id = ?",
                (rs, rowNum) -> new Pedido(
                        rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")
                ),
                id
        );
        if(com!=null){
            return Optional.of(com);
        }else {
            log.info("Comercio no encontrado.");
            return Optional.empty();
        }
    }

    @Override
    public List<Pedido> getAll() {

        List<Pedido> listPedido = jdbcTemplate.query(
                "SELECT * FROM pedido",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial"))

        );

        log.info("Devueltos {} registros.", listPedido.size());

        return listPedido;
    }


    @Override
    public void update(Pedido pedido) {
        int rows = jdbcTemplate.update("""
										UPDATE pedido SET 
														total = ?, 
														fecha = ?, 
														id_cleinte = ?,
														id_comercial = ?
												WHERE id = ?
										""", pedido.getTotal()
                , pedido.getFecha()
                , pedido.getId_cliente()
                , pedido.getId_comercial()
                , pedido.getId());
        log.info("Update de Comeciales con {} refistros actuañizados", rows);

    }

    @Override
    public void delete(long id) {
        int row = jdbcTemplate.update("DELETE FROM pedido WHERE id = ?", id);
        log.info("Delete de Comeciales con {} refistros eliminados", row);
    }


    @Override
    public List<Pedido> getById_comercial(int idComercial) {
        List<Pedido> listPedidoById_Comercial = jdbcTemplate.query(
                "SELECT * FROM pedido where id_comercial = ?",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")),idComercial
        );
        log.info("Devueltos {} registros", listPedidoById_Comercial.size());
        return listPedidoById_Comercial;
    }
}
