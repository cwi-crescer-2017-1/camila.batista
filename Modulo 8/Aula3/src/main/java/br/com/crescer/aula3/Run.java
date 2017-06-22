package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author camila.batista
 */
public class Run {
    public static void main(String[] args) {
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "MEGASENA";
        final String pass = "MEGASENA";

//        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
//
//        } catch (SQLException e) {
//          System.err.format("SQLException: %s", e);
//        }
    
        final String query = "select * from pais";
         
        try(final Connection connection = DriverManager.getConnection(url, user, pass);
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query)){
              
            while(resultSet.next()){
                System.out.println(resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
    }
}
