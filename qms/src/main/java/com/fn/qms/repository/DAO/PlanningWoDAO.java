package com.fn.qms.repository.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.constant.Constant;
import com.fn.qms.models.PqcWorkOrderPlanning;
import com.fn.qms.repository.PlanningWoRepository;

@Service
public class PlanningWoDAO {

	@Autowired
	PlanningWoRepository repository;

	public Page<PqcWorkOrderPlanning> searchOitmByCode(String productName, String productCode, String woId, int page,int size) {		
		return repository.findList(productName, productCode, woId, PageRequest.of(page, size));
	}

	/**
	 * save planing send
	 * @param planning
	 */
	public void saveList(List<PqcWorkOrderPlanning> planning) {
		
		if(planning != null && !planning.isEmpty()) {
			for (PqcWorkOrderPlanning pqcWorkOrderPlanning : planning) {
				pqcWorkOrderPlanning.setStatus(Constant.PLANNING);
				repository.save(pqcWorkOrderPlanning);
			}
		}
	}
}
