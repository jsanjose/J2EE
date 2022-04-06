package datos;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormularioServlet extends HttpServlet {
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

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");

        try {
            out.println("<h1>Formulario</h1>");
            out.println("<b>Nombre:</b>&nbsp;" + nombre + "<br/>");
            out.println("<b>Edad:</b>&nbsp;" + edad + "<br/>");
        } finally {
            out.close();
        }

    }

}
