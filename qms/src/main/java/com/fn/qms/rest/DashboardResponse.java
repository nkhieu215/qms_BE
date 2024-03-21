package com.fn.qms.rest;

import com.fn.qms.dto.KeyValueDTO;
import com.fn.qms.dto.StepCheckDTO;
import com.fn.qms.dto.WoDTO;
import com.fn.qms.models.IqcElectCompErr;
import com.fn.qms.models.PqcErrorList;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DashboardResponse extends BaseResponse{
	long quantityDemanded; // số lượng sx
	long quantityStore; // số lượng nhập kho
	long quantityStoreSap; // số lượng nhập kho
	long ratioSuccess; // tỷ lệ hoàn thành
	long ratioError; // tỷ lệ lỗi
	long pqcWaitApprove; // lênh PQC chờ duyệt
	long iqcWaitApprove; // lênh IQC chờ duyệt

	long workOrderConcessions; // nhân nhượng
	long workOrderFail; // từ chối
	long workOrderQuality; // đạt

	long iqcQuantity; // sô lượng iqc nhập
	long iqcConcessions; // nhân nhượng
	long iqcFail; // từ chối
	long iqcQuality; // đạt

	long iqcEx; // tong so bien ban iqc
	long iqcVendor; // tog nha cung cap
	long iqcBtpQuantity; // sô lượng iqc btp nhập
	long iqcBtpConcessions; // btp nhân nhượng
	long iqcBtpFail; //btp từ chối
	long iqcBtpQuality; //btp đạt

	List<KeyValueDTO> lstChartError ; // danh sách lỗi theo san pham
	List<KeyValueDTO> lstChartErrorGroup ; // nhom loi
	List<KeyValueDTO> lstIQCStatus ; // danh sach trang thai phe duyet bien ban

}
