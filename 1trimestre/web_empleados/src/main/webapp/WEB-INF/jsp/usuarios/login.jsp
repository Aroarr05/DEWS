<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<main class = "body_sec">
    <section id="Content">
        <div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
            <div class="clearfix">
                <div style="float: left; width: 50%">
                    <h1>Iniciar Sesion</h1>
                </div>
            </div>
            <div class="clearfix">
                <hr/>
            </div>
            <form action="${pageContext.request.contextPath}/tienda/usuarios/login/" method="post" style="display: inline;">
                <input type="hidden" name="__method__" value="login"/>
                <div style="margin-top: 6px;" class="clearfix">
                    <div style="margin-top: 6px;" class="clearfix">
                        <div style="float: left;width: 50%">
                            Usuario
                        </div>
                        <div style="float: none;width: auto;overflow: hidden;">
                            <input name="usuario" />
                        </div>
                    </div>
                    <div style="margin-top: 6px;" class="clearfix">
                        <div style="float: left;width: 50%">
                            Contraseña
                        </div>
                        <div style="float: none;width: auto;overflow: hidden;">
                            <input name="contrasena" />
                        </div>
                    </div>
                    <div style="margin-top: 6px;" class="clearfix">
                        <div style="float: none;width: auto;overflow: hidden;">
                            <input type="hidden" name="__method__" value="login"/>
                            <input type="submit" name="Iniciar Sesion" />
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