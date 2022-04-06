package logirail;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.util.Properties;

public class DemoServlet extends HttpServlet {
    Properties prop = new Properties();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        leerPropiedades();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>DemoServlet</h1>");
        out.println("<h2>Properties</h2>");

        out.println("<p><b>URL:</b>&nbsp;" + prop.getProperty("db.url") + "</p>");
        out.println("<p><b>USER:</b>&nbsp;" + prop.getProperty("db.user") + "</p>");
        out.println("<p><b>PASSWORD:</b>&nbsp;" + prop.getProperty("db.password") + "</p>");
        
        out.println("</html></body>");
        out.close();
    }

    private void leerPropiedades() {
        try (InputStream inputProp = DemoServlet.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputProp == null) return;
            prop.load(inputProp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
