package org.iesbelen.dao;

import org.iesbelen.model.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl  extends AbstractDAOImpl implements DepartamentoDAO{

        @Override
        public synchronized void create(Departamento departamento) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            ResultSet rsGenKeys = null;

            try {
                conn = connectDB();
                ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

                int idx = 1;
                ps.setString(idx++, departamento.getNombre());
                ps.setDouble(idx++, departamento.getPresupuesto());
                ps.setDouble(idx++, departamento.getGastos());

                int rows = ps.executeUpdate();
                if (rows == 0)
                    System.out.println("INSERT de fabricante con 0 filas insertadas.");

                rsGenKeys = ps.getGeneratedKeys();
                if (rsGenKeys.next())
                    departamento.setCodigo(rsGenKeys.getInt(1));

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                closeDb(conn, ps, rs);
            }
        }

        @Override
        public List<Departamento> getAll() {
            Connection conn = null;
            Statement s = null;
            ResultSet rs = null;
            List<Departamento> listProd = new ArrayList<>();

            try {
                conn = connectDB();

                s = conn.createStatement();

                rs = s.executeQuery("SELECT * FROM departamento");
                while (rs.next()) {
                    Departamento depar = new Departamento();
                    int idx = 1;
                    depar.setCodigo(rs.getInt(idx++));
                    depar.setNombre(rs.getString(idx++));
                    depar.setPresupuesto(rs.getDouble(idx++));
                    depar.setGastos(rs.getDouble(idx++));
                    listProd.add(depar);
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
        public Optional<Departamento> find(int id) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                conn = connectDB();

                ps = conn.prepareStatement("SELECT * FROM departamento WHERE codigo = ?");

                int idx =  1;
                ps.setInt(idx, id);

                rs = ps.executeQuery();

                if (rs.next()) {
                    Departamento depar = new Departamento();
                    idx = 1;
                    depar.setCodigo(rs.getInt(idx++));
                    depar.setNombre(rs.getString(idx++));
                    depar.setPresupuesto(rs.getDouble(idx++));
                    depar.setGastos(rs.getDouble(idx++));
                    return Optional.of(depar);
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
    }


