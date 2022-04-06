package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConexion {
    private static String urlBBDD = "jdbc:sqlite:C:/J2EE/server/sqlite3/app.db";
    private static Connection conn = null;

    public static Connection getConexion() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(urlBBDD);
            } catch (SQLException e) {
                e.printStackTrace();
            }       
        }
        return conn;
    }

    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}