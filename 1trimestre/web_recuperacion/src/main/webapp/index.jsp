<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        #contenedor {
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
        }
        .btn-lg {
            font-size: 18px;
            border-radius: 10px; /* Bordes redondeados */
            width: 250px; /* Ancho fijo para los botones */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Sombra suave para los botones */
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }

        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }

        .btn-warning:hover {
            background-color: #e0a800;
            border-color: #d39e00;
        }
    </style>
    <%@ include file="/WEB-INF/jsp/fragmentos/estilo.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<div class="d-grid gap-1" id="contenedor">
    <a class="btn btn-light btn-lg mt-2" href="<%=application.getContextPath()%>/ventas_plus/categoria/">CATEGORIA</a>
    <a class="btn btn-secondary btn-lg mt-2" href="<%=application.getContextPath()%>/ventas_plus/producto">PRODUCTO</a>
</div>

<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
<%@include file="boostrap.jspf"%>
</body>
</html>
