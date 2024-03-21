/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dong
 */
@Entity
@Table(name = "sap_branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SapBranch.findAll", query = "SELECT s FROM SapBranch s"),
    @NamedQuery(name = "SapBranch.findByCode", query = "SELECT s FROM SapBranch s WHERE s.code = :code"),
    @NamedQuery(name = "SapBranch.findByName", query = "SELECT s FROM SapBranch s WHERE s.name = :name"),
    @NamedQuery(name = "SapBranch.findByUCostCenter", query = "SELECT s FROM SapBranch s WHERE s.uCostCenter = :uCostCenter"),
    @NamedQuery(name = "SapBranch.findByUCostCenterName", query = "SELECT s FROM SapBranch s WHERE s.uCostCenterName = :uCostCenterName"),
    @NamedQuery(name = "SapBranch.findByUComName", query = "SELECT s FROM SapBranch s WHERE s.uComName = :uComName"),
    @NamedQuery(name = "SapBranch.findByUComAddress", query = "SELECT s FROM SapBranch s WHERE s.uComAddress = :uComAddress"),
    @NamedQuery(name = "SapBranch.findByUComPhone", query = "SELECT s FROM SapBranch s WHERE s.uComPhone = :uComPhone"),
    @NamedQuery(name = "SapBranch.findByUComTax", query = "SELECT s FROM SapBranch s WHERE s.uComTax = :uComTax"),
    @NamedQuery(name = "SapBranch.findByUComCode", query = "SELECT s FROM SapBranch s WHERE s.uComCode = :uComCode"),
    @NamedQuery(name = "SapBranch.findByUHRCode", query = "SELECT s FROM SapBranch s WHERE s.uHRCode = :uHRCode")})
public class SapBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "U_CostCenter")
    private String uCostCenter;
    @Column(name = "U_CostCenterName")
    private String uCostCenterName;
    @Column(name = "U_ComName")
    private String uComName;
    @Column(name = "U_ComAddress")
    private String uComAddress;
    @Column(name = "U_ComPhone")
    private String uComPhone;
    @Column(name = "U_ComTax")
    private String uComTax;
    @Column(name = "U_ComCode")
    private String uComCode;
    @Column(name = "U_HRCode")
    private String uHRCode;

    public SapBranch() {
    }

    public SapBranch(String code) {
        this.code = code;
    }

    public SapBranch(String code, String name) {
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

    public String getUCostCenter() {
        return uCostCenter;
    }

    public void setUCostCenter(String uCostCenter) {
        this.uCostCenter = uCostCenter;
    }

    public String getUCostCenterName() {
        return uCostCenterName;
    }

    public void setUCostCenterName(String uCostCenterName) {
        this.uCostCenterName = uCostCenterName;
    }

    public String getUComName() {
        return uComName;
    }

    public void setUComName(String uComName) {
        this.uComName = uComName;
    }

    public String getUComAddress() {
        return uComAddress;
    }

    public void setUComAddress(String uComAddress) {
        this.uComAddress = uComAddress;
    }

    public String getUComPhone() {
        return uComPhone;
    }

    public void setUComPhone(String uComPhone) {
        this.uComPhone = uComPhone;
    }

    public String getUComTax() {
        return uComTax;
    }

    public void setUComTax(String uComTax) {
        this.uComTax = uComTax;
    }

    public String getUComCode() {
        return uComCode;
    }

    public void setUComCode(String uComCode) {
        this.uComCode = uComCode;
    }

    public String getUHRCode() {
        return uHRCode;
    }

    public void setUHRCode(String uHRCode) {
        this.uHRCode = uHRCode;
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
        if (!(object instanceof SapBranch)) {
            return false;
        }
        SapBranch other = (SapBranch) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.SapBranch[ code=" + code + " ]";
    }
    
}
