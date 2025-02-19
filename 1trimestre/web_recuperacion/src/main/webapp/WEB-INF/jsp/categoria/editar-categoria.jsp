<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.Optional"%>
<%@ page import="org.iesbelen.model.Categoria" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Categoria</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }
        <%@ include file ="/WEB-INF/jsp/fragmentos/estilo.jspf"%>
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
<main class = "body_sec">
    <section  id="Content">
        <div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
            <form action="${pageContext.request.contextPath}/ventas_plus/categoria/editar/" method="post" >
                <input type="hidden" name="__method__" value="put" />
                <div class="clearfix">
                    <div style="float: left; width: 50%">
                        <h1>Editar Categoria</h1>
                    </div>
                    <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
                        <div style="position: absolute; left: 39%; top : 39%;">
                            <input type="submit" value="Guardar" />
                        </div>
                    </div>
                </div>

                <div class="clearfix">
                    <hr/>
                </div>

                    <% 	Optional<Categoria> categoria = (Optional<Categoria>) request.getAttribute("categoria");
        if (categoria.isPresent()) {
      %>

                <div style="margin-top: 6px;" class="clearfix">
                    <div style="float: left;width: 50%">
                        <label>Código</label>
                    </div>
                    <div style="float: none;width: auto;overflow: hidden;">
                        <input  name="idcat" value="<%= categoria.get().getIdcat() %>" />
                    </div>
                </div>
                <div style="margin-top: 6px;" class="clearfix">
                    <div style="float: left;width: 50%">
                        <label>Nombre</label>
                    </div>
                    <div style="float: none;width: auto;overflow: hidden;">
                        <input name="nombre" value="<%= categoria.get().getNombre() %>" />
                    </div>
                </div>

                    <% 	} else { %>

                request.sendRedirect("Categoria/");

                    <% 	} %>

        </div>
    </section>
</main>
</body>
<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
</html>