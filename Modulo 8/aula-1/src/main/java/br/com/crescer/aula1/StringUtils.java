/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;


/**
 *
 * @author Camila
 */

import java.text.Normalizer;

public class StringUtils implements IStringUtils{

    @Override
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    @Override
    public String inverter(String string) {
        return isEmpty(string) ? "Impossível, variável nula" : new StringBuilder(string).reverse().toString();
    }

    @Override
    public int contaVogais(String string) {
        return isEmpty(string) ? 0 : string.length() - Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .toLowerCase()
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .replaceAll("[aeiou]", "")
                .length();
    }

    @Override
    public boolean isPalindromo(String string) {
        string = Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .toLowerCase()
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .replaceAll(" ", ""); // /s > tira espaços
        
        return string.equals(inverter(string));
    }    
}
