package com.fn.qms.bean;

import java.util.UUID;

import com.fn.qms.rest.*;
import com.fn.qms.rest.ProductionStepRequest;

import com.fn.qms.rest.bean.IqcSearchParam;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.rest.iqc.ExaminationRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
	private IqcSearchParam iqcSearchParam;
	
	private String param1;
	private String param2;

	private String requestId;
	private Integer page;
	private Integer size;
	
	private BaseRequest baseRequest;
	
	private ExaminationRequest examinationRequest;
	private ElectronicComponentRequest electronicComponentRequest;
	private ExaminationParamRequest exminationParam;
	private OitmRequest oitmRequest;
	private ErrorListRequest errorListRequest;
	private ProductionStepRequest planningRequest;
	private SapRequest sapRequest;
	
	private ProductionStepRequest productionStepRequest;
	
	private PlanningRequest planningWoRequest;
	private LineRequest lineRequest;
	private MachineRequest machineRequest;
	private Long id;

	public Request() {		
		this.requestId = UUID.randomUUID().toString();
	}
	
	// common
	private String partnerId;
	private String urlPath;
	private String requestContent;
	private String ipAddress;
	private String ipServer;
}
