/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC09
 */
@Entity
@Table(catalog = "CINE", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByIdpel", query = "SELECT p FROM Pelicula p WHERE p.idpel = :idpel")
    , @NamedQuery(name = "Pelicula.findByNompel", query = "SELECT p FROM Pelicula p WHERE p.nompel = :nompel")
    , @NamedQuery(name = "Pelicula.findBySalapel", query = "SELECT p FROM Pelicula p WHERE p.salapel = :salapel")
    , @NamedQuery(name = "Pelicula.findByFechestreno", query = "SELECT p FROM Pelicula p WHERE p.fechestreno = :fechestreno")
    , @NamedQuery(name = "Pelicula.findByFechtermino", query = "SELECT p FROM Pelicula p WHERE p.fechtermino = :fechtermino")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPEL")
    private Integer idpel;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMPEL")
    private String nompel;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SALAPEL")
    private int salapel;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHESTRENO")
    @Temporal(TemporalType.DATE)
    private Date fechestreno;

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHTERMINO")
    @Temporal(TemporalType.DATE)
    private Date fechtermino;

    @JoinColumn(name = "IDGEN", referencedColumnName = "IDGEN", nullable = false)
    @ManyToOne(optional = false)
    private GeneroPelicula idgen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpel")
    private List<VentaEntrada> ventaEntradaList;

    public Pelicula() {
    }

    public Pelicula(Integer idpel) {
        this.idpel = idpel;
    }

    public Pelicula(Integer idpel, String nompel, int salapel, Date fechestreno, Date fechtermino) {
        this.idpel = idpel;
        this.nompel = nompel;
        this.salapel = salapel;
        this.fechestreno = fechestreno;
        this.fechtermino = fechtermino;
    }

    public Integer getIdpel() {
        return idpel;
    }

    public void setIdpel(Integer idpel) {
        this.idpel = idpel;
    }

    public String getNompel() {
        return nompel;
    }

    public void setNompel(String nompel) {
        this.nompel = nompel;
    }

    public int getSalapel() {
        return salapel;
    }

    public void setSalapel(int salapel) {
        this.salapel = salapel;
    }

    public Date getFechestreno() {
        return fechestreno;
    }

    public void setFechestreno(Date fechestreno) {
        this.fechestreno = fechestreno;
    }

    public Date getFechtermino() {
        return fechtermino;
    }

    public void setFechtermino(Date fechtermino) {
        this.fechtermino = fechtermino;
    }


    public GeneroPelicula getIdgen() {
        return idgen;
    }

    public void setIdgen(GeneroPelicula idgen) {
        this.idgen = idgen;
    }

    @XmlTransient
    public List<VentaEntrada> getVentaEntradaList() {
        return ventaEntradaList;
    }

    public void setVentaEntradaList(List<VentaEntrada> ventaEntradaList) {
        this.ventaEntradaList = ventaEntradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpel != null ? idpel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idpel == null && other.idpel != null) || (this.idpel != null && !this.idpel.equals(other.idpel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pelicula[ idpel=" + idpel + " ]";
    }

}
