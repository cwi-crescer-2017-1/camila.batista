/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author camila.batista
 */
public enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static void todosEstados(){
        StringBuffer sb = new StringBuffer();
        int cont = 0;
        for(Estados e : Estados.values()){
            if(cont != 0){
                sb.append(", ");
            }
            
            sb.append(e.getNome());
            cont++;
        }
        
        int posicao = sb.length() -1;
        String es = sb.toString();
        
        ArrayList<String> a = new ArrayList<String>(Arrays.asList(es.split(", ")));
        java.util.Collections.sort(a);
        System.out.println(a.toString());
    } 
}
