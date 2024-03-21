package com.fn.rd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class ErrorDTO {

	private Long id;
	private String name;
	private Long parentId;
	private Integer type;
	private String description;
	private String errorCode;
	
	private List<ErrorDTO> errChild;
		
}
