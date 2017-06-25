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
@Table(name = "VIDEO")
public class Video {
    @Id
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    private Long id;
    
    @Column(name = "VALOR");
    private double valor;
    
    @Column(name = "DURACAO");
    private String duracao;
    
    @ManyToOne(Cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO")
    private Long idGenero;
    
    @Column(name = "NOME");
    private String nome;
    
    @Column(name = "QUANTIDADE_ESTOQUE");
    private double quantidadeEstoque;
    
    @Column(name = "DATA_LANCAMENTO");
    private Date dataLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    
}
