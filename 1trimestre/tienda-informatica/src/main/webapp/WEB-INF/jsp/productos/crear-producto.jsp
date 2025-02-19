<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Fabricante"%>
<%@page import="java.util.Optional"%>
<%@ page import="org.iesbelen.model.FabricanteDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Fabricante</title>
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
    <section id="Content">
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <form action="${pageContext.request.contextPath}/tienda/productos/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Productos</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    Nombre
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input name="nombre" />
                </div>
            </div>
            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    Precio
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input name="precio" />
                </div>
            </div>
            <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Fabricante
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <select name="fab" id="fab">
                    <%
                        if (request.getAttribute("listaFabricantes") != null) {
                            List<FabricanteDTO> listaFabricante = (List<FabricanteDTO>)request.getAttribute("listaFabricantes");

                            for (FabricanteDTO fabricante : listaFabricante) {
                    %>
                    <option value="<%=fabricante.getIdFabricante()%>">
                        <%=fabricante.getNombre()%>
                    </option>
                    <%
                        }
                    } else {
                    %>
                    No hay registros de fabricante
                    <% } %>
                </select>
            </div>
            </div>
        </div>

    </form>
</div>
</section>
</main>
</body>
<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
</html>