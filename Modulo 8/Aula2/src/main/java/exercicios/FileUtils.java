/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camila
 */
public class FileUtils {
    private File file;

    public boolean mk(String string) {
        try {
            file = new File(string);
            if (isFile(string)) {
                return file.createNewFile();
            } else {
                return file.mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rm(String string) {
        if (isDirectory(string)) {
            try {
                throw new Exception("Arquivo inválido.");
            } catch (Exception ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return new File(string).delete();
    }

    public String ls(String string) {
        if (isDirectory(string)) {
            StringBuilder sb = new StringBuilder();
            for (File f : new File(string).listFiles()) {
                sb.append(f.getName() + " ");
            }

            return sb.toString();
        } else {
            return new File(string).getAbsolutePath();
        }
    }

    public boolean mv(String in, String out) throws Exception {
        try {
            if (isDirectory(in)) {
                throw new Exception("Arquivo inválido.");
            }

            return new File(in).renameTo(new File(out));

        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean isFile(String string) {
        return string.contains(".");
    }

    public boolean isDirectory(String string) {
        return new File(string).isDirectory();
    }

    public boolean fileExist(String string) {
        return new File(string).exists();
    }
}
