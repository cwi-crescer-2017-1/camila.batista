/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.crescer.aula1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author camila.batista
 */
public class exeData {
    public static void main (String[]args){
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite uma data (dd/MM/yyyy)");
            String data = scanner.nextLine();
            
            System.out.println("Número de dias a ser somado");
            int dias = scanner.nextInt();
            
            Date date = null;
                    
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            
            calendar.add(Calendar.DAY_OF_MONTH, dias);
            
            System.out.println(calendar.getTime());
        } catch (Exception e) {            
        }
    }   
}