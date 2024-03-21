package com.fn.qms.dto;

import com.fn.qms.rest.bean.StoreCheckElectronic;
import com.fn.qms.rest.bean.StoreCheckErr;
import com.fn.qms.rest.bean.StoreCheckExternalInspection;
import com.fn.qms.rest.bean.StoreCheckSafe;
import com.fn.qms.rest.bean.StoreCheckSize;
import com.fn.qms.rest.bean.StoreCheckStructure;
import com.fn.qms.rest.bean.StorecheckConfused;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataCheck {


	private StoreCheckElectronic electric;

	public StoreCheckExternalInspection externalInspections;
	public List<StoreCheckExternalInspection> lstexternalInspections;

	public StoreCheckSize size;
	public StoreCheckSafe safe;
	public StorecheckConfused confused;
	public StoreCheckErr checkErr;
	public StoreCheckStructure structure;

}
