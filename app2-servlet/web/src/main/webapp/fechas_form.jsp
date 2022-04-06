<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Fechas</h1>

    <form action="fechas" method="post">
        <label for="dia">Dia:</label><br/>
        <input type="text" id="dia" name="dia"/><br/>
        <label for="mes">Mes:</label><br/>
        <input type="text" id="mes" name="mes"/><br/>
        <label for="anyo">Año:</label><br/>
        <input type="text" id="anyo" name="anyo"/><br/>
        <input type="submit" value="Aceptar" />
    </form>

  </body>
</html>
