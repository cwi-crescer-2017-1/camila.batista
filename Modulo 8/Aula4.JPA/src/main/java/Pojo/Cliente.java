/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author camila.batista
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{

    @Id
    @Basic(optional=false)
    @Column(name="ID_CLIENTE")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String nome;
    
    public Cliente(){}

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
