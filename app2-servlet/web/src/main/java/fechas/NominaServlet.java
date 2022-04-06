package fechas;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.Calendar;
import java.util.Date;

public class NominaServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Calendar fechaActual = Calendar.getInstance();
        Date diaActual = fechaActual.getTime();
        int ultimoDia = fechaActual.getActualMaximum(Calendar.DAY_OF_MONTH);
        int mes = fechaActual.get(Calendar.MONTH);
        int anyo = fechaActual.get(Calendar.YEAR);

        Calendar finMes = Calendar.getInstance();
        finMes.set(anyo, mes, ultimoDia);
        Date ultimoDiaMes = finMes.getTime();

        long paraCobrar = ultimoDiaMes.getTime() - diaActual.getTime();

        try {
            out.println("<h1>Nómina</h1>");
            out.println("<p>Quedan " + paraCobrar / 1000 / 60 / 60 / 24 + " días para cobrar €€€</p>");
        } finally {
            out.close();
        }
    }
}
