/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila.batista
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario_1 u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario_1 u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario_1 u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario_1 u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario_1 u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario_1 u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario_1 u WHERE u.dataNascimento = :dataNascimento")})
public class Usuario implements Serializable{
    
    private static final String SQ_USUARIO = "SEQ_USUARIO";

    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_USUARIO)
    @SequenceGenerator(name = SQ_USUARIO, sequenceName = SQ_USUARIO, allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    
    @Basic(optional = false)
    @Column(name = "GENERO")
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Post> post;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amigos;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> convites;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Comentario comentario;

    public Usuario(){}
    
    public Usuario(String nome, String email, String senha, Genero genero, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    public Set<Usuario> getConvites() {
        return convites;
    }

    public void setConvites(Set<Usuario> convites) {
        this.convites = convites;
    }
    
     public List<Post> getPosts() {
        return post;
    }

    public void setPosts(List<Post> posts) {
        this.post = posts;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuario_1[ id=" + id + " ]";
    }
}
