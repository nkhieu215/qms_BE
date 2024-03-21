package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AqlTemplateDTO {

	private Long id;
	private String testLevel; // muc kiem tra
	private String acceptanceLevel; // muc chap nhan
	private String allowedError; // loi cho phep
	private String note;

	private Integer page;
	private Integer size;
}
