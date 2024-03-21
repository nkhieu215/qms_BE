package com.fn.qms.bean;

public enum ResponseCode {
	NULL("GW-1", "is null"),
	UNKNOWN("GW999", "Transaction fail"),
	TRANSACTION_FAIL("GW999", "Transaction fail"), 
	SUCCESS("00", "Success"),
	EXAMINATION_CODE_UNIQUEUE("01", "Mã mẫu biên bản đã tồn tại"), 
	INVALID_INPUT("02", "Thông tin đầu vào không hợp lệ"), 
	STATUS_APPROVE_INVALID("03", "Trạng thái phê duyệt không hợp lệ"), 
	STATUS_INVALID("04", "Trạng thái không hợp lệ"), 
	WO_INVALID("05", "Trạng thái không hợp lệ"),
	STORE_SEND_APPROVE_INVALID("06", "Thông tin yêu cầu không hợp lệ hoặc đang chờ phê duyệt."),
	;

	private String errorCode;
	private String desc;

	public String getErrorCode() {
		return errorCode;
	}

	public String getDesc() {
		return desc;
	}

	private ResponseCode(String errorCode, String desc) {
		this.errorCode = errorCode;
		this.desc = desc;
	}

}
