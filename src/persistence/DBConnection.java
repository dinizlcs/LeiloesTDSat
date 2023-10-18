package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private Connection conn;
    private final String 
            url = "jdbc:mysql://localhost:3306/leiloestdsat",
            user = "root",
            password = "pw";
    
    public boolean connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar no banco");
            return false;
        }
    }
    
    public void disconnect(){
        try{
            conn.close();
            System.out.println("Conexão encerrada");
        }catch (SQLException | NullPointerException ex){
            
        }
    }

    public Connection getConn() {
        return conn;
    }
    
}
