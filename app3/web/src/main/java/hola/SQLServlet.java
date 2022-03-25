package hola;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServlet extends HttpServlet {
    String urlBBDD = "jdbc:sqlite:C:/J2EE/server/sqlite3/app.db";
    Connection conn = null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        try {
            out.println("<p>Conectando con SQLite: " + urlBBDD + "</p>");
            try {
                connect();

                ResultSet rs = null;
                PreparedStatement stmt = null;
                String sql = "select * from contacts";

                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();

                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td><b>contact_id</b></td>");
                out.println("<td><b>first_name</b></td>");
                out.println("<td><b>last_name</b></td>");
                out.println("<td><b>email</b></td>");
                out.println("<td><b>phone</b></td>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("contact_id") + "</td>");
                    out.println("<td>" + rs.getString("first_name") + "</td>");
                    out.println("<td>" + rs.getString("last_name") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("phone") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</html></body>");

            } catch (Exception e) {
                out.println("<b>¡¡¡ERROR!!!</b>");
                out.println(e.getMessage());
            } finally {
                try {
                    disconnect();
                } catch (Exception ee) {
                    // no hacemos nada
                }
            }
        } finally {
            out.close();
        }
    }

    private void connect() throws Exception {
        try {
            conn = DriverManager.getConnection(urlBBDD);
            System.out.println("Conexión con SQLite correcta.");
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
            throw new Exception("Error al conectar: " + e.getMessage());
        }
    }

    private void disconnect() throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al desconectar: " + e.getMessage());
        }
    }
}
