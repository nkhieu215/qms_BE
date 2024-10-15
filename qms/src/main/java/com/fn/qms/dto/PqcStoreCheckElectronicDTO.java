package com.fn.qms.dto;

import com.fn.qms.rest.bean.StoreCheck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PqcStoreCheckElectronicDTO {	
	private StoreCheck data;
	private Integer maxELECT;
	private Integer maxEXTER;
	private Integer maxSIZE;
	private Integer maxSAFE;
	private Integer maxCONFUSED;
	private Integer maxSTRUCTURE;
}
