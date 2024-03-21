/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.modelsbak;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "owor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owor.findAll", query = "SELECT o FROM Owor o"),
    @NamedQuery(name = "Owor.findByDocEntry", query = "SELECT o FROM Owor o WHERE o.docEntry = :docEntry"),
    @NamedQuery(name = "Owor.findByDocNum", query = "SELECT o FROM Owor o WHERE o.docNum = :docNum"),
    @NamedQuery(name = "Owor.findBySeries", query = "SELECT o FROM Owor o WHERE o.series = :series"),
    @NamedQuery(name = "Owor.findByItemCode", query = "SELECT o FROM Owor o WHERE o.itemCode = :itemCode"),
    @NamedQuery(name = "Owor.findByStatus", query = "SELECT o FROM Owor o WHERE o.status = :status"),
    @NamedQuery(name = "Owor.findByType", query = "SELECT o FROM Owor o WHERE o.type = :type"),
    @NamedQuery(name = "Owor.findByPlannedQty", query = "SELECT o FROM Owor o WHERE o.plannedQty = :plannedQty"),
    @NamedQuery(name = "Owor.findByCmpltQty", query = "SELECT o FROM Owor o WHERE o.cmpltQty = :cmpltQty"),
    @NamedQuery(name = "Owor.findByRjctQty", query = "SELECT o FROM Owor o WHERE o.rjctQty = :rjctQty"),
    @NamedQuery(name = "Owor.findByPostDate", query = "SELECT o FROM Owor o WHERE o.postDate = :postDate"),
    @NamedQuery(name = "Owor.findByDueDate", query = "SELECT o FROM Owor o WHERE o.dueDate = :dueDate"),
    @NamedQuery(name = "Owor.findByOriginAbs", query = "SELECT o FROM Owor o WHERE o.originAbs = :originAbs"),
    @NamedQuery(name = "Owor.findByOriginNum", query = "SELECT o FROM Owor o WHERE o.originNum = :originNum"),
    @NamedQuery(name = "Owor.findByOriginType", query = "SELECT o FROM Owor o WHERE o.originType = :originType"),
    @NamedQuery(name = "Owor.findByUserSign", query = "SELECT o FROM Owor o WHERE o.userSign = :userSign"),
    @NamedQuery(name = "Owor.findByComments", query = "SELECT o FROM Owor o WHERE o.comments = :comments"),
    @NamedQuery(name = "Owor.findByCloseDate", query = "SELECT o FROM Owor o WHERE o.closeDate = :closeDate"),
    @NamedQuery(name = "Owor.findByRlsDate", query = "SELECT o FROM Owor o WHERE o.rlsDate = :rlsDate"),
    @NamedQuery(name = "Owor.findByCardCode", query = "SELECT o FROM Owor o WHERE o.cardCode = :cardCode"),
    @NamedQuery(name = "Owor.findByWarehouse", query = "SELECT o FROM Owor o WHERE o.warehouse = :warehouse"),
    @NamedQuery(name = "Owor.findByUom", query = "SELECT o FROM Owor o WHERE o.uom = :uom"),
    @NamedQuery(name = "Owor.findByLineDirty", query = "SELECT o FROM Owor o WHERE o.lineDirty = :lineDirty"),
    @NamedQuery(name = "Owor.findByWOR1Count", query = "SELECT o FROM Owor o WHERE o.wOR1Count = :wOR1Count"),
    @NamedQuery(name = "Owor.findByJrnlMemo", query = "SELECT o FROM Owor o WHERE o.jrnlMemo = :jrnlMemo"),
    @NamedQuery(name = "Owor.findByTransId", query = "SELECT o FROM Owor o WHERE o.transId = :transId"),
    @NamedQuery(name = "Owor.findByCreateDate", query = "SELECT o FROM Owor o WHERE o.createDate = :createDate"),
    @NamedQuery(name = "Owor.findByPrinted", query = "SELECT o FROM Owor o WHERE o.printed = :printed"),
    @NamedQuery(name = "Owor.findByOcrCode", query = "SELECT o FROM Owor o WHERE o.ocrCode = :ocrCode"),
    @NamedQuery(name = "Owor.findByPIndicator", query = "SELECT o FROM Owor o WHERE o.pIndicator = :pIndicator"),
    @NamedQuery(name = "Owor.findByOcrCode2", query = "SELECT o FROM Owor o WHERE o.ocrCode2 = :ocrCode2"),
    @NamedQuery(name = "Owor.findByOcrCode3", query = "SELECT o FROM Owor o WHERE o.ocrCode3 = :ocrCode3"),
    @NamedQuery(name = "Owor.findByOcrCode4", query = "SELECT o FROM Owor o WHERE o.ocrCode4 = :ocrCode4"),
    @NamedQuery(name = "Owor.findByOcrCode5", query = "SELECT o FROM Owor o WHERE o.ocrCode5 = :ocrCode5"),
    @NamedQuery(name = "Owor.findBySeqCode", query = "SELECT o FROM Owor o WHERE o.seqCode = :seqCode"),
    @NamedQuery(name = "Owor.findBySerial", query = "SELECT o FROM Owor o WHERE o.serial = :serial"),
    @NamedQuery(name = "Owor.findBySeriesStr", query = "SELECT o FROM Owor o WHERE o.seriesStr = :seriesStr"),
    @NamedQuery(name = "Owor.findBySubStr", query = "SELECT o FROM Owor o WHERE o.subStr = :subStr"),
    @NamedQuery(name = "Owor.findByLogInstanc", query = "SELECT o FROM Owor o WHERE o.logInstanc = :logInstanc"),
    @NamedQuery(name = "Owor.findByUserSign2", query = "SELECT o FROM Owor o WHERE o.userSign2 = :userSign2"),
    @NamedQuery(name = "Owor.findByUpdateDate", query = "SELECT o FROM Owor o WHERE o.updateDate = :updateDate"),
    @NamedQuery(name = "Owor.findByProject", query = "SELECT o FROM Owor o WHERE o.project = :project"),
    @NamedQuery(name = "Owor.findBySupplCode", query = "SELECT o FROM Owor o WHERE o.supplCode = :supplCode"),
    @NamedQuery(name = "Owor.findByUomEntry", query = "SELECT o FROM Owor o WHERE o.uomEntry = :uomEntry"),
    @NamedQuery(name = "Owor.findByPickRmrk", query = "SELECT o FROM Owor o WHERE o.pickRmrk = :pickRmrk"),
    @NamedQuery(name = "Owor.findBySysCloseDt", query = "SELECT o FROM Owor o WHERE o.sysCloseDt = :sysCloseDt"),
    @NamedQuery(name = "Owor.findBySysCloseTm", query = "SELECT o FROM Owor o WHERE o.sysCloseTm = :sysCloseTm"),
    @NamedQuery(name = "Owor.findByCloseVerNm", query = "SELECT o FROM Owor o WHERE o.closeVerNm = :closeVerNm"),
    @NamedQuery(name = "Owor.findByStartDate", query = "SELECT o FROM Owor o WHERE o.startDate = :startDate"),
    @NamedQuery(name = "Owor.findByURdcode", query = "SELECT o FROM Owor o WHERE o.uRdcode = :uRdcode"),
    @NamedQuery(name = "Owor.findByUProductCode", query = "SELECT o FROM Owor o WHERE o.uProductCode = :uProductCode"),
    @NamedQuery(name = "Owor.findByUVersion", query = "SELECT o FROM Owor o WHERE o.uVersion = :uVersion"),
    @NamedQuery(name = "Owor.findByUSpec", query = "SELECT o FROM Owor o WHERE o.uSpec = :uSpec")})
public class Owor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DocEntry")
    private Integer docEntry;
    @Basic(optional = false)
    @Column(name = "DocNum")
    private int docNum;
    @Column(name = "Series")
    private Short series;
    @Column(name = "ItemCode")
    private String itemCode;
    @Column(name = "Status")
    private Character status;
    @Column(name = "Type")
    private Character type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PlannedQty")
    private BigDecimal plannedQty;
    @Column(name = "CmpltQty")
    private BigDecimal cmpltQty;
    @Column(name = "RjctQty")
    private BigDecimal rjctQty;
    @Column(name = "PostDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "OriginAbs")
    private Integer originAbs;
    @Column(name = "OriginNum")
    private Integer originNum;
    @Column(name = "OriginType")
    private Character originType;
    @Column(name = "UserSign")
    private Short userSign;
    @Column(name = "Comments")
    private String comments;
    @Column(name = "CloseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;
    @Column(name = "RlsDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rlsDate;
    @Column(name = "CardCode")
    private String cardCode;
    @Column(name = "Warehouse")
    private String warehouse;
    @Column(name = "Uom")
    private String uom;
    @Column(name = "LineDirty")
    private Integer lineDirty;
    @Column(name = "WOR1Count")
    private Integer wOR1Count;
    @Column(name = "JrnlMemo")
    private String jrnlMemo;
    @Column(name = "TransId")
    private Integer transId;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "Printed")
    private Character printed;
    @Column(name = "OcrCode")
    private String ocrCode;
    @Basic(optional = false)
    @Column(name = "PIndicator")
    private String pIndicator;
    @Column(name = "OcrCode2")
    private String ocrCode2;
    @Column(name = "OcrCode3")
    private String ocrCode3;
    @Column(name = "OcrCode4")
    private String ocrCode4;
    @Column(name = "OcrCode5")
    private String ocrCode5;
    @Column(name = "SeqCode")
    private Short seqCode;
    @Column(name = "Serial")
    private Integer serial;
    @Column(name = "SeriesStr")
    private String seriesStr;
    @Column(name = "SubStr")
    private String subStr;
    @Column(name = "LogInstanc")
    private Integer logInstanc;
    @Column(name = "UserSign2")
    private Short userSign2;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "Project")
    private String project;
    @Column(name = "SupplCode")
    private String supplCode;
    @Column(name = "UomEntry")
    private Integer uomEntry;
    @Column(name = "PickRmrk")
    private String pickRmrk;
    @Column(name = "SysCloseDt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysCloseDt;
    @Column(name = "SysCloseTm")
    private Short sysCloseTm;
    @Column(name = "CloseVerNm")
    private String closeVerNm;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "U_RDCODE")
    private String uRdcode;
    @Basic(optional = false)
    @Column(name = "U_ProductCode")
    private String uProductCode;
    @Column(name = "U_Version")
    private String uVersion;
    @Column(name = "U_Spec")
    private String uSpec;
    @Lob
    @Column(name = "U_DocURL")
    private String uDocURL;

    public Owor() {
    }

    public Owor(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Owor(Integer docEntry, int docNum, String pIndicator, String uProductCode) {
        this.docEntry = docEntry;
        this.docNum = docNum;
        this.pIndicator = pIndicator;
        this.uProductCode = uProductCode;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public int getDocNum() {
        return docNum;
    }

    public void setDocNum(int docNum) {
        this.docNum = docNum;
    }

    public Short getSeries() {
        return series;
    }

    public void setSeries(Short series) {
        this.series = series;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public BigDecimal getPlannedQty() {
        return plannedQty;
    }

    public void setPlannedQty(BigDecimal plannedQty) {
        this.plannedQty = plannedQty;
    }

    public BigDecimal getCmpltQty() {
        return cmpltQty;
    }

    public void setCmpltQty(BigDecimal cmpltQty) {
        this.cmpltQty = cmpltQty;
    }

    public BigDecimal getRjctQty() {
        return rjctQty;
    }

    public void setRjctQty(BigDecimal rjctQty) {
        this.rjctQty = rjctQty;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getOriginAbs() {
        return originAbs;
    }

    public void setOriginAbs(Integer originAbs) {
        this.originAbs = originAbs;
    }

    public Integer getOriginNum() {
        return originNum;
    }

    public void setOriginNum(Integer originNum) {
        this.originNum = originNum;
    }

    public Character getOriginType() {
        return originType;
    }

    public void setOriginType(Character originType) {
        this.originType = originType;
    }

    public Short getUserSign() {
        return userSign;
    }

    public void setUserSign(Short userSign) {
        this.userSign = userSign;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getRlsDate() {
        return rlsDate;
    }

    public void setRlsDate(Date rlsDate) {
        this.rlsDate = rlsDate;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Integer getLineDirty() {
        return lineDirty;
    }

    public void setLineDirty(Integer lineDirty) {
        this.lineDirty = lineDirty;
    }

    public Integer getWOR1Count() {
        return wOR1Count;
    }

    public void setWOR1Count(Integer wOR1Count) {
        this.wOR1Count = wOR1Count;
    }

    public String getJrnlMemo() {
        return jrnlMemo;
    }

    public void setJrnlMemo(String jrnlMemo) {
        this.jrnlMemo = jrnlMemo;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getPrinted() {
        return printed;
    }

    public void setPrinted(Character printed) {
        this.printed = printed;
    }

    public String getOcrCode() {
        return ocrCode;
    }

    public void setOcrCode(String ocrCode) {
        this.ocrCode = ocrCode;
    }

    public String getPIndicator() {
        return pIndicator;
    }

    public void setPIndicator(String pIndicator) {
        this.pIndicator = pIndicator;
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

    public Short getSeqCode() {
        return seqCode;
    }

    public void setSeqCode(Short seqCode) {
        this.seqCode = seqCode;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getSeriesStr() {
        return seriesStr;
    }

    public void setSeriesStr(String seriesStr) {
        this.seriesStr = seriesStr;
    }

    public String getSubStr() {
        return subStr;
    }

    public void setSubStr(String subStr) {
        this.subStr = subStr;
    }

    public Integer getLogInstanc() {
        return logInstanc;
    }

    public void setLogInstanc(Integer logInstanc) {
        this.logInstanc = logInstanc;
    }

    public Short getUserSign2() {
        return userSign2;
    }

    public void setUserSign2(Short userSign2) {
        this.userSign2 = userSign2;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSupplCode() {
        return supplCode;
    }

    public void setSupplCode(String supplCode) {
        this.supplCode = supplCode;
    }

    public Integer getUomEntry() {
        return uomEntry;
    }

    public void setUomEntry(Integer uomEntry) {
        this.uomEntry = uomEntry;
    }

    public String getPickRmrk() {
        return pickRmrk;
    }

    public void setPickRmrk(String pickRmrk) {
        this.pickRmrk = pickRmrk;
    }

    public Date getSysCloseDt() {
        return sysCloseDt;
    }

    public void setSysCloseDt(Date sysCloseDt) {
        this.sysCloseDt = sysCloseDt;
    }

    public Short getSysCloseTm() {
        return sysCloseTm;
    }

    public void setSysCloseTm(Short sysCloseTm) {
        this.sysCloseTm = sysCloseTm;
    }

    public String getCloseVerNm() {
        return closeVerNm;
    }

    public void setCloseVerNm(String closeVerNm) {
        this.closeVerNm = closeVerNm;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getURdcode() {
        return uRdcode;
    }

    public void setURdcode(String uRdcode) {
        this.uRdcode = uRdcode;
    }

    public String getUProductCode() {
        return uProductCode;
    }

    public void setUProductCode(String uProductCode) {
        this.uProductCode = uProductCode;
    }

    public String getUVersion() {
        return uVersion;
    }

    public void setUVersion(String uVersion) {
        this.uVersion = uVersion;
    }

    public String getUSpec() {
        return uSpec;
    }

    public void setUSpec(String uSpec) {
        this.uSpec = uSpec;
    }

    public String getUDocURL() {
        return uDocURL;
    }

    public void setUDocURL(String uDocURL) {
        this.uDocURL = uDocURL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docEntry != null ? docEntry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owor)) {
            return false;
        }
        Owor other = (Owor) object;
        if ((this.docEntry == null && other.docEntry != null) || (this.docEntry != null && !this.docEntry.equals(other.docEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Owor[ docEntry=" + docEntry + " ]";
    }
    
}
