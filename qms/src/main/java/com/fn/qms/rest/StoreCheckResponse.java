package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.rest.bean.StoreCheck;
import com.fn.qms.rest.bean.StoreCheckElectronic;
import com.fn.qms.rest.bean.StoreCheckErr;
import com.fn.qms.rest.bean.StoreCheckExternalInspection;
import com.fn.qms.rest.bean.StoreCheckSafe;
import com.fn.qms.rest.bean.StoreCheckSize;
import com.fn.qms.rest.bean.StoreCheckStructure;
import com.fn.qms.rest.bean.StorecheckConfused;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreCheckResponse extends BaseResponse{
	public Long id;

	public StoreCheck storeCheck;
	
	public List<StoreCheck> lstCheck;
	
	public List<StoreCheckElectronic> lstElectric;
	
	public List<StoreCheckExternalInspection> lsCheckExternalInspections;
	
	public List<StoreCheckSize> lstSize;
	public List<StoreCheckSafe> lstStoreSafe;
	public List<StorecheckConfused> lstConfuseds ;
	public List<StoreCheckErr> lstCheckErrs ;
	public List<StoreCheckStructure> lstStructures;
	
}
