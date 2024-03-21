package com.fn.scada.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScadaObjectValue {
	public boolean checked;
	public ScadaAssetsId entityId;
	public String name;
	public String label;
}
