package com.fn.qms.rest.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeederPartNumber {

	String feeder;
	List<String> lstPart;
}
