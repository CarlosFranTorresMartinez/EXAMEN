/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC09
 */
@Entity
@Table(name = "GENERO_PELICULA", catalog = "CINE", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneroPelicula.findAll", query = "SELECT g FROM GeneroPelicula g")
    , @NamedQuery(name = "GeneroPelicula.findByIdgen", query = "SELECT g FROM GeneroPelicula g WHERE g.idgen = :idgen")
    , @NamedQuery(name = "GeneroPelicula.findByGen", query = "SELECT g FROM GeneroPelicula g WHERE g.gen = :gen")})
public class GeneroPelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDGEN")
    private Integer idgen;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "GEN")
    private String gen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgen")
    private List<Pelicula> peliculaList;

    public GeneroPelicula() {
    }

    public GeneroPelicula(Integer idgen) {
        this.idgen = idgen;
    }

    public GeneroPelicula(Integer idgen, String gen) {
        this.idgen = idgen;
        this.gen = gen;
    }

    public Integer getIdgen() {
        return idgen;
    }

    public void setIdgen(Integer idgen) {
        this.idgen = idgen;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @XmlTransient
    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgen != null ? idgen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneroPelicula)) {
            return false;
        }
        GeneroPelicula other = (GeneroPelicula) object;
        if ((this.idgen == null && other.idgen != null) || (this.idgen != null && !this.idgen.equals(other.idgen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GeneroPelicula[ idgen=" + idgen + " ]";
    }

}
