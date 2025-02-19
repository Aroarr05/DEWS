<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Empleado" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .form-container {
            max-width: 900px;
            margin: 30px auto;
        }
        .no-users {
            text-align: center;
            font-size: 18px;
            color: #777;
        }
        .table th, .table td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-sm {
            padding: 5px 10px;
        }
    </style>
    <%@ include file="/WEB-INF/jsp/fragmentos/estilo.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<main class="container mt-4">
    <section>
        <form action="${pageContext.request.contextPath}/empleados/empleado/crear">
            <button type="submit" class="btn btn-primary">Crear Empleado</button>
        </form>
        <%
            List<Empleado> listaEmpleado = (List<Empleado>) request.getAttribute("listaEmpleados");
            if (listaEmpleado != null && !listaEmpleado.isEmpty()) {
        %>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Código</th>
                <th>Nif</th>
                <th>Nombre</th>
                <th>Apellido1</th>
                <th>Apellido2</th>
                <th>Codigo_departamento</th>
                <th>Accion</th>
            </tr>

            </thead>
            <tbody>
            <% for (Empleado empleado : listaEmpleado) { %>
            <tr>
                <td><%= empleado.getCodigo() %></td>
                <td><%= empleado.getNif() %></td>
                <td><%= empleado.getNombre() %></td>
                <td><%= empleado.getApellido1() %></td>
                <td><%= empleado.getApellido2() %></td>
                <td><%= empleado.getCodigo_departamento() %></td>

                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/empleados/empleado/<%= empleado.getCodigo() %>" style="display: inline;">
                        <input type="submit" class="btn btn-info btn-sm" value="Ver Detalle" />
                    </form>
                    <form action="${pageContext.request.contextPath}/empleados/empleado/editar/<%= empleado.getCodigo() %>" style="display: inline;">
                        <input type="submit" class="btn btn-warning btn-sm" value="Editar" />
                    </form>
                    <form action="${pageContext.request.contextPath}/empleados/empleado/borrar/" method="post" style="display: inline;">
                        <input type="hidden" name="__method__" value="delete"/>
                        <input type="hidden" name="codigo" value="<%= empleado.getCodigo() %>"/>
                        <input type="submit" class="btn btn-danger btn-sm" value="Eliminar" />
                    </form>
                </td>

            </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p class="no-users">No hay registros de empleado.</p>
        <% } %>
    </section>
</main>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0+Wv0vQWzFhVAqOG7xzw8lLa+d/b9huL3n2Qv3wUDeYsZkwv" crossorigin="anonymous"></script>
</body>
</html>