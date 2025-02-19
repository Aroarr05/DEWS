<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String[] dados = {
          "1.svg",
          "2.svg",
          "3.svg",
          "4.svg",
          "5.svg",
          "6.svg"
  };
  int tirada = (int) (Math.random() * (8 - 2) + 2);
  ArrayList<String> ordenadas = new ArrayList<String>();

  for (int i = 0; i < tirada; i++) {
    int random = (int) (Math.random() * (dados.length));
    ordenadas.add(dados[random]);
  }

  String dado = "";
  for (int i = 0; i < ordenadas.size(); i++) {
    dado += "<img src=\"imgDados/"+ordenadas.get(i)+"\">";
  }

  ordenadas.sort(new Comparator<String>() {
    public int compare(String dado1, String dado2){
      int num1 = Integer.parseInt(dado1.replace(".svg",""));
      int num2 = Integer.parseInt(dado2.replace(".svg",""));
      return Integer.compare(num1, num2);
    }
  });

  String dado2 = "";
  for (int i = 0; i < ordenadas.size(); i++) {
    dado2 += "<img src=\"imgDados/"+ordenadas.get(i)+"\">";
  }

%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - DADOS</title>
</head>
<body>
<h1>Ordenar dados</h1>
<p>Actualize la pagina para mostrar una nueva tirada</p>

<h2>Tirada de <%=tirada%> dados</h2>
<div></div>
<%=dado%>
<h3>Tirada ordenada</h3>
<%=dado2%>

<br/>

</body>
</html>