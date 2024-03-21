package com.fn.qms.planning.service;

import com.fn.qms.constant.Constant;

import lombok.Getter;

@Getter
public enum UrlPlanningConstant {

	GET_TOKEN("/oauth/token", Constant.POST, "get token"),
	PLANNING_WORK_ORDER("/rest/entities/PlanningWorkOrder/search", Constant.POST, "get all work order"),
	PLANNING_WORK_ORDER_COUNT("/rest/entities/PlanningWorkOrder/search/count", Constant.POST, "get all work order"),
	PLANNING_WORK_ORDER_DETAIL("/rest/entities/PlanningWorkOrder/{id}", Constant.GET, "get all work order"),
	PLANNING_WORK_ORDER_USER("/rest/entities/WorkOrderStage/search", Constant.POST, "get all user by work order"),
	PLANNING_GET_PERMISSION("/rest/permissions", Constant.GET, "get all permissions"),
	PLANNING_UPDATE_WORK_ORDER_STORE("/services/api/workorder/updateOutQuantityQms?planningWOID={wo}&quantityUpdate={quantity}&mode={mode}&updateOutQuantityId={updateId}", Constant.PUT, "update store planing"),
	DETAIL_PROFILE("/rest/entities/Profile/{id}?fetchPlan=with-all", Constant.GET, "get all user by work order"),
	DETAIL_PROFILE_v2("/services/api/programing/getPartNumberDetail?profileId={id}", Constant.GET, "get all user by work order"),

//	DETAIL_PROFILE_BY_WO("/services/api/dnlvnl/qms-json-data/{id}", Constant.GET, "get all user by work order id"),
	DETAIL_PROFILE_BY_WO("/services/api/dnlnvl/qms-view-doi-chieu-nvl/{id}", Constant.GET, "get all user by work order id"),

	LST_PROFILE("/rest/entities/Profile", Constant.GET, "get all user by work order"),
	SCADA_GET_TOKEN("/api/auth/login", Constant.POST, "get token"),
	SCADA_GET_ASSETS("/api/tenant/assets?type={type}&pageSize={pageSize}&page={page}&textSearch={textSearch}&sortProperty={sortProperty}&sortOrder={sortOrder}", Constant.GET, "get assets"),
	SCADA_GET_ASSETS_V2("/api/tenant/assetInfos?pageSize={pageSize}&page={page}&sortProperty={sortProperty}&sortOrder={sortOrder}&type={type}",Constant.GET,"get machine info"),
	SCADA_GET_ERROR("/api/plugins/telemetry/{entityType}/{entityId}/keys/attributes",Constant.GET, "get error by machine"),


	SCADA_GET_ASSETS_CONFIG("/publicApis/asset?type={type}&page={page}&pageSize={pageSize}",Constant.GET,ConfigPlaning.SCADA_URL_CONFIG_SERVICE, "get config info"),
	SCADA_GET_ERR_GR_CONFIG("/wrapperApis/plugins/telemetry/{type}/{entityId}/values/attributes/SERVER_SCOPE",Constant.GET,ConfigPlaning.SCADA_URL_CONFIG_SERVICE, "get error gr info"),
	SCADA_GET_ASSET_BY_NAME("/api/tenant/assets?assetName={entityId}",Constant.GET, "get asset by name"),
	;
	
	private UrlPlanningConstant(String url, String method, String desc) {
        this.url = url;
        this.desc = desc;
        this.method = method;
    }

	private UrlPlanningConstant(String url, String method, String host , String desc ) {
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
