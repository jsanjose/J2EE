<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Formulario</h1>

    <form action="formulario" method="post">
        <label for="nombre">Nombre:</label><br/>
        <input type="text" id="nombre" name="nombre"/><br/>
        <label for="edad">Edad:</label><br/>
        <input type="text" id="edad" name="edad"/><br/>
        <input type="submit" value="Aceptar" />
    </form>

  </body>
</html>
