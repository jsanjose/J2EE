<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Login OK</h1>

    <%
    String usr = (String)session.getAttribute("usr");
    String pwd = (String)session.getAttribute("pwd");
    if(usr != null && pwd != null) {
    %>

    <h2>¡Usuario validado!</h2>

    <p><b>Usuario:</b> <%=usr%></p>
    <p><b>Contraseña:</b> <%=pwd%></p>

    <%
    }
    else {
    %>

    <h2>¡Usuario no válido!</h2>

    <%
    }
    %>
  </body>
</html>