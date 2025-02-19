package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.model.Categoria;

import java.io.IOException;

@WebServlet(name = "categoriaServlet", value = "/ventas_plus/categoria/*")

public class CategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            CategoriaDAO fabDAO = new CategoriaDAOImpl();

            request.setAttribute("listaCategorias", fabDAO.getAll());
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categoria.jsp");

            String nombre = request.getParameter("filtrar-por-nombre");

            if (nombre != null && !nombre.isEmpty()) {

                System.out.println(nombre);
            }else {
                request.setAttribute("listaCategorias", fabDAO.getAll());
            }

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/crear-categoria.jsp");


            } else if (pathParts.length == 2) {
                CategoriaDAO empleDAO = new CategoriaDAOImpl();
                // GET
                // /categorias/{id}
                try {

                    request.setAttribute("categoria",empleDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/detalle-categoria.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categoria.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                CategoriaDAO empleDAO = new CategoriaDAOImpl();
                // GET
                // /categorias/editar/{id}
                try {
                    request.setAttribute("categoria",empleDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/editar-categoria.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categoria.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categoria.jsp");
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

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {

            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }


        response.sendRedirect(request.getContextPath() + "/ventas_plus/categoria");
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDAO emplDAO = new CategoriaDAOImpl();
        String idcat = request.getParameter("idcat");
        String nombre = request.getParameter("nombre");

        Categoria cate = new Categoria ();

        try {
            int id = Integer.parseInt(idcat);
            cate.setIdcat (id);
            cate.setNombre(nombre);
            emplDAO.update(cate);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

}
