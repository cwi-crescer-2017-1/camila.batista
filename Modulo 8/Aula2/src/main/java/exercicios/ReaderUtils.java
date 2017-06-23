/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camila
 */
public class ReaderUtils {
    
    private File file;
    public String read(String string) {
        try {
            file = new File(string);

            if (!string.contains(".txt")) {
                throw new Exception("Este não é um arquivo .txt");
            } else if (!Files.exists(file.toPath())) {
                throw new Exception("Arquivo não encontrado.");
            }

            final Reader reader = new FileReader(string);
            final BufferedReader bufferReader = new BufferedReader(reader);

            final StringBuilder sb = new StringBuilder();

            bufferReader.lines().forEach(l -> sb.append(l + "\n"));

            return sb.toString();

        } catch (Exception ex) {
            Logger.getLogger(ReaderUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
}
