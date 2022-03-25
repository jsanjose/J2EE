<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
</head>

<body>
    <h2>DIAS PARA COBRAR</h2>
    
    <%
    Date diaActual = Calendar.getInstance().getTime();
    int ultimoDia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
    Date ultimoDiaMes = ...
    long paraCobrar = ultimoDiaMes.getTime() - diaActual.getTime();
    %>

    <p>Quedan <%=paraCobrar/1000/60/60/24%> días para cobrar €€€</p>

    <br>
    
    <h2>NÚMEROS IMPARES</h2>

    <%
    for (int i = 0; i <= 100; i++) {
        if ((i % 2) != 0) {
            out.println("<p>Impar: " + i + "</p>");
        }
    }
    %>

</body>

</html>