<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h2>Formulario</h2>

    <form action="../buscar" method="post">
        <label for="nombre">Nombre:</label><br/>
        <input type="text" id="nombre" name="nombre"/><br/>
        <input type="submit" value="Aceptar" />
    </form>

  </body>
</html>
