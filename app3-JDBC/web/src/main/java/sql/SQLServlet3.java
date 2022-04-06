package sql;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SQLServlet3 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Connection conn = null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/sqliteDS");
            conn = ds.getConnection();

            ResultSet rs = null;
            PreparedStatement stmt = null;
            String sql = "select * from contactos";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td><b>ID</b></td>");
            out.println("<td><b>Nombre</b></td>");
            out.println("<td><b>Apellidos</b></td>");
            out.println("<td><b>Email</b></td>");
            out.println("<td><b>Teléfono</b></td>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id_contacto") + "</td>");
                out.println("<td>" + rs.getString("nombre") + "</td>");
                out.println("<td>" + rs.getString("apellidos") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("tfno") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</html></body>");

        } catch (Exception e) {
            out.println("<b>¡¡¡ERROR!!!</b>");
            out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}
