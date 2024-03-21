package com.fn.qms.rest.bean;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRes {
	String name;
	String url;
	String classIcon;
	String permission;
	List<MenuRes> lstChild;
}
