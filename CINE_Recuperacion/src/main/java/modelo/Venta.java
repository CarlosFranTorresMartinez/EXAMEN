/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdvent", query = "SELECT v FROM Venta v WHERE v.idvent = :idvent")
    , @NamedQuery(name = "Venta.findByFecvent", query = "SELECT v FROM Venta v WHERE v.fecvent = :fecvent")
    , @NamedQuery(name = "Venta.findByTotavent", query = "SELECT v FROM Venta v WHERE v.totavent = :totavent")
    , @NamedQuery(name = "Venta.findByTipvent", query = "SELECT v FROM Venta v WHERE v.tipvent = :tipvent")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idvent;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecvent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal totavent;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character tipvent;
    @JoinColumn(name = "IDPER", referencedColumnName = "IDPER", nullable = false)
    @ManyToOne(optional = false)
    private Personal idper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaIdvent")
    private List<VentaCombos> ventaCombosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaIdvent")
    private List<VentaEntrada> ventaEntradaList;

    public Venta() {
    }

    public Venta(Integer idvent) {
        this.idvent = idvent;
    }

    public Venta(Integer idvent, Date fecvent, BigDecimal totavent, Character tipvent) {
        this.idvent = idvent;
        this.fecvent = fecvent;
        this.totavent = totavent;
        this.tipvent = tipvent;
    }

    public Integer getIdvent() {
        return idvent;
    }

    public void setIdvent(Integer idvent) {
        this.idvent = idvent;
    }

    public Date getFecvent() {
        return fecvent;
    }

    public void setFecvent(Date fecvent) {
        this.fecvent = fecvent;
    }

    public BigDecimal getTotavent() {
        return totavent;
    }

    public void setTotavent(BigDecimal totavent) {
        this.totavent = totavent;
    }

    public Character getTipvent() {
        return tipvent;
    }

    public void setTipvent(Character tipvent) {
        this.tipvent = tipvent;
    }

    public Personal getIdper() {
        return idper;
    }

    public void setIdper(Personal idper) {
        this.idper = idper;
    }

    @XmlTransient
    public List<VentaCombos> getVentaCombosList() {
        return ventaCombosList;
    }

    public void setVentaCombosList(List<VentaCombos> ventaCombosList) {
        this.ventaCombosList = ventaCombosList;
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
        hash += (idvent != null ? idvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idvent == null && other.idvent != null) || (this.idvent != null && !this.idvent.equals(other.idvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ idvent=" + idvent + " ]";
    }
    
}
