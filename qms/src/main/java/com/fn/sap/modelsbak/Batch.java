/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dong
 */
@Entity
@Table(name = "batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batch.findAll", query = "SELECT b FROM Batch b"),
    @NamedQuery(name = "Batch.findByCode", query = "SELECT b FROM Batch b WHERE b.code = :code"),
    @NamedQuery(name = "Batch.findByName", query = "SELECT b FROM Batch b WHERE b.name = :name"),
    @NamedQuery(name = "Batch.findByUProduction", query = "SELECT b FROM Batch b WHERE b.uProduction = :uProduction"),
    @NamedQuery(name = "Batch.findByUDChuyen", query = "SELECT b FROM Batch b WHERE b.uDChuyen = :uDChuyen"),
    @NamedQuery(name = "Batch.findByUDate", query = "SELECT b FROM Batch b WHERE b.uDate = :uDate")})
public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "U_Production")
    private Integer uProduction;
    @Column(name = "U_DChuyen")
    private String uDChuyen;
    @Column(name = "U_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uDate;

    public Batch() {
    }

    public Batch(String code) {
        this.code = code;
    }

    public Batch(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUProduction() {
        return uProduction;
    }

    public void setUProduction(Integer uProduction) {
        this.uProduction = uProduction;
    }

    public String getUDChuyen() {
        return uDChuyen;
    }

    public void setUDChuyen(String uDChuyen) {
        this.uDChuyen = uDChuyen;
    }

    public Date getUDate() {
        return uDate;
    }

    public void setUDate(Date uDate) {
        this.uDate = uDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Batch[ code=" + code + " ]";
    }
    
}
