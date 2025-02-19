<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.Optional"%>
<%@ page import="org.iesbelen.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Usuarios</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }
        <%@ include file="/WEB-INF/jsp/fragmentos/estilo.jspf" %>
    </style>
</head>
<body>
<%@ include file ="/WEB-INF/jsp/fragmentos/header.jspf"%>
<%@ include file ="/WEB-INF/jsp/fragmentos/nav.jspf"%>
<main class = "body_sec">
    <section id="Content">
        <div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
            <div class="clearfix">
                <div style="float: left; width: 50%">
                    <h1>Detalle Usuarios</h1>
                </div>
                <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                    <div style="position: absolute; left: 39%; top : 39%;">

                        <form action="${pageContext.request.contextPath}/tienda/usuarios/" >
                            <input type="submit" value="Volver" />
                        </form>
                    </div>

                </div>
            </div>
            <div class="clearfix">
                <hr/>
            </div>

            <% 	Optional<Usuario> usuario = (Optional<Usuario>) request.getAttribute("usuario");
                if (usuario.isPresent()) {
            %>

            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    <label>Código</label>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input value="<%= usuario.get().getIdUsuario() %>" readonly="readonly"/>
                </div>
            </div>
            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    <label>Usuario</label>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input value="<%= usuario.get().getUsuario() %>" readonly="readonly"/>
                </div>
                <div style="float: left;width: 50%">
                    <label>Contraseña</label>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input value="<%= usuario.get().getPassword().substring(0,4) %>" readonly="readonly"/>
                </div>
                <div style="float: left;width: 50%">
                    <label>Rol</label>
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input value="<%= usuario.get().getRol() %>" readonly="readonly"/>
                </div>
            </div>

            <% 	} else { %>

            request.sendRedirect("usuarios/");

            <% 	} %>

        </div>


    </section>
</main>
</body>
<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
</html>