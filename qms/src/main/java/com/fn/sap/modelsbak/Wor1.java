/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(name = "wor1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wor1.findAll", query = "SELECT w FROM Wor1 w"),
    @NamedQuery(name = "Wor1.findByDocEntry", query = "SELECT w FROM Wor1 w WHERE w.wor1PK.docEntry = :docEntry"),
    @NamedQuery(name = "Wor1.findByLineNum", query = "SELECT w FROM Wor1 w WHERE w.wor1PK.lineNum = :lineNum"),
    @NamedQuery(name = "Wor1.findByItemCode", query = "SELECT w FROM Wor1 w WHERE w.itemCode = :itemCode"),
    @NamedQuery(name = "Wor1.findByBaseQty", query = "SELECT w FROM Wor1 w WHERE w.baseQty = :baseQty"),
    @NamedQuery(name = "Wor1.findByPlannedQty", query = "SELECT w FROM Wor1 w WHERE w.plannedQty = :plannedQty"),
    @NamedQuery(name = "Wor1.findByIssuedQty", query = "SELECT w FROM Wor1 w WHERE w.issuedQty = :issuedQty"),
    @NamedQuery(name = "Wor1.findByIssueType", query = "SELECT w FROM Wor1 w WHERE w.issueType = :issueType"),
    @NamedQuery(name = "Wor1.findByWareHouse", query = "SELECT w FROM Wor1 w WHERE w.wareHouse = :wareHouse"),
    @NamedQuery(name = "Wor1.findByVisOrder", query = "SELECT w FROM Wor1 w WHERE w.visOrder = :visOrder"),
    @NamedQuery(name = "Wor1.findByWipActCode", query = "SELECT w FROM Wor1 w WHERE w.wipActCode = :wipActCode"),
    @NamedQuery(name = "Wor1.findByCompTotal", query = "SELECT w FROM Wor1 w WHERE w.compTotal = :compTotal"),
    @NamedQuery(name = "Wor1.findByOcrCode", query = "SELECT w FROM Wor1 w WHERE w.ocrCode = :ocrCode"),
    @NamedQuery(name = "Wor1.findByOcrCode2", query = "SELECT w FROM Wor1 w WHERE w.ocrCode2 = :ocrCode2"),
    @NamedQuery(name = "Wor1.findByOcrCode3", query = "SELECT w FROM Wor1 w WHERE w.ocrCode3 = :ocrCode3"),
    @NamedQuery(name = "Wor1.findByOcrCode4", query = "SELECT w FROM Wor1 w WHERE w.ocrCode4 = :ocrCode4"),
    @NamedQuery(name = "Wor1.findByOcrCode5", query = "SELECT w FROM Wor1 w WHERE w.ocrCode5 = :ocrCode5"),
    @NamedQuery(name = "Wor1.findByLocCode", query = "SELECT w FROM Wor1 w WHERE w.locCode = :locCode"),
    @NamedQuery(name = "Wor1.findByLogInstanc", query = "SELECT w FROM Wor1 w WHERE w.logInstanc = :logInstanc"),
    @NamedQuery(name = "Wor1.findByLoadFrBOM", query = "SELECT w FROM Wor1 w WHERE w.loadFrBOM = :loadFrBOM"),
    @NamedQuery(name = "Wor1.findByProject", query = "SELECT w FROM Wor1 w WHERE w.project = :project"),
    @NamedQuery(name = "Wor1.findByUomEntry", query = "SELECT w FROM Wor1 w WHERE w.uomEntry = :uomEntry"),
    @NamedQuery(name = "Wor1.findByUomCode", query = "SELECT w FROM Wor1 w WHERE w.uomCode = :uomCode"),
    @NamedQuery(name = "Wor1.findByItemType", query = "SELECT w FROM Wor1 w WHERE w.itemType = :itemType"),
    @NamedQuery(name = "Wor1.findByAdditQty", query = "SELECT w FROM Wor1 w WHERE w.additQty = :additQty"),
    @NamedQuery(name = "Wor1.findByPickStatus", query = "SELECT w FROM Wor1 w WHERE w.pickStatus = :pickStatus"),
    @NamedQuery(name = "Wor1.findByPickQty", query = "SELECT w FROM Wor1 w WHERE w.pickQty = :pickQty"),
    @NamedQuery(name = "Wor1.findByPickIdNo", query = "SELECT w FROM Wor1 w WHERE w.pickIdNo = :pickIdNo"),
    @NamedQuery(name = "Wor1.findByReleaseQty", query = "SELECT w FROM Wor1 w WHERE w.releaseQty = :releaseQty"),
    @NamedQuery(name = "Wor1.findByResAlloc", query = "SELECT w FROM Wor1 w WHERE w.resAlloc = :resAlloc"),
    @NamedQuery(name = "Wor1.findByStartDate", query = "SELECT w FROM Wor1 w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "Wor1.findByEndDate", query = "SELECT w FROM Wor1 w WHERE w.endDate = :endDate"),
    @NamedQuery(name = "Wor1.findByUstatus", query = "SELECT w FROM Wor1 w WHERE w.ustatus = :ustatus"),
    @NamedQuery(name = "Wor1.findByURdcode", query = "SELECT w FROM Wor1 w WHERE w.uRdcode = :uRdcode"),
    @NamedQuery(name = "Wor1.findByUAlternativeItem", query = "SELECT w FROM Wor1 w WHERE w.uAlternativeItem = :uAlternativeItem"),
    @NamedQuery(name = "Wor1.findByUStockQuantity", query = "SELECT w FROM Wor1 w WHERE w.uStockQuantity = :uStockQuantity"),
    @NamedQuery(name = "Wor1.findByUWip", query = "SELECT w FROM Wor1 w WHERE w.uWip = :uWip"),
    @NamedQuery(name = "Wor1.findByUVersions", query = "SELECT w FROM Wor1 w WHERE w.uVersions = :uVersions"),
    @NamedQuery(name = "Wor1.findByUPartNumber", query = "SELECT w FROM Wor1 w WHERE w.uPartNumber = :uPartNumber"),
    @NamedQuery(name = "Wor1.findByULocation", query = "SELECT w FROM Wor1 w WHERE w.uLocation = :uLocation"),
    @NamedQuery(name = "Wor1.findByUVendor", query = "SELECT w FROM Wor1 w WHERE w.uVendor = :uVendor"),
    @NamedQuery(name = "Wor1.findByUCtrLevel", query = "SELECT w FROM Wor1 w WHERE w.uCtrLevel = :uCtrLevel"),
    @NamedQuery(name = "Wor1.findByUOtherNam", query = "SELECT w FROM Wor1 w WHERE w.uOtherNam = :uOtherNam"),
    @NamedQuery(name = "Wor1.findByURemarks", query = "SELECT w FROM Wor1 w WHERE w.uRemarks = :uRemarks")})
public class Wor1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Wor1PK wor1PK;
    @Column(name = "ItemCode")
    private String itemCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BaseQty")
    private BigDecimal baseQty;
    @Column(name = "PlannedQty")
    private BigDecimal plannedQty;
    @Column(name = "IssuedQty")
    private BigDecimal issuedQty;
    @Column(name = "IssueType")
    private Character issueType;
    @Column(name = "wareHouse")
    private String wareHouse;
    @Column(name = "VisOrder")
    private Integer visOrder;
    @Column(name = "WipActCode")
    private String wipActCode;
    @Column(name = "CompTotal")
    private BigDecimal compTotal;
    @Column(name = "OcrCode")
    private String ocrCode;
    @Column(name = "OcrCode2")
    private String ocrCode2;
    @Column(name = "OcrCode3")
    private String ocrCode3;
    @Column(name = "OcrCode4")
    private String ocrCode4;
    @Column(name = "OcrCode5")
    private String ocrCode5;
    @Column(name = "LocCode")
    private Integer locCode;
    @Column(name = "LogInstanc")
    private Integer logInstanc;
    @Column(name = "LoadFrBOM")
    private Short loadFrBOM;
    @Column(name = "Project")
    private String project;
    @Column(name = "UomEntry")
    private Integer uomEntry;
    @Column(name = "UomCode")
    private String uomCode;
    @Column(name = "ItemType")
    private Integer itemType;
    @Column(name = "AdditQty")
    private BigDecimal additQty;
    @Lob
    @Column(name = "LineText")
    private String lineText;
    @Column(name = "PickStatus")
    private Character pickStatus;
    @Column(name = "PickQty")
    private BigDecimal pickQty;
    @Column(name = "PickIdNo")
    private Integer pickIdNo;
    @Column(name = "ReleaseQty")
    private BigDecimal releaseQty;
    @Column(name = "ResAlloc")
    private Character resAlloc;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "U_status")
    private String ustatus;
    @Column(name = "U_RDCODE")
    private String uRdcode;
    @Column(name = "U_AlternativeItem")
    private String uAlternativeItem;
    @Column(name = "U_StockQuantity")
    private BigDecimal uStockQuantity;
    @Column(name = "U_WIP")
    private BigDecimal uWip;
    @Column(name = "U_Versions")
    private String uVersions;
    @Column(name = "U_PartNumber")
    private String uPartNumber;
    @Column(name = "U_Location")
    private String uLocation;
    @Column(name = "U_Vendor")
    private String uVendor;
    @Column(name = "U_CtrLevel")
    private String uCtrLevel;
    @Column(name = "U_OtherNam")
    private String uOtherNam;
    @Column(name = "U_Remarks")
    private String uRemarks;
    @Lob
    @Column(name = "U_ItmTech")
    private String uItmTech;

    public Wor1() {
    }

    public Wor1(Wor1PK wor1PK) {
        this.wor1PK = wor1PK;
    }

    public Wor1(int docEntry, int lineNum) {
        this.wor1PK = new Wor1PK(docEntry, lineNum);
    }

    public Wor1PK getWor1PK() {
        return wor1PK;
    }

    public void setWor1PK(Wor1PK wor1PK) {
        this.wor1PK = wor1PK;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getBaseQty() {
        return baseQty;
    }

    public void setBaseQty(BigDecimal baseQty) {
        this.baseQty = baseQty;
    }

    public BigDecimal getPlannedQty() {
        return plannedQty;
    }

    public void setPlannedQty(BigDecimal plannedQty) {
        this.plannedQty = plannedQty;
    }

    public BigDecimal getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(BigDecimal issuedQty) {
        this.issuedQty = issuedQty;
    }

    public Character getIssueType() {
        return issueType;
    }

    public void setIssueType(Character issueType) {
        this.issueType = issueType;
    }

    public String getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Integer getVisOrder() {
        return visOrder;
    }

    public void setVisOrder(Integer visOrder) {
        this.visOrder = visOrder;
    }

    public String getWipActCode() {
        return wipActCode;
    }

    public void setWipActCode(String wipActCode) {
        this.wipActCode = wipActCode;
    }

    public BigDecimal getCompTotal() {
        return compTotal;
    }

    public void setCompTotal(BigDecimal compTotal) {
        this.compTotal = compTotal;
    }

    public String getOcrCode() {
        return ocrCode;
    }

    public void setOcrCode(String ocrCode) {
        this.ocrCode = ocrCode;
    }

    public String getOcrCode2() {
        return ocrCode2;
    }

    public void setOcrCode2(String ocrCode2) {
        this.ocrCode2 = ocrCode2;
    }

    public String getOcrCode3() {
        return ocrCode3;
    }

    public void setOcrCode3(String ocrCode3) {
        this.ocrCode3 = ocrCode3;
    }

    public String getOcrCode4() {
        return ocrCode4;
    }

    public void setOcrCode4(String ocrCode4) {
        this.ocrCode4 = ocrCode4;
    }

    public String getOcrCode5() {
        return ocrCode5;
    }

    public void setOcrCode5(String ocrCode5) {
        this.ocrCode5 = ocrCode5;
    }

    public Integer getLocCode() {
        return locCode;
    }

    public void setLocCode(Integer locCode) {
        this.locCode = locCode;
    }

    public Integer getLogInstanc() {
        return logInstanc;
    }

    public void setLogInstanc(Integer logInstanc) {
        this.logInstanc = logInstanc;
    }

    public Short getLoadFrBOM() {
        return loadFrBOM;
    }

    public void setLoadFrBOM(Short loadFrBOM) {
        this.loadFrBOM = loadFrBOM;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getUomEntry() {
        return uomEntry;
    }

    public void setUomEntry(Integer uomEntry) {
        this.uomEntry = uomEntry;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getAdditQty() {
        return additQty;
    }

    public void setAdditQty(BigDecimal additQty) {
        this.additQty = additQty;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    public Character getPickStatus() {
        return pickStatus;
    }

    public void setPickStatus(Character pickStatus) {
        this.pickStatus = pickStatus;
    }

    public BigDecimal getPickQty() {
        return pickQty;
    }

    public void setPickQty(BigDecimal pickQty) {
        this.pickQty = pickQty;
    }

    public Integer getPickIdNo() {
        return pickIdNo;
    }

    public void setPickIdNo(Integer pickIdNo) {
        this.pickIdNo = pickIdNo;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public Character getResAlloc() {
        return resAlloc;
    }

    public void setResAlloc(Character resAlloc) {
        this.resAlloc = resAlloc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public String getURdcode() {
        return uRdcode;
    }

    public void setURdcode(String uRdcode) {
        this.uRdcode = uRdcode;
    }

    public String getUAlternativeItem() {
        return uAlternativeItem;
    }

    public void setUAlternativeItem(String uAlternativeItem) {
        this.uAlternativeItem = uAlternativeItem;
    }

    public BigDecimal getUStockQuantity() {
        return uStockQuantity;
    }

    public void setUStockQuantity(BigDecimal uStockQuantity) {
        this.uStockQuantity = uStockQuantity;
    }

    public BigDecimal getUWip() {
        return uWip;
    }

    public void setUWip(BigDecimal uWip) {
        this.uWip = uWip;
    }

    public String getUVersions() {
        return uVersions;
    }

    public void setUVersions(String uVersions) {
        this.uVersions = uVersions;
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

    public String getURemarks() {
        return uRemarks;
    }

    public void setURemarks(String uRemarks) {
        this.uRemarks = uRemarks;
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
        hash += (wor1PK != null ? wor1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wor1)) {
            return false;
        }
        Wor1 other = (Wor1) object;
        if ((this.wor1PK == null && other.wor1PK != null) || (this.wor1PK != null && !this.wor1PK.equals(other.wor1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Wor1[ wor1PK=" + wor1PK + " ]";
    }
    
}
