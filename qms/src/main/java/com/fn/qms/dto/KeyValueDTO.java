package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KeyValueDTO {
	public String type;
	public String value;
	public Long id;

	public KeyValueDTO(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public KeyValueDTO() {

	}
}
