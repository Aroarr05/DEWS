package aroa.proyecto.tienda.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import aroa.proyecto.tienda.dao.UsuarioDAO;
import aroa.proyecto.tienda.dao.UsuarioDAOImpl;
import aroa.proyecto.tienda.model.Usuario;
import aroa.proyecto.tienda.utilities.util;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;


    @WebServlet(name = "usuariosServlet", value = "/tienda/usuarios/*")
    public class UsuarioServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * HTTP Method: GET
         * Paths:
         * 		/usuarios/
         * 		/usuarios/{id}
         * 		/usuarios/editar{id}
         * 		/usuarios/crear
         */

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher;

            String pathInfo = request.getPathInfo(); //
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            List<Usuario> listaUsuarios = usuarioDAO.getAll();
            if (pathInfo == null || "/".equals(pathInfo)) {


                //GET
                //	/fabricantes/
                //	/fabricantes

                request.setAttribute("listaUsuario", usuarioDAO.getAll());
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

            } else {
                // GET
                // 		/usuarios/{id}
                // 		/usuarios/{id}/
                // 		/usuarios/edit/{id}
                // 		/usuarios/edit/{id}/
                // 		/usuarios/crear
                // 		/usuarios/crear/
                //      /usuarios/login
                //      /usuarios/login/

                pathInfo = pathInfo.replaceAll("/$", "");
                String[] pathParts = pathInfo.split("/");


                if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                    // GET
                    // /usuarios/crear
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/crear-usuario.jsp");

                } else if (pathParts.length == 2 && "login".equals(pathParts[1])) {
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/login.jsp");
                } else if (pathParts.length == 2) {

                    // GET
                    // /usuarios/{id}
                    try {
                        request.setAttribute("usuario",usuarioDAO.find(Integer.parseInt(pathParts[1])));
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/detalle-usuarios.jsp");

                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                    }
                } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {


                    // GET
                    // /fabricantes/editar/{id}
                    try {
                        request.setAttribute("usuario",usuarioDAO.find(Integer.parseInt(pathParts[2])));
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/editar-usuario.jsp");

                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                    }
                } else {
                    System.out.println("Opción POST no soportada.");
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

                }
            }

            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String pathInfo = request.getPathInfo();
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            RequestDispatcher dispatcher;
            String __method__ = request.getParameter("__method__");

            if (__method__ == null) {
                // Crear uno nuevo
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombre(usuario);
                try {
                    String hash = util.hashPassword(contrasena);
                    nuevoUsuario.setPassword(hash);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                String rol = request.getParameter("rol");
                nuevoUsuario.setRol(rol);
                usuarioDAO.create(nuevoUsuario);

            } else if (__method__ != null && "login".equalsIgnoreCase(__method__)) {
                doLogin(request, response);

            }else if (__method__ != null && "logout".equalsIgnoreCase(__method__)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario-logado", null);
                dispatcher = request.getRequestDispatcher("/");
                dispatcher.forward(request, response);

            } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
                // Actualizar uno existente
                //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
                doPut(request, response);

            } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
                // Borrar uno existente
                //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
                doDelete(request, response);
            } else {
                System.out.println("Opción POST no soportada.");
            }

            //response.sendRedirect("../../../tienda/usuarios");
            response.sendRedirect(request.getContextPath() + "/tienda/usuarios/");
        }


        @Override
        protected void doPut(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            String nombre = request.getParameter("nombre");
            String contrasena = request.getParameter("contrasena");
            String rol = request.getParameter("rol");
            Usuario usuario = new Usuario();

            try {
                usuario.setNombre(nombre);
                usuario.setPassword(contrasena);
                usuario.setRol(rol);
                usuarioDAO.update(usuario);

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

        }

        @Override
        protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        {
            RequestDispatcher dispatcher;
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            String codigo = request.getParameter("codigo");

            try {
                int id = Integer.parseInt(codigo);

                usuarioDAO.delete(id);

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        protected void doLogin(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher;
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

            // Validar si la contraseña es nula o vacía
            if (contrasena == null || contrasena.isEmpty()) {
                request.setAttribute("errorMessage", "La contraseña no puede estar vacía.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/login.jsp");
                dispatcher.forward(request, response);
                return; // Termina la ejecución del método
            }

            String contrasena2 = null;
            try {
                contrasena2 = util.hashPassword(contrasena); // Generar el hash de la contraseña
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Error al generar el hash de la contraseña.", e);
            }

            Optional<Usuario> us = usuarioDAO.login(usuario);

            if (us.isPresent() && contrasena2.equals(us.get().getPassword())) {
                // Si el usuario está presente y las contraseñas coinciden
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario-logado", us.get());
                dispatcher = request.getRequestDispatcher("/");
                dispatcher.forward(request, response);
            } else {
                // Si el login falla, puedes redirigir a la página de login nuevamente con un mensaje de error
                request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/login.jsp");
                dispatcher.forward(request, response);
            }
        }

    }


