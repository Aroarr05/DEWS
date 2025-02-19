package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.EmpleadoDAO;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.model.Empleado;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "empleadosServlet", value = "/empleados/empleado/*")
public class EmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            EmpleadoDAO fabDAO = new EmpleadoDAOImpl();

            //GET
            //	/productos/
            //	/productos

            request.setAttribute("listaEmpleados", fabDAO.getAll());
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");

            String nombre = request.getParameter("filtrar-por-nombre");

            if (nombre != null && !nombre.isEmpty()) {
                //request.setAttribute("listaEmpleados", fabDAO.filtro(nombre));
                System.out.println(nombre);
            }else {
                request.setAttribute("listaEmpleados", fabDAO.getAll());
            }

        } else {
            // GET
            // 		/empleados/{id}
            // 		/empleados/{id}/
            // 		/empleados/edit/{id}
            // 		/empleados/edit/{id}/
            // 		/empleados/crear
            // 		/empleados/crear/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

               // FabricanteDAO fabDAO = new FabricanteDAOImpl();
                //List<Fabricante> listaFabricantes = fabDAO.getAll();
                //List<FabricanteDTO> fabricanteDTOS = listaFabricantes.stream()
                      //  .map(fabricante -> new FabricanteDTO(fabricante, empleDAO.getCountEmpleados(fabricante.getIdFabricante()).orElse(0)))
                        //.toList();

                //request.setAttribute("listaFabricantes", fabricanteDTOS);
                // GET
                // /empleados/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/crear-empleado.jsp");


            } else if (pathParts.length == 2) {
                EmpleadoDAO empleDAO = new EmpleadoDAOImpl();
                // GET
                // /empleados/{id}
                try {

                    request.setAttribute("empleado",empleDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/detalle-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                EmpleadoDAO empleDAO = new EmpleadoDAOImpl();
                // GET
                // /empleados/editar/{id}
                try {
                    request.setAttribute("empleado",empleDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp//empleado/editar-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");
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
            /* Crear uno nuevo
            EmpleadoDAO emplDAO = new EmpleadoDAOImpl();

            String nif = request.getParameter("nif");
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            int codigo_departamento = Integer.parseInt(request.getParameter("codigo_departamento"));
            Empleado nuevoEmpl = new Empleado();

            nuevoEmpl.setNombre(nombre);
            nuevoEmpl.setNif(nif);
            nuevoEmpl.setNombre(nombre);
            nuevoEmpl.setApellido1(apellido1);
            nuevoEmpl.setApellido2(apellido2);
            nuevoEmpl.setCodigo_departamento(codigo_departamento);
            emplDAO.create(nuevoEmpl);*/

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

        //response.sendRedirect("../../../empleados/empleado");
        response.sendRedirect(request.getContextPath() + "/empleados/empleado");
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadoDAO emplDAO = new EmpleadoDAOImpl();
        String codigo = request.getParameter("codigo");
        String nif = request.getParameter("nif");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String codigo_departamento = request.getParameter("codigo_departamento");
        Empleado emp = new Empleado ();

        try {

            int id = Integer.parseInt(codigo);
            emp.setCodigo (id);
            emp.setNif (nif);
            emp.setNombre(nombre);
            emp.setApellido1(apellido1);
            emp.setApellido2(apellido2);
            emp.setCodigo_departamento(Integer.parseInt(codigo_departamento));
            emplDAO.update(emp);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
