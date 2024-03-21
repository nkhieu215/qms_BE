/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Dong
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fn.sap.models.Citt1;

@Entity
@Table(name = "[@COITT]")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coitt.findAll", query = "SELECT c FROM Coitt c"),
    @NamedQuery(name = "Coitt.findByDocEntry", query = "SELECT c FROM Coitt c WHERE c.docEntry = :docEntry"),
    @NamedQuery(name = "Coitt.findByDocNum", query = "SELECT c FROM Coitt c WHERE c.docNum = :docNum"),
    @NamedQuery(name = "Coitt.findByPeriod", query = "SELECT c FROM Coitt c WHERE c.period = :period"),
    @NamedQuery(name = "Coitt.findByInstance", query = "SELECT c FROM Coitt c WHERE c.instance = :instance"),
    @NamedQuery(name = "Coitt.findBySeries", query = "SELECT c FROM Coitt c WHERE c.series = :series"),
    @NamedQuery(name = "Coitt.findByHandwrtten", query = "SELECT c FROM Coitt c WHERE c.handwrtten = :handwrtten"),
    @NamedQuery(name = "Coitt.findByCanceled", query = "SELECT c FROM Coitt c WHERE c.canceled = :canceled"),
    @NamedQuery(name = "Coitt.findByObject", query = "SELECT c FROM Coitt c WHERE c.object = :object"),
    @NamedQuery(name = "Coitt.findByLogInst", query = "SELECT c FROM Coitt c WHERE c.logInst = :logInst"),
    @NamedQuery(name = "Coitt.findByUserSign", query = "SELECT c FROM Coitt c WHERE c.userSign = :userSign"),
    @NamedQuery(name = "Coitt.findByTransfered", query = "SELECT c FROM Coitt c WHERE c.transfered = :transfered"),
    @NamedQuery(name = "Coitt.findByStatus", query = "SELECT c FROM Coitt c WHERE c.status = :status"),
    @NamedQuery(name = "Coitt.findByCreateDate", query = "SELECT c FROM Coitt c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "Coitt.findByCreateTime", query = "SELECT c FROM Coitt c WHERE c.createTime = :createTime"),
    @NamedQuery(name = "Coitt.findByUpdateDate", query = "SELECT c FROM Coitt c WHERE c.updateDate = :updateDate"),
    @NamedQuery(name = "Coitt.findByUpdateTime", query = "SELECT c FROM Coitt c WHERE c.updateTime = :updateTime"),
    @NamedQuery(name = "Coitt.findByDataSource", query = "SELECT c FROM Coitt c WHERE c.dataSource = :dataSource"),
    @NamedQuery(name = "Coitt.findByRequestStatus", query = "SELECT c FROM Coitt c WHERE c.requestStatus = :requestStatus"),
    @NamedQuery(name = "Coitt.findByCreator", query = "SELECT c FROM Coitt c WHERE c.creator = :creator"),
    @NamedQuery(name = "Coitt.findByUProNo", query = "SELECT c FROM Coitt c WHERE c.uProNo = :uProNo"),
    @NamedQuery(name = "Coitt.findByUProNam", query = "SELECT c FROM Coitt c WHERE c.uProNam = :uProNam"),
    @NamedQuery(name = "Coitt.findByUWhsCod", query = "SELECT c FROM Coitt c WHERE c.uWhsCod = :uWhsCod"),
    @NamedQuery(name = "Coitt.findByUQuantity", query = "SELECT c FROM Coitt c WHERE c.uQuantity = :uQuantity"),
    @NamedQuery(name = "Coitt.findByURemark", query = "SELECT c FROM Coitt c WHERE c.uRemark = :uRemark"),
    @NamedQuery(name = "Coitt.findByUVersions", query = "SELECT c FROM Coitt c WHERE c.uVersions = :uVersions"),
    @NamedQuery(name = "Coitt.findByUSpec", query = "SELECT c FROM Coitt c WHERE c.uSpec = :uSpec"),
    @NamedQuery(name = "Coitt.findByUPrefix", query = "SELECT c FROM Coitt c WHERE c.uPrefix = :uPrefix"),
    @NamedQuery(name = "Coitt.findByUStatus", query = "SELECT c FROM Coitt c WHERE c.uStatus = :uStatus"),
    @NamedQuery(name = "Coitt.findByUUom", query = "SELECT c FROM Coitt c WHERE c.uUom = :uUom"),
    @NamedQuery(name = "Coitt.findByUActive", query = "SELECT c FROM Coitt c WHERE c.uActive = :uActive"),
    @NamedQuery(name = "Coitt.findByUInact", query = "SELECT c FROM Coitt c WHERE c.uInact = :uInact"),
    @NamedQuery(name = "Coitt.findByUFromDate", query = "SELECT c FROM Coitt c WHERE c.uFromDate = :uFromDate"),
    @NamedQuery(name = "Coitt.findByUToDate", query = "SELECT c FROM Coitt c WHERE c.uToDate = :uToDate")})
public class Coitt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DocEntry")
    private Integer docEntry;
    @Column(name = "DocNum")
    private Integer docNum;
    @Column(name = "Period")
    private Integer period;
    @Column(name = "Instance")
    private Short instance;
    @Column(name = "Series")
    private Integer series;
    @Column(name = "Handwrtten")
    private Character handwrtten;
    @Column(name = "Canceled")
    private Character canceled;
    @Column(name = "Object")
    private String object;
    @Column(name = "LogInst")
    private Integer logInst;
    @Column(name = "UserSign")
    private Integer userSign;
    @Column(name = "Transfered")
    private Character transfered;
    @Column(name = "Status")
    private Character status;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "CreateTime")
    private Short createTime;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "UpdateTime")
    private Short updateTime;
    @Column(name = "DataSource")
    private Character dataSource;
    @Column(name = "RequestStatus")
    private Character requestStatus;
    @Column(name = "Creator")
    private String creator;
    @Lob
    @Column(name = "Remark")
    private String remark;
    @Column(name = "U_ProNo")
    private String uProNo;
    @Column(name = "U_ProNam")
    private String uProNam;
    @Column(name = "U_WhsCod")
    private String uWhsCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "U_Quantity")
    private BigDecimal uQuantity;
    @Column(name = "U_Remark")
    private String uRemark;
    @Column(name = "U_Versions")
    private String uVersions;
    @Column(name = "U_Spec")
    private String uSpec;
    @Column(name = "U_Prefix")
    private String uPrefix;
    @Column(name = "U_Status")
    private String uStatus;
    @Column(name = "U_Uom")
    private String uUom;
    @Column(name = "U_Active")
    private String uActive;
    @Column(name = "U_Inact")
    private String uInact;
    @Column(name = "U_FromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uFromDate;
    @Column(name = "U_ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uToDate;
    @Lob
    @Column(name = "U_DocURL")
    private String uDocURL;
    @Lob
    @Column(name = "U_DocURL2")
    private String uDocURL2;

    public String getuDocURL2() {
        return uDocURL2;
    }

    public void setuDocURL2(String uDocURL2) {
        this.uDocURL2 = uDocURL2;
    }

    //    @JsonIgnoreProperties({ "coitt" })
//    @OneToMany(mappedBy = "coitt", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Transient
    List<Citt1> lstCitt;
    
    
    public List<Citt1> getLstCitt() {
		return lstCitt;
	}

	public void setLstCitt(List<Citt1> lstCitt) {
		this.lstCitt = lstCitt;
	}

	public Coitt() {
    }

    public Coitt(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Coitt(Integer docEntry, BigDecimal uQuantity) {
        this.docEntry = docEntry;
        this.uQuantity = uQuantity;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Short getInstance() {
        return instance;
    }

    public void setInstance(Short instance) {
        this.instance = instance;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Character getHandwrtten() {
        return handwrtten;
    }

    public void setHandwrtten(Character handwrtten) {
        this.handwrtten = handwrtten;
    }

    public Character getCanceled() {
        return canceled;
    }

    public void setCanceled(Character canceled) {
        this.canceled = canceled;
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

    public Integer getUserSign() {
        return userSign;
    }

    public void setUserSign(Integer userSign) {
        this.userSign = userSign;
    }

    public Character getTransfered() {
        return transfered;
    }

    public void setTransfered(Character transfered) {
        this.transfered = transfered;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Short getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Short createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Short updateTime) {
        this.updateTime = updateTime;
    }

    public Character getDataSource() {
        return dataSource;
    }

    public void setDataSource(Character dataSource) {
        this.dataSource = dataSource;
    }

    public Character getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Character requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUProNo() {
        return uProNo;
    }

    public void setUProNo(String uProNo) {
        this.uProNo = uProNo;
    }

    public String getUProNam() {
        return uProNam;
    }

    public void setUProNam(String uProNam) {
        this.uProNam = uProNam;
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

    public String getURemark() {
        return uRemark;
    }

    public void setURemark(String uRemark) {
        this.uRemark = uRemark;
    }

    public String getUVersions() {
        return uVersions;
    }

    public void setUVersions(String uVersions) {
        this.uVersions = uVersions;
    }

    public String getUSpec() {
        return uSpec;
    }

    public void setUSpec(String uSpec) {
        this.uSpec = uSpec;
    }

    public String getUPrefix() {
        return uPrefix;
    }

    public void setUPrefix(String uPrefix) {
        this.uPrefix = uPrefix;
    }

    public String getUStatus() {
        return uStatus;
    }

    public void setUStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getUUom() {
        return uUom;
    }

    public void setUUom(String uUom) {
        this.uUom = uUom;
    }

    public String getUActive() {
        return uActive;
    }

    public void setUActive(String uActive) {
        this.uActive = uActive;
    }

    public String getUInact() {
        return uInact;
    }

    public void setUInact(String uInact) {
        this.uInact = uInact;
    }

    public Date getUFromDate() {
        return uFromDate;
    }

    public void setUFromDate(Date uFromDate) {
        this.uFromDate = uFromDate;
    }

    public Date getUToDate() {
        return uToDate;
    }

    public void setUToDate(Date uToDate) {
        this.uToDate = uToDate;
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
        if (!(object instanceof Coitt)) {
            return false;
        }
        Coitt other = (Coitt) object;
        if ((this.docEntry == null && other.docEntry != null) || (this.docEntry != null && !this.docEntry.equals(other.docEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Coitt[ docEntry=" + docEntry + " ]";
    }
    
}
