/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC09
 */
@Entity
@Table(name = "COMBO_DETALLE", catalog = "CINE", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComboDetalle.findAll", query = "SELECT c FROM ComboDetalle c")
    , @NamedQuery(name = "ComboDetalle.findByIdcomdet", query = "SELECT c FROM ComboDetalle c WHERE c.idcomdet = :idcomdet")
    , @NamedQuery(name = "ComboDetalle.findByCantpro", query = "SELECT c FROM ComboDetalle c WHERE c.cantpro = :cantpro")})
public class ComboDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCOMDET")
    private Integer idcomdet;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTPRO")
    private int cantpro;
    
    @JoinColumn(name = "IDCOM", referencedColumnName = "IDCOM", nullable = false)
    @ManyToOne(optional = false)
    private Combo idcom;
    
    @JoinColumn(name = "IDPRO", referencedColumnName = "IDPRO", nullable = false)
    @ManyToOne(optional = false)
    private Productos idpro;

    public ComboDetalle() {
    }

    public ComboDetalle(Integer idcomdet) {
        this.idcomdet = idcomdet;
    }

    public ComboDetalle(Integer idcomdet, int cantpro) {
        this.idcomdet = idcomdet;
        this.cantpro = cantpro;
    }

    public Integer getIdcomdet() {
        return idcomdet;
    }

    public void setIdcomdet(Integer idcomdet) {
        this.idcomdet = idcomdet;
    }

    public int getCantpro() {
        return cantpro;
    }

    public void setCantpro(int cantpro) {
        this.cantpro = cantpro;
    }

    public Combo getIdcom() {
        return idcom;
    }

    public void setIdcom(Combo idcom) {
        this.idcom = idcom;
    }

    public Productos getIdpro() {
        return idpro;
    }

    public void setIdpro(Productos idpro) {
        this.idpro = idpro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomdet != null ? idcomdet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComboDetalle)) {
            return false;
        }
        ComboDetalle other = (ComboDetalle) object;
        if ((this.idcomdet == null && other.idcomdet != null) || (this.idcomdet != null && !this.idcomdet.equals(other.idcomdet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ComboDetalle[ idcomdet=" + idcomdet + " ]";
    }
    
}
