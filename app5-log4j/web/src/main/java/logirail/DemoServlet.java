package logirail;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(DemoServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        log.debug("--- doGet :::");
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        log.debug("--- doPost :::");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>DemoServlet</h1>");
        out.println("<h2>¡Hola Mundo!</h2>");
        out.println("</html></body>");
        out.close();
    }
}
