package org.iesbelen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesbelen.model.Categoria;
import org.iesbelen.model.Producto;

public class CategoriaDAOImpl extends AbstractDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Categoria> listaCategorias = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM categoria");
            while (rs.next()) {
                Categoria categoria = new Categoria();
                int idx = 1;
                categoria.setIdcat(rs.getInt(idx++));
                categoria.setNombre(rs.getString(idx));
                listaCategorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listaCategorias;

    }

    @Override
    public Optional<Categoria> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM categoria WHERE idcat = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Categoria fab = new Categoria();
                idx = 1;
                fab.setIdcat(rs.getInt(idx++));
                fab.setNombre(rs.getString(idx));

                return Optional.of(fab);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();

    }

    @Override
    public void update(Categoria categoria) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE categoria SET nombre = ?  WHERE idcat= ?");
            int idx = 1;
            ps.setString(idx++, categoria.getNombre());
            ps.setInt(idx, categoria.getIdcat());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de categoria con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }


}
