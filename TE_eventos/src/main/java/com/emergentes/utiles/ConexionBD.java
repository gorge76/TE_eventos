package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_eventos";
    static String usuario = "root";
    static String password = "";
    protected Connection conn = null;

    public ConexionBD() throws SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error en Driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en Conectar " + e.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error en al cerrar la BD " + ex.getMessage());
        }
    }
}
