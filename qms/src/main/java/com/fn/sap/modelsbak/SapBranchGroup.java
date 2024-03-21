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
@Table(name = "sap_branch_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SapBranchGroup.findAll", query = "SELECT s FROM SapBranchGroup s"),
    @NamedQuery(name = "SapBranchGroup.findByCode", query = "SELECT s FROM SapBranchGroup s WHERE s.code = :code"),
    @NamedQuery(name = "SapBranchGroup.findByName", query = "SELECT s FROM SapBranchGroup s WHERE s.name = :name"),
    @NamedQuery(name = "SapBranchGroup.findByUBranchCode", query = "SELECT s FROM SapBranchGroup s WHERE s.uBranchCode = :uBranchCode"),
    @NamedQuery(name = "SapBranchGroup.findByUBranchName", query = "SELECT s FROM SapBranchGroup s WHERE s.uBranchName = :uBranchName"),
    @NamedQuery(name = "SapBranchGroup.findByUGroupCode", query = "SELECT s FROM SapBranchGroup s WHERE s.uGroupCode = :uGroupCode"),
    @NamedQuery(name = "SapBranchGroup.findByUGroupName", query = "SELECT s FROM SapBranchGroup s WHERE s.uGroupName = :uGroupName"),
    @NamedQuery(name = "SapBranchGroup.findByUFactoryCode", query = "SELECT s FROM SapBranchGroup s WHERE s.uFactoryCode = :uFactoryCode"),
    @NamedQuery(name = "SapBranchGroup.findByUFactoryName", query = "SELECT s FROM SapBranchGroup s WHERE s.uFactoryName = :uFactoryName")})
public class SapBranchGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "Name")
    private String name;
    @Column(name = "U_BranchCode")
    private String uBranchCode;
    @Column(name = "U_BranchName")
    private String uBranchName;
    @Column(name = "U_GroupCode")
    private String uGroupCode;
    @Column(name = "U_GroupName")
    private String uGroupName;
    @Column(name = "U_FactoryCode")
    private String uFactoryCode;
    @Column(name = "U_FactoryName")
    private String uFactoryName;

    public SapBranchGroup() {
    }

    public SapBranchGroup(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUBranchCode() {
        return uBranchCode;
    }

    public void setUBranchCode(String uBranchCode) {
        this.uBranchCode = uBranchCode;
    }

    public String getUBranchName() {
        return uBranchName;
    }

    public void setUBranchName(String uBranchName) {
        this.uBranchName = uBranchName;
    }

    public String getUGroupCode() {
        return uGroupCode;
    }

    public void setUGroupCode(String uGroupCode) {
        this.uGroupCode = uGroupCode;
    }

    public String getUGroupName() {
        return uGroupName;
    }

    public void setUGroupName(String uGroupName) {
        this.uGroupName = uGroupName;
    }

    public String getUFactoryCode() {
        return uFactoryCode;
    }

    public void setUFactoryCode(String uFactoryCode) {
        this.uFactoryCode = uFactoryCode;
    }

    public String getUFactoryName() {
        return uFactoryName;
    }

    public void setUFactoryName(String uFactoryName) {
        this.uFactoryName = uFactoryName;
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
        if (!(object instanceof SapBranchGroup)) {
            return false;
        }
        SapBranchGroup other = (SapBranchGroup) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.SapBranchGroup[ code=" + code + " ]";
    }
    
}
