package com.fn.qms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinCheckSerialDTO {

	private Long id;
	private String checkTime;
	private String checkPerson;
	private String startGia;
	private String endGia;
	private String startKhuay;
	private String endKhuay;
	private List<Serial>lstSerial;
	private Long workOrderId;
	private String serial;
	private String operators;
	private String note;
}
