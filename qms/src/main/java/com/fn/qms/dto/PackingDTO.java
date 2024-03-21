package com.fn.qms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackingDTO {	
	private String packing;
	private String tray;
	private List<String> lstSerial;
	private Long storeId;
	private Long workOrderId;
}
