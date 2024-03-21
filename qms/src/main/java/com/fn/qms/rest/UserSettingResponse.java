package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.rest.bean.MenuRes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSettingResponse extends BaseResponse{
	private List<MenuRes> lstmenu;
}
