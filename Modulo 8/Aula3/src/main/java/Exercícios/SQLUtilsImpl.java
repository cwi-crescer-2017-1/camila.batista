/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercícios;

import br.com.crescer.aula3.ConnectionUtils;
import exercicios.ReaderUtils;
import exercicios.WriteUtils;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camila
 */
public class SQLUtilsImpl implements SQLUtils{

    @Override
    public void runFile(String filename) {
        final String reader = new ReaderUtils().read(filename);
        
        if(filename.endsWith(".sql")){
            try(final Statement statement = ConnectionUtils.getConnection().createStatement()){
                
               for(String a : reader.split(";")){
                   statement.execute(a);
               }
                
            } catch (Exception ex) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String executeQuery(String query) {
        StringBuilder stringBuilder = new StringBuilder();
        
        try(final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(query)){
            
            try(final ResultSet resultSet = preparedStatement.executeQuery()){
                ResultSetMetaData linhas = resultSet.getMetaData();
                int colunas = linhas.getColumnCount();
                
//                for (int i = 1; i <= linhas.getColumnCount(); i++) {;
//                    stringBuilder.append(linhas.getColumnLabel(i)).append("\t").append("\n");;
//                }
//
//                while (resultSet.next()) {
//
//                    for (int i = 1; i <= linhas.getColumnCount(); i++) {
//                        stringBuilder.append(resultSet.getObject(i) + "\t").append("\t").append("\n");
//                    }
//                }
                
                while(resultSet.next()){
                    for(int a = 1; a < colunas;a++){
                        stringBuilder.append(resultSet.getString(a + 1)).append(", ");
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 2);
                    stringBuilder.append("\n");
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringBuilder.toString();
    }

    @Override
    public void importCSV(File file) {
        
    }

    @Override
    public File exportCSV(String query) {
        String csv = executeQuery(query);
        String path = "C:\\Users\\Camila\\Desktop\\export.csv";
        
        new WriteUtils().write(path, csv);
        
        return new File(path);
    }

}
