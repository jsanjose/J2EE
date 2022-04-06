<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Fechas</h1>

    <p><b>Fecha actual:</b> <%=request.getAttribute("fechaActual")%></p>
    <p><b>Fecha entrada:</b> <%=request.getAttribute("fechaEntrada")%></p>
    <p><b>Nº dias:</b> <%=request.getAttribute("numDias")%></p>

  </body>
</html>