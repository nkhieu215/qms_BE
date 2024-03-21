package com.fn.qms.constant;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {

	public static final String CHARSET_UTF8 = "UTF-8";

	public static final String ACTION_BROWS_ALL = "BROWS_ALL";
	public static final String ACTION_BROWS = "BROWS";
	public static final String ACTION_EDIT = "EDIT";
	public static final String ACTION_SHOW = "SHOW";
	public static final String ACTION_ADD = "ADD";
	public static final String ACTION_DELETE = "DELETE";
	public static final String ACTION_SEARCH = "SEARCH";
	public static final String ACTION_APPROVE = "APPROVE";
	public static final String ACTION_CONCESSIONS = "CONCESSIONS"; // nhân nhượng
	public static final String LST_APPROVE = "LST_APPROVE";
	public static final String REPORT = "REPORT";
	public static final String ACTION_WAIT_APPROVE = "WAIT_APPROVE";
	public static final Integer EXAMINATION_TYPE_NVL = 1;
	public static final Integer EXAMINATION_TYPE_LKDT = 2;
	public static final Integer EXAMINATION_TYPE_KTSP = 3;
	public static final String SUCCESS = "SUCCESS";

	// method request method
	public static final String POST = "POST";
	public static final String GET = "GET";
	public static final String PUT = "PUT";
	public static final String ESB_ERROR_CODE = "ES";
	public static final String DELETE = "DELETE";
	public final static String DATA_JSON = "data";	
	
	// iqc constant
	public static final String IQC_STATUS_DRAFF = "DRAFF";
	public static final String IQC_STATUS_APPROVE = "APPROVE";
	public static final String IQC_STATUS_CONCESSIONS = "CONCESSIONS";
	public static final String IQC_STATUS_WAIT_APPROVE = "WAIT_APPROVE";
	
	// pqc status
	public static final String WAIT = "WAIT";
	public static final String DRAFF = "DRAFF";
	public static final String REJECT = "REJECT";
	public static final String CANCEL = "CANCEL";
	public static final String FINISH = "FINISH";
	public static final String PLANNING = "PLANNING";	
	
	//planning method
	public static final String ACTION_SHOW_STEP = "SHOW_STEP";
	public static final String ACTION_STEP = "ACTION_STEP";
	public static final String ACTION_BROWS_STEP = "ACTION_BROWS_STEP";
	public static final String ACTION_BROWS_ERROR_STEP = "ACTION_BROWS_ERROR_STEP";	
	
	public static final String CHECK_LIST = "CHECK_LIST";	
	public static final String STATUS_CREATE = "CREATE";
	public static final String STATUS_CHECK_LIST = "CHECK_LIST";	
	public static final String ACTION_STEP_1 = "1";	
	
	// step
	public static final String NVL = "NVL";
	public static final String NVL100 = "CHECK_NVL";
	public static final String TIN = "TIN"; // in kem thiec
	public static final String MOUNT_COMPONENTS = "MOUNT_COMPONENTS"; // gan linh kien
	public static final String SOLDER = "SOLDER"; // lo han
	public static final String METAL = "METAL"; // kim loai
	public static final String PLASTIC = "PLASTIC";
	public static final String PAINT = "PAINT"; // son
	public static final String INTERCHANGEABILITY = "INTERCHANGEABILITY"; // son
	public static final String ASSEMBLES = "ASSEMBLES"; // son
	
	public static final String PHOTOELECTRIC = "PHOTOELECTRIC"; // quang dien BTP
	public static final String PHOTOELECTRIC_PRODUCT = "PHOTOELECTRIC_PRODUCT"; // quang dien sp
	public static final String FIX_ERR = "FIX_ERR"; //ktra loi
	
	public static final String STORE_CHECK = "STORE_CHECK"; //ktra nhap kho
	public static final String QC_CHECK = "QC_CHECK"; //danh gia chat luong sp
	public static final String APPROVE_STORE = "APPROVE_STORE"; //duyet nhap kho

	public static final String FOLDER_NVL = "nvl"; //thu muc anh nvl

	// IQC TYPE check
	public static final String TYPE_CHECK_NVL = "NVL";
	public static final String TYPE_CHECK_PARAM = "PARAM";
	public static final String TYPE_CHECK_LKDT = "LKDT";
	public static final String TYPE_CHECK_ERROR = "ERROR";

	public static String URL_APP_PQC = "";
	public static String URL_APP_IQC = "";

	public static List<String> LST_ACTION =  Arrays.asList("APPROVE","REJECT");
	public static List<String> LST_SEND_APPROVE =  Arrays.asList("DRAFF","REJECT");

	public static String FAIL = "Không đạt";
	public static String Concessions = "Nhân nhượng";
	public static String Quality = "Đạt";
	public static String IQC_UNSATISFACTORY = "Không đạt trả về";
	public static String IQC_CONCESSIONS = "Nhập kho nhân nhượng";

}
