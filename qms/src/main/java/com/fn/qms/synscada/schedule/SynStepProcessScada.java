package com.fn.qms.synscada.schedule;

import com.fn.qms.models.StepProcess;
import com.fn.qms.planning.service.UrlPlanningConstant;
import com.fn.qms.repository.StepProcessRepository;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.qms.rest.ScadaAssetsRequest;
import com.fn.qms.rest.ScadaResponse;
import com.fn.scada.service.ScadaService;
import com.fn.qms.utils.AppLog;
import com.fn.scada.service.UrlScadaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SynStepProcessScada {
	
	@Autowired
	ScadaService scadaService;

	@Autowired
	StepProcessRepository stepProcessRepository;

	@Scheduled(cron = "${schedule.sync.scada.sync.stepprocess}", zone = "Asia/Saigon")
	public void syncErrorScada() {	
		AppLog.info("sync");
		scadaService.getErrorLstScada();

		ScadaAssetsRequest input = new ScadaAssetsRequest();
		input.setPage(0);
		input.setPageSize(1000);
		input.setSortOrder("DESC");
		input.setSortProperty("createdTime");
		input.setType("stage");
		ScadaResponse lineLst = scadaService.getByType(input, UrlScadaConstant.SCADA_GET_ASSETS_CONFIG);

		if(lineLst != null && lineLst.getData() != null && !lineLst.getData().isEmpty()){

			StepProcess stepProcess;
			for (ScadaAssetsData asset: lineLst.getData()) {
				// check by id
				stepProcess = stepProcessRepository.findByIdStage(asset.getId().getId());
				if(stepProcess == null){
					stepProcess = new StepProcess();
					stepProcess.setIdStage(asset.getId().getId());
				}
				stepProcess.setLabel(asset.getLabel());
				stepProcess.setType(asset.getType());
				stepProcess.setName(asset.getName());
				stepProcess.setDescription(asset.getAdditionalInfo() != null ? asset.getAdditionalInfo().getDescription() : "");
				stepProcess.setCreatedBy("SYNC");
				stepProcessRepository.save(stepProcess);
			}
		}
	}
}
