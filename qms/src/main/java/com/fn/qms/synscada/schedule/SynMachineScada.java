package com.fn.qms.synscada.schedule;

import com.fn.qms.models.StepProcess;
import com.fn.qms.repository.SettingMachineRepository;
import com.fn.qms.repository.StepProcessRepository;
import com.fn.qms.rest.ScadaAssetsRequest;
import com.fn.qms.rest.ScadaResponse;
import com.fn.qms.utils.AppLog;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.scada.service.ScadaService;
import com.fn.scada.service.UrlScadaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.fn.qms.models.SettingMachine;

@Component
public class SynMachineScada {
	
	@Autowired
	ScadaService scadaService;

	@Autowired
	SettingMachineRepository stepProcessRepository;

	@Scheduled(cron = "${schedule.sync.scada.sync.machine}", zone = "Asia/Saigon")
	public void syncErrorScada() {	
		AppLog.info("sync");
		scadaService.getErrorLstScada();

		ScadaAssetsRequest input = new ScadaAssetsRequest();
		input.setPage(0);
		input.setPageSize(1000);
		input.setSortOrder("DESC");
		input.setSortProperty("createdTime");
		input.setType("stage");
		ScadaResponse lineLst = scadaService.getByType(input, UrlScadaConstant.SCADA_GET_ASSETS_V2);
		if(lineLst != null && lineLst.getData() != null && !lineLst.getData().isEmpty()){
			SettingMachine machine;
			for (ScadaAssetsData asset: lineLst.getData()) {
				// check by id
				machine = stepProcessRepository.findByIdStage(asset.getId().getId());
				if(machine == null){
					machine = new SettingMachine();
					machine.setIdScada(asset.getId().getId());
				}
				machine.setName(asset.getLabel());
				machine.setCode(asset.getName());
				machine.setDescription(asset.getAdditionalInfo() != null ? asset.getAdditionalInfo().getDescription() : "");
				stepProcessRepository.save(machine);
			}
		}
	}
}
