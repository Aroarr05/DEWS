<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Fabricante"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.FabricanteDTO" %>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Fabricantes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<style>
		.clearfix::after {
			content: "";
			display: block;
			clear: both;
		}
		.form-container {
			margin: 30px auto;
			max-width: 900px;
		}
	</style>
	<%@ include file="/WEB-INF/jsp/fragmentos/estilo.jspf" %>
</head>
<body>

<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<main class="body_sec">
	<section id="Content">
		<div class="form-container">
			<div class="clearfix mb-4">
				<div class="d-flex justify-content-between">
					<h1>Fabricantes</h1>
				<%Usuario usuario = (Usuario) session.getAttribute("usuario-logado");
					String rol = (usuario != null) ? usuario.getRol() : " ";
					if ("administrador".equals(rol)) {
				%>
					<form action="${pageContext.request.contextPath}/tienda/fabricantes/crear">
						<input type="submit" class="btn btn-primary" value="Crear Fabricante">
					</form>
				</div>
			</div>
			<%}%>

			<!-- Formulario de Filtro y Ordenación -->
			<div class="clearfix mb-4">
				<form action="${pageContext.request.contextPath}/tienda/fabricantes" method="get" class="d-flex justify-content-between">
					<div>
						<label for="ordenar-por">ORDENAR</label>
						<select name="ordenar-por" class="form-select" id="ordenar-por">
							<option value="nombre">Nombre</option>
							<option value="codigo">Código</option>
						</select>
					</div>
					<div>
						<label for="modo-ordenar">MODO</label>
						<select name="modo-ordenar" class="form-select" id="modo-ordenar">
							<option value="asc">Ascendente</option>
							<option value="desc">Descendente</option>
						</select>
					</div>
					<div>
						<input type="submit" class="btn btn-secondary" value="Ordenar">
					</div>
				</form>
			</div>

			<hr/>

			<!-- Tabla de Fabricantes -->
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
					<tr>
						<th style="width: 10%;">Código</th>
						<th style="width: 30%;">Nombre</th>
						<th style="width: 20%;">Nº Productos</th>
						<% if ("administrador".equals(rol)) { %>
						<th>Acciones</th>
						<% } %>
					</tr>
					</thead>
					<tbody>
					<%
							if (request.getAttribute("listaFabricantes") != null) {
								List<FabricanteDTO> listaFabricante = (List<FabricanteDTO>) request.getAttribute("listaFabricantes");

								for (FabricanteDTO fabricante : listaFabricante) {
					%>
					<tr>
						<td><%= fabricante.getIdFabricante() %></td>
						<td><%= fabricante.getNombre() %></td>
						<td><%= fabricante.getNumProductos() %></td>
						<%
							if ("administrador".equals(rol)) {
						%>
						<td class="text-center">
							<form action="${pageContext.request.contextPath}/tienda/fabricantes/<%= fabricante.getIdFabricante() %>" style="display: inline;">
								<input type="submit" class="btn btn-info btn-sm" value="Ver Detalle" />
							</form>
							<form action="${pageContext.request.contextPath}/tienda/fabricantes/editar/<%= fabricante.getIdFabricante() %>" style="display: inline;">
								<input type="submit" class="btn btn-warning btn-sm" value="Editar" />
							</form>
							<form action="${pageContext.request.contextPath}/tienda/fabricantes/borrar/" method="post" style="display: inline;">
								<input type="hidden" name="__method__" value="delete"/>
								<input type="hidden" name="codigo" value="<%= fabricante.getIdFabricante() %>"/>
								<input type="submit" class="btn btn-danger btn-sm" value="Eliminar" />
							</form>
						</td>
					</tr>
					<%
							}
						}
					} else {
					%>
					<tr>
						<td colspan="4" class="text-center">No hay registros de fabricantes</td>
					</tr>
					<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</main>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0+Wv0vQWzFhVAqOG7xzw8lLa+d/b9huL3n2Qv3wUDeYsZkwv" crossorigin="anonymous"></script>
</body>
</html>