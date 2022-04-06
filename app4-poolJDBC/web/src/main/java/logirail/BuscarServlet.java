package logirail;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuscarServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Connection conn = null;

        try {
            String nombre = request.getParameter("nombre");
            System.out.println(">>> Nombre: " + nombre);

            if (nombre != null && !nombre.isEmpty()) {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource ds = (DataSource) envCtx.lookup("jdbc/sqliteDS");
                conn = ds.getConnection();

                ResultSet rs = null;
                PreparedStatement stmt = null;
                String sql = "select * from contactos where nombre='" + nombre + "'";

                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();

                List<String> datos = new ArrayList<String>();

                while (rs.next()) {
                    String persona = rs.getInt("id_contacto") + ": " +
                            rs.getString("nombre") + " " + rs.getString("apellidos");
                    datos.add(persona);
                }

                HttpSession session = request.getSession(true);
                session.setAttribute("datos", datos);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/lista.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/error.jsp");
                request.setAttribute("msgError", "Falta el nombre para buscar");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
