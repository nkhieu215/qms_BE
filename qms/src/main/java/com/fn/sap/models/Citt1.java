/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Dong
 */
@Entity
@Table(name = "[@CITT1]")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citt1.findAll", query = "SELECT c FROM Citt1 c"),
    @NamedQuery(name = "Citt1.findByDocEntry", query = "SELECT c FROM Citt1 c WHERE c.citt1PK.docEntry = :docEntry"),
    @NamedQuery(name = "Citt1.findByLineId", query = "SELECT c FROM Citt1 c WHERE c.citt1PK.lineId = :lineId"),
    @NamedQuery(name = "Citt1.findByVisOrder", query = "SELECT c FROM Citt1 c WHERE c.visOrder = :visOrder"),
    @NamedQuery(name = "Citt1.findByObject", query = "SELECT c FROM Citt1 c WHERE c.object = :object"),
    @NamedQuery(name = "Citt1.findByLogInst", query = "SELECT c FROM Citt1 c WHERE c.logInst = :logInst"),
    @NamedQuery(name = "Citt1.findByUType", query = "SELECT c FROM Citt1 c WHERE c.uType = :uType"),
    @NamedQuery(name = "Citt1.findByUItemCode", query = "SELECT c FROM Citt1 c WHERE c.uItemCode = :uItemCode"),
    @NamedQuery(name = "Citt1.findByUPartNumber", query = "SELECT c FROM Citt1 c WHERE c.uPartNumber = :uPartNumber"),
    @NamedQuery(name = "Citt1.findByULocation", query = "SELECT c FROM Citt1 c WHERE c.uLocation = :uLocation"),
    @NamedQuery(name = "Citt1.findByUItemName", query = "SELECT c FROM Citt1 c WHERE c.uItemName = :uItemName"),
    @NamedQuery(name = "Citt1.findByUWhsCod", query = "SELECT c FROM Citt1 c WHERE c.uWhsCod = :uWhsCod"),
    @NamedQuery(name = "Citt1.findByUQuantity", query = "SELECT c FROM Citt1 c WHERE c.uQuantity = :uQuantity"),
    @NamedQuery(name = "Citt1.findByUIssue", query = "SELECT c FROM Citt1 c WHERE c.uIssue = :uIssue"),
    @NamedQuery(name = "Citt1.findByURemarks", query = "SELECT c FROM Citt1 c WHERE c.uRemarks = :uRemarks"),
    @NamedQuery(name = "Citt1.findByUVersions", query = "SELECT c FROM Citt1 c WHERE c.uVersions = :uVersions"),
    @NamedQuery(name = "Citt1.findByUDocEntry", query = "SELECT c FROM Citt1 c WHERE c.uDocEntry = :uDocEntry"),
    @NamedQuery(name = "Citt1.findByUVendor", query = "SELECT c FROM Citt1 c WHERE c.uVendor = :uVendor"),
    @NamedQuery(name = "Citt1.findByUCtrLevel", query = "SELECT c FROM Citt1 c WHERE c.uCtrLevel = :uCtrLevel"),
    @NamedQuery(name = "Citt1.findByUOtherNam", query = "SELECT c FROM Citt1 c WHERE c.uOtherNam = :uOtherNam"),
    @NamedQuery(name = "Citt1.findByUSelect", query = "SELECT c FROM Citt1 c WHERE c.uSelect = :uSelect"),
    @NamedQuery(name = "Citt1.findByUUom", query = "SELECT c FROM Citt1 c WHERE c.uUom = :uUom"),
    @NamedQuery(name = "Citt1.findByUSlect", query = "SELECT c FROM Citt1 c WHERE c.uSlect = :uSlect"),
    @NamedQuery(name = "Citt1.findByUAlter", query = "SELECT c FROM Citt1 c WHERE c.uAlter = :uAlter")})
public class Citt1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected com.fn.sap.models.Citt1PK citt1PK;
    @Column(name = "VisOrder")
    private Integer visOrder;
    @Column(name = "Object")
    private String object;
    @Column(name = "LogInst")
    private Integer logInst;
    @Basic(optional = false)
    @Column(name = "U_Type")
    private String uType;
    @Column(name = "U_ItemCode")
    private String uItemCode;
    @Column(name = "U_PartNumber")
    private String uPartNumber;
    @Column(name = "U_Location")
    private String uLocation;
    @Column(name = "U_ItemName")
    private String uItemName;
    @Column(name = "U_WhsCod")
    private String uWhsCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "U_Quantity")
    private BigDecimal uQuantity;
    @Basic(optional = false)
    @Column(name = "U_Issue")
    private String uIssue;
    @Column(name = "U_Remarks")
    private String uRemarks;
    @Column(name = "U_Versions")
    private String uVersions;
    @Column(name = "U_DocEntry")
    private Integer uDocEntry;
    @Column(name = "U_Vendor")
    private String uVendor;
    @Column(name = "U_CtrLevel")
    private String uCtrLevel;
    @Column(name = "U_OtherNam")
    private String uOtherNam;
    @Column(name = "U_Select")
    private String uSelect;
    @Column(name = "U_Uom")
    private String uUom;
    @Column(name = "U_Slect")
    private String uSlect;
    @Column(name = "U_Alter")
    private String uAlter;
    @Lob
    @Column(name = "U_ItmTech")
    private String uItmTech;

	//
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "DocEntry", insertable = false, updatable = false)
//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	private com.fn.sap.models.Coitt coitt;
//
//
//
//    public com.fn.sap.models.Coitt getCoitt() {
//		return coitt;
//	}
//
//	public void setCoitt(Coitt coitt) {
//		this.coitt = coitt;
//	}

	public Citt1() {
    }

    public Citt1(com.fn.sap.models.Citt1PK citt1PK) {
        this.citt1PK = citt1PK;
    }

    public Citt1(com.fn.sap.models.Citt1PK citt1PK, String uType, BigDecimal uQuantity, String uIssue) {
        this.citt1PK = citt1PK;
        this.uType = uType;
        this.uQuantity = uQuantity;
        this.uIssue = uIssue;
    }

    public Citt1(int docEntry, int lineId) {
        this.citt1PK = new com.fn.sap.models.Citt1PK(docEntry, lineId);
    }

    public com.fn.sap.models.Citt1PK getCitt1PK() {
        return citt1PK;
    }

    public void setCitt1PK(Citt1PK citt1PK) {
        this.citt1PK = citt1PK;
    }

    public Integer getVisOrder() {
        return visOrder;
    }

    public void setVisOrder(Integer visOrder) {
        this.visOrder = visOrder;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getLogInst() {
        return logInst;
    }

    public void setLogInst(Integer logInst) {
        this.logInst = logInst;
    }

    public String getUType() {
        return uType;
    }

    public void setUType(String uType) {
        this.uType = uType;
    }

    public String getUItemCode() {
        return uItemCode;
    }

    public void setUItemCode(String uItemCode) {
        this.uItemCode = uItemCode;
    }

    public String getUPartNumber() {
        return uPartNumber;
    }

    public void setUPartNumber(String uPartNumber) {
        this.uPartNumber = uPartNumber;
    }

    public String getULocation() {
        return uLocation;
    }

    public void setULocation(String uLocation) {
        this.uLocation = uLocation;
    }

    public String getUItemName() {
        return uItemName;
    }

    public void setUItemName(String uItemName) {
        this.uItemName = uItemName;
    }

    public String getUWhsCod() {
        return uWhsCod;
    }

    public void setUWhsCod(String uWhsCod) {
        this.uWhsCod = uWhsCod;
    }

    public BigDecimal getUQuantity() {
        return uQuantity;
    }

    public void setUQuantity(BigDecimal uQuantity) {
        this.uQuantity = uQuantity;
    }

    public String getUIssue() {
        return uIssue;
    }

    public void setUIssue(String uIssue) {
        this.uIssue = uIssue;
    }

    public String getURemarks() {
        return uRemarks;
    }

    public void setURemarks(String uRemarks) {
        this.uRemarks = uRemarks;
    }

    public String getUVersions() {
        return uVersions;
    }

    public void setUVersions(String uVersions) {
        this.uVersions = uVersions;
    }

    public Integer getUDocEntry() {
        return uDocEntry;
    }

    public void setUDocEntry(Integer uDocEntry) {
        this.uDocEntry = uDocEntry;
    }

    public String getUVendor() {
        return uVendor;
    }

    public void setUVendor(String uVendor) {
        this.uVendor = uVendor;
    }

    public String getUCtrLevel() {
        return uCtrLevel;
    }

    public void setUCtrLevel(String uCtrLevel) {
        this.uCtrLevel = uCtrLevel;
    }

    public String getUOtherNam() {
        return uOtherNam;
    }

    public void setUOtherNam(String uOtherNam) {
        this.uOtherNam = uOtherNam;
    }

    public String getUSelect() {
        return uSelect;
    }

    public void setUSelect(String uSelect) {
        this.uSelect = uSelect;
    }

    public String getUUom() {
        return uUom;
    }

    public void setUUom(String uUom) {
        this.uUom = uUom;
    }

    public String getUSlect() {
        return uSlect;
    }

    public void setUSlect(String uSlect) {
        this.uSlect = uSlect;
    }

    public String getUAlter() {
        return uAlter;
    }

    public void setUAlter(String uAlter) {
        this.uAlter = uAlter;
    }

    public String getUItmTech() {
        return uItmTech;
    }

    public void setUItmTech(String uItmTech) {
        this.uItmTech = uItmTech;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citt1PK != null ? citt1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citt1)) {
            return false;
        }
        Citt1 other = (Citt1) object;
        if ((this.citt1PK == null && other.citt1PK != null) || (this.citt1PK != null && !this.citt1PK.equals(other.citt1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Citt1[ citt1PK=" + citt1PK + " ]";
    }
    
}
