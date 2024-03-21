package com.fn.scada.service;

import com.fn.qms.constant.Constant;
import com.fn.qms.planning.service.ConfigPlaning;
import lombok.Getter;

@Getter
public enum UrlScadaConstant {

	SCADA_GET_TOKEN("/api/auth/login", Constant.POST, "get token"),
	SCADA_GET_ASSETS("/api/tenant/assets?type={type}&pageSize={pageSize}&page={page}&textSearch={textSearch}&sortProperty={sortProperty}&sortOrder={sortOrder}", Constant.GET, "get assets"),
	SCADA_GET_ASSETS_V2("/api/tenant/assetInfos?pageSize={pageSize}&page={page}&sortProperty={sortProperty}&sortOrder={sortOrder}&type={type}",Constant.GET,"get machine info"),
	SCADA_GET_ERROR("/api/plugins/telemetry/{entityType}/{entityId}/keys/attributes",Constant.GET, "get error by machine"),

	SCADA_GET_ASSETS_CONFIG("/publicApis/asset?type={type}&page={page}&pageSize={pageSize}",Constant.GET, ConfigPlaning.SCADA_URL_CONFIG_SERVICE, "get config info"),
	SCADA_GET_ERR_GR_CONFIG("/wrapperApis/plugins/telemetry/{type}/{entityId}/values/attributes/SERVER_SCOPE",Constant.GET,ConfigPlaning.SCADA_URL_CONFIG_SERVICE, "get error gr info"),
	SCADA_GET_DETAIL_WO("/api/plugins/telemetry/{type}/{entityId}/values/timeseries?keys=list_stage,his_list_stage,Status_Wo",Constant.GET,ConfigPlaning.SCADA_URL_SERVICE, "Lấy chi tiết thông tin của wo đang sx trong scada"),
	SCADA_GET_ASSET_BY_NAME("/api/tenant/assets?assetName={entityId}",Constant.GET, "get asset by name"),
	;
	
	private UrlScadaConstant(String url, String method, String desc) {
        this.url = url;
        this.desc = desc;
        this.method = method;
    }

	private UrlScadaConstant(String url, String method, String host , String desc ) {
		this.url = url;
		this.desc = desc;
		this.method = method;
		this.host = host;
	}

    private String url;
    private String desc;
    private String method;
    private String host;
}
