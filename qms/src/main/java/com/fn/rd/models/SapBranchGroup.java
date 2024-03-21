package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sap_branch_group database table.
 * 
 */
@Entity
@Table(name="sap_branch_group")
@NamedQuery(name="SapBranchGroup.findAll", query="SELECT s FROM SapBranchGroup s")
public class SapBranchGroup implements Serializable {
	
	// danh sach to nganh
	
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String name;

	private String u_BranchCode;

	private String u_BranchName;

	private String u_FactoryCode;

	private String u_FactoryName;

	private String u_GroupCode;

	private String u_GroupName;

	public SapBranchGroup() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getU_BranchCode() {
		return this.u_BranchCode;
	}

	public void setU_BranchCode(String u_BranchCode) {
		this.u_BranchCode = u_BranchCode;
	}

	public String getU_BranchName() {
		return this.u_BranchName;
	}

	public void setU_BranchName(String u_BranchName) {
		this.u_BranchName = u_BranchName;
	}

	public String getU_FactoryCode() {
		return this.u_FactoryCode;
	}

	public void setU_FactoryCode(String u_FactoryCode) {
		this.u_FactoryCode = u_FactoryCode;
	}

	public String getU_FactoryName() {
		return this.u_FactoryName;
	}

	public void setU_FactoryName(String u_FactoryName) {
		this.u_FactoryName = u_FactoryName;
	}

	public String getU_GroupCode() {
		return this.u_GroupCode;
	}

	public void setU_GroupCode(String u_GroupCode) {
		this.u_GroupCode = u_GroupCode;
	}

	public String getU_GroupName() {
		return this.u_GroupName;
	}

	public void setU_GroupName(String u_GroupName) {
		this.u_GroupName = u_GroupName;
	}

}