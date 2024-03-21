package com.fn.qms.repository.DAO;

import java.util.ArrayList;
import java.util.List;

import com.fn.qms.dto.PqcCriteriaQualityDTO;
import com.fn.qms.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.constant.Constant;
import com.fn.qms.repository.ExaminationRepository;
import com.fn.qms.repository.IqcAuditCritetialLkdtRepository;
import com.fn.qms.repository.IqcAuditCritetialNvlRepository;
import com.fn.qms.repository.IqcAuditCritetialParameterRepository;
import com.fn.qms.repository.PqcCritetialQualityRepository;
import com.fn.qms.rest.bean.IqcCriteriaLkdt;
import com.fn.qms.rest.bean.IqcCriteriaNvl;
import com.fn.qms.rest.bean.IqcParameter;
import com.fn.qms.utils.AppLog;

import antlr.Utils;

import com.fn.qms.rest.bean.Examination;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExaminationDAO {

	@Autowired
	ExaminationRepository repository;

	@Autowired
	IqcAuditCritetialNvlRepository auditCritetialNvlRepository;
	@Autowired
	IqcAuditCritetialLkdtRepository auditCritetialLkdtRepository;

	@Autowired
	IqcAuditCritetialParameterRepository auditCritetialParameterRepository;
	
	@Autowired
	PqcCritetialQualityRepository critetialQualityRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<IqcExaminationType> getLstExaminationByPage(int page, int size, String name, int type, String code) {
		page = page - 1;
		AppLog.info("page: " + page + " | size :" + size);

		Page<IqcExaminationType> lst = repository.findExaminationListByName(type, name,code, PageRequest.of(page, size));
		return lst;
	}

	/**
	 * them moi mau bien ban
	 * 
	 * @param examination
	 * @param lstCriteriaLkdt
	 * @param lsCriteriaNvl
	 */
	public void saveIqcExamination(Examination examination, List<IqcAuditCriteriaLkdt> lstCriteriaLkdt,
			List<IqcCriteriaNvl> lsCriteriaNvl, List<IqcAuditCriteriaParameter> lstParam, List<PqcCriteriaQualityDTO> lstCriteriaQuality) {

		IqcExaminationType examinationType = null;
		if(examination.getId() != null && examination.getId() > 0){
			 examinationType = repository.findById(examination.getId()).get();
			examinationType.setLstAuditCriteriaLkdt(new ArrayList<>());
			examinationType.setLstAuditCriteriaNvl(new ArrayList<>());
			examinationType.setIqcAuditCriteriaParameters(new ArrayList<>());
			examinationType.setLstPqcCriteriaQualities(new ArrayList<>());
		}else{
			 examinationType = new IqcExaminationType();
		}
		examinationType.setCode(examination.getCode());
		examinationType.setName(examination.getName());
		boolean status = Boolean.parseBoolean(examination.getStatus());
		examinationType.setStatus(status ? 1 : 0);
		examinationType.setType(examination.getType());
		examinationType.setDescription(examination.getDescription());

		examinationType = repository.save(examinationType);

		if (Constant.EXAMINATION_TYPE_NVL.equals(examination.getType())) {
			if (lsCriteriaNvl != null) {
				IqcAuditCriteriaNvl nvl = null;
				for (IqcCriteriaNvl reNvl : lsCriteriaNvl) {
					nvl = new IqcAuditCriteriaNvl();
					nvl.setId(reNvl.getId());
					nvl.setTemplateId(examinationType.getId());
					nvl.setCriteriaName(reNvl.getCriteriaName());
					nvl.setMax(reNvl.getMax());
					nvl.setMin(reNvl.getMin());
					nvl.setNote(reNvl.getNote());
					nvl.setRegulationLevel(reNvl.getRegulationLevel());
					nvl.setUnit(reNvl.getUnit());
					auditCritetialNvlRepository.save(nvl);
				}
			}
		} else if (Constant.EXAMINATION_TYPE_LKDT.equals(examination.getType())) {
			if (lstCriteriaLkdt != null && !lstCriteriaLkdt.isEmpty()) {			
				for (IqcAuditCriteriaLkdt lkdtC : lstCriteriaLkdt) {					
					lkdtC.setTemplateId(examinationType.getId());
					lkdtC.setId(lkdtC.getId());
					auditCritetialLkdtRepository.save(lkdtC);
				}
			}

			if (lstParam != null && !lstParam.isEmpty()) {			
				for (IqcAuditCriteriaParameter paramlkdt : lstParam) {					
					paramlkdt.setTemplateId(examinationType.getId());
					paramlkdt.setId(paramlkdt.getId());
					auditCritetialParameterRepository.save(paramlkdt);
				}
			}
		}
		else if (Constant.EXAMINATION_TYPE_KTSP.equals(examination.getType())) {
			
			if (lstCriteriaQuality != null && !lstCriteriaQuality.isEmpty()) {			
				for (PqcCriteriaQualityDTO paramlkdt : lstCriteriaQuality) {
					paramlkdt.setTemplateId(examinationType.getId());
					PqcCriteriaQuality check = modelMapper.map(paramlkdt, PqcCriteriaQuality.class);
					critetialQualityRepository.save(check);
				}
			}
		}
	}

	/**
	 * lay thong tin mau bien ban theo ma
	 * 
	 * @param examinationCode
	 * @param type
	 * @return
	 */
	public IqcExaminationType getExaminationByCode(String examinationCode, int type) {
		return repository.findByCode(examinationCode, type);
	}

	/**
	 * lay thong tin mau bien ban theo id
	 * 
	 * @param id
	 * @return
	 */
	public IqcExaminationType getExamination(Long id) {
		return repository.getOne(id);
	}

	public void actionParam(IqcAuditCriteriaParameter param, String action) {
		if (param != null) {
			switch (action) {
			case Constant.ACTION_ADD:
			case Constant.ACTION_EDIT:
				auditCritetialParameterRepository.save(param);
				break;
			case Constant.ACTION_DELETE:
				auditCritetialParameterRepository.delete(param);
				break;
			default:
				break;
			}
		}
	}

	public void actionLKDT(IqcAuditCriteriaLkdt criteriaLkdt, String action) {
		if (criteriaLkdt != null) {
			switch (action) {
			case Constant.ACTION_ADD:
			case Constant.ACTION_EDIT:
				auditCritetialLkdtRepository.save(criteriaLkdt);
				break;
			case Constant.ACTION_DELETE:
				auditCritetialLkdtRepository.delete(criteriaLkdt);
				break;
			default:
				break;
			}
		}
	}

	public void actionNVL(IqcAuditCriteriaNvl criteriaNvl, String action) {
		if (criteriaNvl != null) {
			switch (action) {
			case Constant.ACTION_ADD:
			case Constant.ACTION_EDIT:
				auditCritetialNvlRepository.save(criteriaNvl);
				break;
			case Constant.ACTION_DELETE:

				auditCritetialNvlRepository.deleteByIdNvl(criteriaNvl.getId());
				break;
			default:
				break;
			}
		}
	}

	public void actionTCKT(PqcCriteriaQuality getQualities, String action) {
		if (getQualities != null) {
			switch (action) {
				case Constant.ACTION_ADD:
				case Constant.ACTION_EDIT:
					critetialQualityRepository.save(getQualities);
					break;
				case Constant.ACTION_DELETE:
					critetialQualityRepository.deleteById(getQualities.getId());
					break;
				default:
					break;
			}
		}
	}

	public List<IqcExaminationType> searchIqcExamination(String code, int type) {
		return repository.searchListByCode(type, code);
	}

}
