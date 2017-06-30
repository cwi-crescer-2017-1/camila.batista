/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author camila.batista
 */
public enum Genero {
    FEMININO(1),
    MASCULINO(2);
    
    private int tipo;
    
    Genero(int tipo){
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
