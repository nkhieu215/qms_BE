package com.fn.qms.synscada.schedule;

import com.fn.qms.models.SettingLine;
import com.fn.qms.repository.SettingLineRepository;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.qms.rest.ScadaAssetsRequest;
import com.fn.qms.rest.ScadaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fn.scada.service.ScadaService;
import com.fn.qms.utils.AppLog;

@Component
public class SynLineScada {
	
	@Autowired
	ScadaService scadaService;

	@Autowired
	SettingLineRepository settingLineRepository;

	@Scheduled(cron = "${schedule.sync.scada.sync.line}", zone = "Asia/Saigon")
	public void syncErrorScada() {	
		AppLog.info("sync");
		scadaService.getErrorLstScada();

		ScadaAssetsRequest input = new ScadaAssetsRequest();
		input.setPage(0);
		input.setPageSize(500);
		input.setSortOrder("DESC");
		input.setSortProperty("createdTime");
		input.setType("line");
		ScadaResponse lineLst = scadaService.getByType(input);
		if(lineLst != null && lineLst.getData() != null && !lineLst.getData().isEmpty()){

			// delete old
			settingLineRepository.deleteSettingLineBySource("SYNC");

			SettingLine line;
			for (ScadaAssetsData asset: lineLst.getData()) {
				line = new SettingLine();
				line.setIdScada(asset.getId().getId());
				line.setName(asset.getLabel());
				line.setCode(asset.getName());
				line.setDescription(asset.getAdditionalInfo().getDescription());
				line.setSource("SYNC");
				settingLineRepository.save(line);
			}
		}
	}
}
