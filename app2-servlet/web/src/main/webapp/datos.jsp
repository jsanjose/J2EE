<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Datos</h1>

    <p><b>Nombre:</b> <%=request.getAttribute("nombre")%> </p>
    <p><b>Edad:</b> <%=request.getAttribute("edad")%> </p>
    <%
      List<String> personas = (List<String>) request.getAttribute("personas");
      int i = 0;
      for (String persona : personas) {
          i++;
    %>
    <p><b>Persona <%=i%>: </b> <%=persona%> </p>
    <%
      }
    %>

  </body>
</html>
