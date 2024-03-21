package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DrawNvlImageDTO {
	private Long id;
	private String urlPath;
	private String woId;
	private Date createdAt;
	private String contentFile;
}
