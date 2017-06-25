/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Camila
 */
@Entity
@Table(name = "GENERO")
public class Genero {
    
    @Id
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERO")
    private Long id;
    
    @Column(name = "DESCRICAO");
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
