package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.DepartamentoDAO;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.model.Departamento;

import java.io.IOException;

@WebServlet(name = "departamentoServlet", value = "/empleados/departamento/*")
public class DepartamentoServlet extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher;

            String pathInfo = request.getPathInfo(); //

            if (pathInfo == null || "/".equals(pathInfo)) {
                DepartamentoDAO fabDAO = new DepartamentoDAOImpl();

                request.setAttribute("listaDepartamentos", fabDAO.getAll());
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");

                String nombre = request.getParameter("filtrar-por-nombre");

                if (nombre != null && !nombre.isEmpty()) {
                    //request.setAttribute("listaDepartamentos", fabDAO.filtro(nombre));
                    System.out.println(nombre);
                }else {
                    request.setAttribute("listaDepartamentos", fabDAO.getAll());
                }

            } else {
                // GET
                // 		/departamentos/{id}
                // 		/departamentos/{id}/
                // 		/departamentos/edit/{id}
                // 		/departamentos/edit/{id}/
                // 		/departamentos/crear
                // 		/departamentos/crear/

                pathInfo = pathInfo.replaceAll("/$", "");
                String[] pathParts = pathInfo.split("/");

                if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                    // FabricanteDAO fabDAO = new FabricanteDAOImpl();
                    //List<Fabricante> listaFabricantes = fabDAO.getAll();
                    //List<FabricanteDTO> fabricanteDTOS = listaFabricantes.stream()
                    //  .map(fabricante -> new FabricanteDTO(fabricante, fabDAO.getCountDepartamentos(fabricante.getIdFabricante()).orElse(0)))
                    //.toList();

                    //request.setAttribute("listaFabricantes", fabricanteDTOS);
                    // GET
                    // /departamentos/crear
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/crear-departamento.jsp");


                } else if (pathParts.length == 2) {
                    DepartamentoDAO empleDAO = new DepartamentoDAOImpl();
                    // GET
                    // /departamentos/{id}
                    try {

                        request.setAttribute("departamento",empleDAO.find(Integer.parseInt(pathParts[1])));
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/detalle-departamento.jsp");

                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");
                    }

                } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                    DepartamentoDAO empleDAO = new DepartamentoDAOImpl();
                    // GET
                    // /departamentos/editar/{id}
                    try {
                        request.setAttribute("departamento",empleDAO.find(Integer.parseInt(pathParts[2])));
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp//departamento/editar-departamento.jsp");

                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");
                    }
                } else {
                    System.out.println("Opción POST no soportada.");
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");
                }
            }
            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher;
            String __method__ = request.getParameter("__method__");
            System.out.println(__method__);
            if (__method__ == null) {
                // Crear uno nuevo
                DepartamentoDAO depaDAO = new DepartamentoDAOImpl();

                String nombre = request.getParameter("nombre");
                Double presupuesto = Double.valueOf(request.getParameter("presupuesto"));
                Double gastos = Double.valueOf(request.getParameter("gastos"));
                Departamento nuevoDepa = new Departamento();

                nuevoDepa.setNombre(nombre);
                nuevoDepa.setPresupuesto(presupuesto);
                nuevoDepa.setGastos(gastos);
                depaDAO.create(nuevoDepa);

            } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
                // Actualizar uno existente
                //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
                doPut(request, response);

            } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
                // Actualizar uno existente
                //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
                doDelete(request, response);

            } else {
                System.out.println("Opción POST no soportada.");
            }

            //response.sendRedirect("../../../departamentos/departamento");
            response.sendRedirect(request.getContextPath() + "/empleados/departamento");
        }
    }


