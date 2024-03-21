package com.fn.qms.repository.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.rest.bean.ErrorListBean;
import com.fn.qms.utils.AppLog;
import com.fn.rd.models.ErrorList;
import com.fn.rd.repository.ErrorListRepository;

@Service
public class ErrorListDAO {

	@Autowired
	ErrorListRepository repository;

	public Page<ErrorList> getLstErrorListByPage(int page, int size, String name) {
		page = page - 1;
		AppLog.info("page: " + page + " | size :" + size);

		Page<ErrorList> lst = repository.searchByName(name, PageRequest.of(page, size));
		return lst;
	}

	public ErrorList getErrorDetail(Long id) {
		return repository.getById(id);
	}

	public void saveError(ErrorListBean errorBean) {
		ErrorList err = new ErrorList();
		err.setDescription(errorBean.getDescription());
		err.setErrorCode(errorBean.getErrorCode());
		err.setName(errorBean.getName());
		err.setType(errorBean.getType());
		
		repository.save(err);
		
		if(errorBean.getLstBean() != null && !errorBean.getLstBean().isEmpty()) {
			List<ErrorList> lstErr = new ArrayList<ErrorList>();
			for (ErrorListBean err1 : errorBean.getLstBean()) {
				ErrorList err3 = new ErrorList();
				err3.setDescription(err1.getDescription());
				err3.setErrorCode(err1.getErrorCode());
				err3.setName(err1.getName());
				err3.setType(err1.getType());
				err3.setParentId(err.getId());
				lstErr.add(err3);
			}						
			repository.saveAll(lstErr);
		}
		
	}

	public void updateError(ErrorListBean errorBean) {
		ErrorList err = repository.getOne(errorBean.getId());
		if(err != null) {
			err.setDescription(errorBean.getDescription());
			err.setName(errorBean.getName());
			repository.save(err);
		}		
	}

	public void deleteError(Long id) {
		repository.deleteById(id);
	}

	/**
	 * lay all danh sach ma loi
	 * @return
	 */
	public List<ErrorList> getAllErrorType() {
		return repository.getAllErrorCate();		
	}
	
//	/**
//	 * them moi mau bien ban
//	 * 
//	 * @param examination
//	 * @param lstCriteriaLkdt
//	 * @param lsCriteriaNvl
//	 */
//	public void saveIqcExamination(Examination examination, List<IqcCriteriaLkdt> lstCriteriaLkdt,
//			List<IqcCriteriaNvl> lsCriteriaNvl, List<IqcParameter> lstParam) {
//		IqcExaminationType examinationType = new IqcExaminationType();
//		examinationType.setCode(examination.getCode());
//		examinationType.setName(examination.getName());
//		boolean status = Boolean.parseBoolean(examination.getStatus());
//		examinationType.setStatus(status ? 1 : 0);
//		examinationType.setType(examination.getType());
//		examinationType.setDescription(examination.getDescription());
//		examinationType = repository.save(examinationType);
//		if (Constant.EXAMINATION_TYPE_NVL.equals(examination.getType())) {
//			if (lsCriteriaNvl != null) {
//				IqcAuditCriteriaNvl nvl = null;
//				for (IqcCriteriaNvl reNvl : lsCriteriaNvl) {
//					nvl = new IqcAuditCriteriaNvl();
//					nvl.setTemplateId(examinationType.getId());
//					nvl.setCriteriaName(reNvl.getCriteriaName());
//					nvl.setMax(reNvl.getMax());
//					nvl.setMin(reNvl.getMin());
//					nvl.setNote(reNvl.getNote());
//					nvl.setRegulationLevel(reNvl.getLevel());
//					nvl.setUnit(reNvl.getUnit());
//					auditCritetialNvlRepository.save(nvl);
//				}
//			}
//		
//		}
//	}
//
//	/**
//	 * lay thong tin mau bien ban theo ma
//	 * 
//	 * @param examinationCode
//	 * @param type
//	 * @return
//	 */
//	public IqcExaminationType getExaminationByCode(String examinationCode, int type) {
//		return repository.findByCode(examinationCode, type);
//	}

}
