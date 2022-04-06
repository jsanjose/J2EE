package fechas;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class FechasServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String anyo = request.getParameter("anyo");

        int nAnyo = Integer.parseInt(anyo);
        int nMes = Integer.parseInt(mes);
        int nDia = Integer.parseInt(dia);

        Date fechaActual = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.set(nAnyo, nMes-1, nDia);
        Date fechaEntrada = c.getTime();
        long numDias = fechaEntrada.getTime() - fechaActual.getTime();

        request.setAttribute("fechaActual", fechaActual.toString());
        request.setAttribute("fechaEntrada", fechaEntrada.toString());
        request.setAttribute("numDias", numDias / 1000 / 60 / 60 / 24);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("fechas_result.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
