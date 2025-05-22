<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Fabricante"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Producto" %>


<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
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
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1>Productos</h1>
			<%
				Usuario u = (Usuario) session.getAttribute("usuario-logado");
				String rol = (u != null) ? u.getRol() : " ";
				if ("administrador".equals(rol)) {
			%>
			<form action="${pageContext.request.contextPath}/tienda/productos/crear">
				<button type="submit" class="btn btn-primary">Crear Producto</button>
			</form>
			<% } %>
		</div>

		<div class="centrado">
		<form class="d-flex mb-3" action="${pageContext.request.contextPath}/tienda/productos/" method="get">
			<input type="search" name="filtrar-por-nombre" class="form-control me-2" placeholder="Buscar por nombre">
			<button type="submit" class="btn btn-outline-secondary">Filtrar</button>
		</form>
		</div>

		<hr>

		<%
			List<Producto> listaProducto = (List<Producto>) request.getAttribute("listaProductos");
			if (listaProducto != null && !listaProducto.isEmpty()) {
		%>
		<table class="table table-bordered table-striped">
			<thead>
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Precio</th>
				<% if ("administrador".equals(rol)) { %>
				<th>Acciones</th>
				<% } %>
			</tr>
			</thead>
			<tbody>
			<% for (Producto producto : listaProducto) { %>
			<tr>
				<td><%= producto.getIdProducto() %></td>
				<td><%= producto.getNombre() %></td>
				<td><%= producto.getPrecio() %></td>
				<% if ("administrador".equals(rol)) { %>
				<td>
					<div class="d-flex justify-content-center">
						<form action="${pageContext.request.contextPath}/tienda/productos/<%= producto.getIdProducto() %>" method="get" class="me-2">
							<button type="submit" class="btn btn-info btn-sm">Ver Detalle</button>
						</form>
						<form action="${pageContext.request.contextPath}/tienda/productos/editar/<%= producto.getIdProducto() %>" method="get" class="me-2">
							<button type="submit" class="btn btn-warning btn-sm">Editar</button>
						</form>
						<form action="${pageContext.request.contextPath}/tienda/productos/borrar/" method="post">
							<input type="hidden" name="__method__" value="delete">
							<input type="hidden" name="codigo" value="<%= producto.getIdProducto() %>">
							<button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
						</form>
					</div>
				</td>
				<% } %>
			</tr>
			<% } %>
			</tbody>
		</table>
		<% } else { %>
		<p class="no-users">No hay registros de producto.</p>
		<% } %>
	</section>
</main>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0+Wv0vQWzFhVAqOG7xzw8lLa+d/b9huL3n2Qv3wUDeYsZkwv" crossorigin="anonymous"></script>
</body>
</html>