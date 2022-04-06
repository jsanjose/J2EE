<%@ page contentType="text/html; charset=UTF-8" %>

<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h2>Datos</h2>
    
    <%
    List<String> datos = (List<String>) session.getAttribute("datos");

    if (datos != null && !datos.isEmpty()) {
        for (String dato: datos) {
    %>

    <p><%= dato %></p>

    <%
        }
    }
    else {
    %>

    <p>¡No hay datos!</p>

    <%        
    }
    %>

  </body>
</html>