package com.fn.qms.repository.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fn.qms.rest.bean.OitmObj;
import com.fn.sap.repository.OitmRepository;

@Service
public class OitmDAO {

	@Autowired
	OitmRepository repository;

	public List<OitmObj> searchOitmByCode(String code){
		
		List<OitmObj> lstOitm =  new ArrayList<OitmObj>();
		
		List<Object[]> lst = 	repository.searchOitmByCode(code);
		if(lst != null) {
			OitmObj oitm;
			for (Object[] objects : lst) {
				oitm = new OitmObj();
				oitm.setItemName((String)objects[0]);
				oitm.setItemCode((String)objects[1]);
				lstOitm.add(oitm);
			}
		}
		return lstOitm;
	}

}
