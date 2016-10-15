package Conexao;

import java.sql.*;

public class Conexao {

    public static Connection c;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (c == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/bd";
            String user = "root";
            String pass = "root";
            c = DriverManager.getConnection(url, user, pass);
            
            return c;

        } else {
            return c;
        }

        /*private static class ConexaoHolder {

        private static final Conexao INSTANCE = new Conexao();
    }*/
    }
}
