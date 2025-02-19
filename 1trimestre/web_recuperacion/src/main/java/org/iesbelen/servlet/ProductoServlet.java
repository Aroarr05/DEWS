package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Producto;

import java.io.IOException;

@WebServlet(name = "productoServlet", value = "/ventas_plus/producto/*")

public class ProductoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            ProductoDAO prodDAO = new ProductoDAOImpl();

            request.setAttribute("listaProductos", prodDAO.getAll());
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/producto.jsp");

            String nombre = request.getParameter("filtrar-por-nombre");

            if (nombre != null && !nombre.isEmpty()) {
                System.out.println(nombre);
            }else {
                request.setAttribute("listaProductos", prodDAO.getAll());
            }

        } else {

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/crear-producto.jsp");

            } else if (pathParts.length == 2) {
                ProductoDAO empleDAO = new ProductoDAOImpl();
                try {
                    request.setAttribute("producto",empleDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/detalle-Producto.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/producto.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                ProductoDAO empleDAO = new ProductoDAOImpl();

                try {
                    request.setAttribute("producto",empleDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/editar-producto.jsp");
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/producto.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/producto/producto.jsp");
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
            ProductoDAO depaDAO = new ProductoDAOImpl();

            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));


            Producto nuevoProd = new Producto();

            nuevoProd.setNombre(nombre);
            nuevoProd.setPrecio(precio);
            nuevoProd.setStock(stock);
            depaDAO.create(nuevoProd);

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

        response.sendRedirect(request.getContextPath() + "/ventas_plus/producto");
    }
}


