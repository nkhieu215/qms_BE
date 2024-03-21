package com.fn.qms.planning.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartNumberDetail {

	 public String partNumber;
	 public List<Feeder> qrFeederList;
	 public List<PartNumber> subPartList;
	 public  String lstFeederStr;
	 public String lstSubPartStr;
}
