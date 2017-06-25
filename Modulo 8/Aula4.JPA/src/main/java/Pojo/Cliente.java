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
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_CLIENTE")    
    private long id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "CPF")
    private String CPF;
    
    @Column(name = "RG")
    private String RG;
    
    @Column(name = "RUA")
    private String rua;
    
    @Column(name = "BAIRRO")
    private String bairro;
    
    @Column(name = "CIDADE")
    private String cidade;
    
    @Column(name = "NUMERO_CASA")
    private String numeroCasa;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Column(name = "CELULAR")
    private String celular;
    
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    public Cliente(){}

    public Cliente(String nome, String CPF, String RG, String rua, String bairro, String cidade, String numeroCasa, String email, String telefone, String celular, Date dataNascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
}
