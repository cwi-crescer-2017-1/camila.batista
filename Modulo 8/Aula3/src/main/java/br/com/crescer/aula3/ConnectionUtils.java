package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionUtils {
    
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER = "MEGASENA";
    private static String PASS = "MEGASENA";
    
    private ConnectionUtils(){
       
    }
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
