package com.fn.qms.rest.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorListBean {
	
	private Long id;	
	private String name;
	private String parentId;
	private Integer type;	
	private String description;
	private String errorCode;
	
	private List<ErrorListBean> lstBean;
}
