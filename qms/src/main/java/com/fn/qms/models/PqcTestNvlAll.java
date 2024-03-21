package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pqc_test_nvl_all database table.
 * 
 */
@Entity
@Table(name="pqc_test_nvl_all")
@NamedQuery(name="PqcTestNvlAll.findAll", query="SELECT p FROM PqcTestNvlAll p")
public class PqcTestNvlAll implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_nvl_id")
	private int testNvlId;

	@Column(name="chain_code_detail")
	private String chainCodeDetail;

	@Column(name="chain_code_detal_qr_scan2")
	private int chainCodeDetalQrScan2;

	@Column(name="feeder_code")
	private String feederCode;

	@Column(name="item_code")
	private String itemCode;

	@Column(name="item_name")
	private String itemName;

	private String lot;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="manufacture_date")
	private Date manufactureDate;

	@Column(name="part_number")
	private String partNumber;

	@Column(name="po_code")
	private String poCode;

	@Column(name="profile_id")
	private int profileId;

	private String qty;

	@Column(name="rank_ap")
	private String rankAp;

	@Column(name="rank_mau")
	private String rankMau;

	@Column(name="rank_quang")
	private String rankQuang;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="scan_time")
	private Date scanTime;

	private byte[] status;

	@Column(name="technical_para")
	private String technicalPara;

	private String vendor;

	@Column(name="work_order_id")
	private int workOrderId;

	public PqcTestNvlAll() {
	}

	public int getTestNvlId() {
		return this.testNvlId;
	}

	public void setTestNvlId(int testNvlId) {
		this.testNvlId = testNvlId;
	}

	public String getChainCodeDetail() {
		return this.chainCodeDetail;
	}

	public void setChainCodeDetail(String chainCodeDetail) {
		this.chainCodeDetail = chainCodeDetail;
	}

	public int getChainCodeDetalQrScan2() {
		return this.chainCodeDetalQrScan2;
	}

	public void setChainCodeDetalQrScan2(int chainCodeDetalQrScan2) {
		this.chainCodeDetalQrScan2 = chainCodeDetalQrScan2;
	}

	public String getFeederCode() {
		return this.feederCode;
	}

	public void setFeederCode(String feederCode) {
		this.feederCode = feederCode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLot() {
		return this.lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPoCode() {
		return this.poCode;
	}

	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getQty() {
		return this.qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getRankAp() {
		return this.rankAp;
	}

	public void setRankAp(String rankAp) {
		this.rankAp = rankAp;
	}

	public String getRankMau() {
		return this.rankMau;
	}

	public void setRankMau(String rankMau) {
		this.rankMau = rankMau;
	}

	public String getRankQuang() {
		return this.rankQuang;
	}

	public void setRankQuang(String rankQuang) {
		this.rankQuang = rankQuang;
	}

	public Date getScanTime() {
		return this.scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}

	public byte[] getStatus() {
		return this.status;
	}

	public void setStatus(byte[] status) {
		this.status = status;
	}

	public String getTechnicalPara() {
		return this.technicalPara;
	}

	public void setTechnicalPara(String technicalPara) {
		this.technicalPara = technicalPara;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getWorkOrderId() {
		return this.workOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		this.workOrderId = workOrderId;
	}

}