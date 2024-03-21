package com.fn.scada.dto;

import com.fn.qms.rest.AdditionalInfo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ScadaAssetsData {

	ScadaAssetsId id;
	ScadaAssetsId tenantId;
	ScadaAssetsId customerId;
	AdditionalInfo additionalInfo;
	String name;
	String type;
	String label;

}
