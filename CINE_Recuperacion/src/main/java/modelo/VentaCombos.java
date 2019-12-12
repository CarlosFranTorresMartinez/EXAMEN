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
@Table(name = "VENTA_COMBOS", catalog = "CINE", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaCombos.findAll", query = "SELECT v FROM VentaCombos v")
    , @NamedQuery(name = "VentaCombos.findByIdvencom", query = "SELECT v FROM VentaCombos v WHERE v.idvencom = :idvencom")})
public class VentaCombos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idvencom;
    @JoinColumn(name = "IDCOM", referencedColumnName = "IDCOM", nullable = false)
    @ManyToOne(optional = false)
    private Combo idcom;
    @JoinColumn(name = "VENTA_IDVENT", referencedColumnName = "IDVENT", nullable = false)
    @ManyToOne(optional = false)
    private Venta ventaIdvent;

    public VentaCombos() {
    }

    public VentaCombos(Integer idvencom) {
        this.idvencom = idvencom;
    }

    public Integer getIdvencom() {
        return idvencom;
    }

    public void setIdvencom(Integer idvencom) {
        this.idvencom = idvencom;
    }

    public Combo getIdcom() {
        return idcom;
    }

    public void setIdcom(Combo idcom) {
        this.idcom = idcom;
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
        hash += (idvencom != null ? idvencom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCombos)) {
            return false;
        }
        VentaCombos other = (VentaCombos) object;
        if ((this.idvencom == null && other.idvencom != null) || (this.idvencom != null && !this.idvencom.equals(other.idvencom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VentaCombos[ idvencom=" + idvencom + " ]";
    }
    
}
