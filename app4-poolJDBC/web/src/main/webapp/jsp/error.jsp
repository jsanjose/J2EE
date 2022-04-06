<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h2>¡Error!</h2>
    <p><%= request.getAttribute("msgError") %></p>
  </body>
</html>
