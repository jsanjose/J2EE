package datos;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DatosServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        request.setAttribute("nombre", "Jose");
        request.setAttribute("edad", "33");
        
        List<String> personas = Arrays.asList("María", "Luis", "Ana", "Jose", "Ruth");
        request.setAttribute("personas", personas);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("datos.jsp");
        requestDispatcher.forward(request, response);
    }
}
