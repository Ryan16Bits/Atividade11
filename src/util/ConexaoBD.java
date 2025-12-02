package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    private static final String url = "jdbc:mysql://localhost:3306/minitok";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}
