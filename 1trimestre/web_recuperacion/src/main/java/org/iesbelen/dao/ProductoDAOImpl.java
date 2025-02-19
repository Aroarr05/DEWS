package org.iesbelen.dao;

import org.iesbelen.model.Categoria;
import org.iesbelen.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl extends AbstractDAOImpl implements ProductoDAO {
    @Override
    public void create(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO producto (idcat, nombre, precio, stock) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setInt(idx, producto.getIdcat());
            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setInt(idx, producto.getStock());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de Producto con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                producto.setIdprod(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Producto> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        List<Producto> listProd = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                Producto prod = new Producto();
                int idx = 1;
                prod.setIdprod(rs.getInt("idprod"));  // Leer idprod correctamente
                prod.setIdcat(rs.getInt("idcat"));    // Leer idcat correctamente
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                listProd.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listProd;

    }

    @Override
    public Optional<Producto> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM producto WHERE idprod = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Producto prod = new Producto();
                idx = 1;
                prod.setIdprod(rs.getInt(idx++));
                prod.setIdcat(rs.getInt(idx++));
                prod.setNombre(rs.getString(idx++));
                prod.setPrecio(rs.getDouble(idx++));
                prod.setStock(rs.getInt(idx));
                return Optional.of(prod);
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
    public synchronized void create(Categoria categoria) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO categoria (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, categoria.getNombre());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de Categoria con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                categoria.setIdcat(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
