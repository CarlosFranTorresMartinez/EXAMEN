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
@Table(name = "VENTA_ENTRADA", catalog = "CINE", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaEntrada.findAll", query = "SELECT v FROM VentaEntrada v")
    , @NamedQuery(name = "VentaEntrada.findByIdventdet", query = "SELECT v FROM VentaEntrada v WHERE v.idventdet = :idventdet")})
public class VentaEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idventdet;
    @JoinColumn(name = "IDPEL", referencedColumnName = "IDPEL", nullable = false)
    @ManyToOne(optional = false)
    private Pelicula idpel;
    @JoinColumn(name = "VENTA_IDVENT", referencedColumnName = "IDVENT", nullable = false)
    @ManyToOne(optional = false)
    private Venta ventaIdvent;

    public VentaEntrada() {
    }

    public VentaEntrada(Integer idventdet) {
        this.idventdet = idventdet;
    }

    public Integer getIdventdet() {
        return idventdet;
    }

    public void setIdventdet(Integer idventdet) {
        this.idventdet = idventdet;
    }

    public Pelicula getIdpel() {
        return idpel;
    }

    public void setIdpel(Pelicula idpel) {
        this.idpel = idpel;
    }

    public Venta getVentaIdvent() {
        return ventaIdvent;
    }

    public void setVentaIdvent(Venta ventaIdvent) {
        this.ventaIdvent = ventaIdvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventdet != null ? idventdet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaEntrada)) {
            return false;
        }
        VentaEntrada other = (VentaEntrada) object;
        if ((this.idventdet == null && other.idventdet != null) || (this.idventdet != null && !this.idventdet.equals(other.idventdet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VentaEntrada[ idventdet=" + idventdet + " ]";
    }
    
}
