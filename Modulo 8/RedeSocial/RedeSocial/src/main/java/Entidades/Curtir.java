/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila.batista
 */
@Entity
@Table(name = "CURTIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtir.findAll", query = "SELECT c FROM Curtir c"),
    @NamedQuery(name = "Curtir.findById", query = "SELECT c FROM Curtir c WHERE c.id = :id")})
public class Curtir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_CURTIDA")
    private Usuario usuarioCurtida;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "curtir")
    private Post post;

    public Curtir() {
    }

    public Curtir(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
    public Usuario getUsuarioCurtida() {
        return usuarioCurtida;
    }

    public void setUsuarioCurtida(Usuario usuarioCurtida) {
        this.usuarioCurtida = usuarioCurtida;
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
        if (!(object instanceof Curtir)) {
            return false;
        }
        Curtir other = (Curtir) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Curtir[ id=" + id + " ]";
    }
    
}
