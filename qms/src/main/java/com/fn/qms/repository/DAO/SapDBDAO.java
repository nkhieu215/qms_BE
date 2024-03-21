package com.fn.qms.repository.DAO;

import java.util.List;

import com.fn.sap.repository.Citt1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fn.sap.models.Coitt;
import com.fn.sap.repository.CoittRepository;

@Service
public class SapDBDAO {

	@Autowired
	CoittRepository repository;

	@Autowired
	Citt1Repository citt1Repository;

	public List<Coitt> getBomVersionByProductCode(String proCode, String version){
		List<Coitt> lst = 	repository.getBomVersionByProductCode(proCode, version);
		if(lst != null && !lst.isEmpty()){
			for (Coitt coitt:lst) {
				coitt.setLstCitt(citt1Repository.getListByDocEntry(coitt.getDocEntry()));
			}
		}

		return lst;
	}
}
