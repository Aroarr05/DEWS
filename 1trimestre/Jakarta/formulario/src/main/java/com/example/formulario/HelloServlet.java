package com.example.formulario;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

class Persona{
    String nombre;
    String apellido;
    String edad;
    String peso;
    String sexo;
    String estado;
    String aficiones;
}

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Persona persona = new Persona();
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        persona.nombre = request.getParameter("nombre");
        persona.apellido = request.getParameter("apellido");
        persona.edad = request.getParameter("edad");
        persona.peso = request.getParameter("peso");
        persona.sexo = request.getParameter("sexo");
        persona.estado = request.getParameter("estado");

        persona.aficiones = "";

        if (request.getParameter("cine") != null) {
            persona.aficiones += "cine, ";
        }
        if (request.getParameter("deporte") != null) {
            persona.aficiones += "deporte, ";
        }
        if (request.getParameter("literatura") != null) {
            persona.aficiones += "literatura, ";
        }
        if (request.getParameter("musica") != null) {
            persona.aficiones += "musica, ";
        }
        if (request.getParameter("tebeos") != null) {
            persona.aficiones += "tebeos, ";
        }
        if (request.getParameter("television") != null) {
            persona.aficiones += "television, ";
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1> Nombre: " + persona.nombre + "</h1>");
        out.println("<h2> Apellido: " + persona.apellido + "</h2>");
        out.println("<h2> Edad: " + persona.edad + "</h2>");
        out.println("<h2> Peso: " + persona.peso + "</h2>");
        out.println("<h2> Sexo: " + persona.sexo + "</h2>");
        out.println("<h2> Estado: " + persona.estado + "</h2>");
        out.println("<h2> Aficiones: " + persona.aficiones + "</h2>");
        out.println("</body>");
        out.println("</html>");

    }

    public void destroy() {
    }
}