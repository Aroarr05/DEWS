package org.iesbelen.dao;

import  org.iesbelen.model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO{
   /* @Override
    public synchronized void create(Empleado empleado) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO empleado (nif, nombre, apellido1, apellido2, codigo_departamento) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, empleado.getNif());
            ps.setString(idx++, empleado.getNombre());
            ps.setString(idx++, empleado.getApellido1());
            ps.setString(idx++, empleado.getApellido2());
            ps.setInt(idx++, empleado.getCodigo_departamento());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de fabricante con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                empleado.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }*/

    @Override
    public List<Empleado> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Empleado> listProd = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM empleado");
            while (rs.next()) {
                Empleado empl = new Empleado();
                int idx = 1;
                empl.setCodigo(rs.getInt(idx++));
                empl.setNif(rs.getString(idx++));
                empl.setNombre(rs.getString(idx++));
                empl.setApellido1(rs.getString(idx++));
                empl.setApellido2(rs.getString(idx++));
                empl.setCodigo_departamento(rs.getInt(idx));
                listProd.add(empl);
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
    public Optional<Empleado> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM empleado WHERE codigo = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Empleado empl = new Empleado();
                idx = 1;
                empl.setCodigo(rs.getInt(idx++));
                empl.setNif(rs.getString(idx++));
                empl.setNombre(rs.getString(idx++));
                empl.setApellido1(rs.getString(idx++));
                empl.setApellido2(rs.getString(idx++));
                empl.setCodigo_departamento(rs.getInt(idx));
                return Optional.of(empl);
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
    public void update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nombre = ?  WHERE codigo = ?");
            int idx = 1;
            ps.setString(idx++, empleado.getNombre());
            ps.setInt(idx, empleado.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de empleado con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

}
