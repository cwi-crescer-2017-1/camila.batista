/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camila
 */
public class WriteUtils {
    private File file;

    public void write(String stringFile, String conteudo) {
        file = new File(stringFile);
        try {
            if (!stringFile.contains(".txt")) {
                throw new Exception("Este não é um arquivo .txt");
            } else if (!Files.exists(file.toPath())) {
                throw new Exception("Arquivo não encontrado.");
            }

            final Writer writer = new FileWriter(stringFile);
            final BufferedWriter bufferReader = new BufferedWriter(writer);

            bufferReader.append(conteudo);

            bufferReader.flush();
        } catch (Exception ex) {
            Logger.getLogger(WriteUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
