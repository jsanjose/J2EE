<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>

  <body>
    <h1>Login</h1>

    <form action="login" method="post">
        <label for="usr">Usuario:</label><br/>
        <input type="text" id="usr" name="usr"/><br/>
        <label for="pwd">Contraseña:</label><br/>
        <input type="password" id="pwd" name="pwd"/><br/>
        <input type="submit" value="Aceptar" />
    </form>

  </body>
</html>
