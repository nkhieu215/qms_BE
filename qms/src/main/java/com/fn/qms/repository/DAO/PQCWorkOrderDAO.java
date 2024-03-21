package com.fn.qms.repository.DAO;

import java.util.Date;
import java.util.List;

import com.fn.qms.config.DataCache;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.constant.Constant;
import com.fn.qms.planning.model.PartNumberDetail;
import com.fn.qms.planning.model.UserWorkOrder;
//import com.fn.qms.repository.PqcDrawNVLCheckRepository;
//import com.fn.qms.repository.PqcNVLCheckRepository;
import com.fn.qms.utils.AppLog;
import com.fn.sap.models.Citt1;

@Service
public class PQCWorkOrderDAO {

	@Autowired
	PqcDttdMountErrorRepository pqcDttdMountErrorRepository;

	@Autowired
	PqcWorkOrderRepository repository;
	@Autowired
	PqcBomWorkOrderRepository reBomWorkOrderRepository;

	@Autowired
	PqcWorkOrderStepStatusRepository orderStepStatusRepository;

	@Autowired
	PqcProfileRepository pqcProfileRepository;

	@Autowired
	PqcTinCheckRepository tinRepository;

	@Autowired
	PqcMountCompCheckRepository mountCompCheckRepository;

	@Autowired
	PqcSoderCompCheckRepository pqcSoderCompCheckRepository;

	@Autowired
	PqcInterchangeabilityCheckRepository interchangeabilityCheckRepository;

	@Autowired
	PqcAssemblesCheckRepository assemblesCheckRepository;

//	@Autowired
//	PqcNVLCheckRepository nvlCheckRepository;

//	@Autowired
//	PqcDrawNVLCheckRepository drawNVLCheckRepository;

	@Autowired
	PqcErrorListRepository errorListRepository;

	@Autowired
	PqcPhotoelectricRepository photoelectricRepository;

	@Autowired
	PqcPhotoelectricParamRepository photoElecParamRepository;

	@Autowired
	PqcPhotoelectricLkdtRepository photoelectricLkdtRepository;

	@Autowired
	PqcPhotoelectricProductRepository photoelectricProductRepository;

	@Autowired
	PqcFixErrorRepository fixErrorRepository;

	@Autowired
	PqcQualityRepository pqcQualityRepository;

	@Autowired
	PqcQualityCheckRepository pqcQualityCheckRepository;

	@Autowired
	PqcStoreCheckRepository pqcStoreCheckRepository;

	/**
	 * luu thong tin thuc hien ktra
	 * 
	 * @param pqcWorkOrder
	 * @param bomversion
	 * @param lstUserDetail
	 */
	public void save(PqcWorkOrder pqcWorkOrder, List<Citt1> bomversion, List<UserWorkOrder> lstUserDetail) {
		repository.save(pqcWorkOrder);

		if (bomversion != null && !bomversion.isEmpty()) {
			PqcBomWorkorder bomWorkorder;
			for (Citt1 citt1 : bomversion) {
				bomWorkorder = new PqcBomWorkorder();

				bomWorkorder.setBomQuantity(citt1.getUQuantity() + "");
				bomWorkorder.setItemCode(citt1.getUItemCode());
				bomWorkorder.setItemName(citt1.getUItemName());
				bomWorkorder.setPartNumber(citt1.getUPartNumber());
				bomWorkorder.setQuantity(citt1.getUQuantity() + "");
				bomWorkorder.setVendor(citt1.getUVendor());
				bomWorkorder.setVersion(citt1.getUVersions());
				bomWorkorder.setWorkOrderId(pqcWorkOrder.getId());
				bomWorkorder.setWorkOrderQuantity(pqcWorkOrder.getQuantityPlan());
				bomWorkorder.setWorkOrderId(pqcWorkOrder.getId());

				reBomWorkOrderRepository.save(bomWorkorder);
			}
		}

		if (lstUserDetail != null && !lstUserDetail.isEmpty()) {
			PqcWorkOrderStepStatus step;
			for (UserWorkOrder userWorkOrder : lstUserDetail) {
				step = new PqcWorkOrderStepStatus();
				step.setStatus(Constant.WAIT);
				step.setUserId(userWorkOrder.getUserName());
				step.setPqcWorkOrder(pqcWorkOrder.getId());
				step.setStep(userWorkOrder.getStageCode());
				step.setPosition(Long.parseLong(DataCache.getSettingByCode(userWorkOrder.getStageCode()).getKey()));
				orderStepStatusRepository.save(step);
			}
		}
	}

	// danh sach cac work
	public Page<PqcWorkOrder> searchByProduct(int page, int size, String name, String code, String lot,
											  String startDate,String endDate, String sap, String woCode) {
		page = page - 1;
		AppLog.info("page: " + page + " | size :" + size);
		name= Utils.isNull(name) ? null : name.trim();
		code = Utils.isNull(code) ? null : code.trim();
		lot = Utils.isNull(lot) ? null : lot.trim();
		sap = Utils.isNull(sap)? null : sap.trim();
		woCode = Utils.isNull(woCode)? null : woCode.trim();

		Date start = Utils.isNull(startDate)? null  : DateUtils.convertStringToDate(startDate + " 00:00:00",DateUtils.CURRENT_TIME);
		Date end =Utils.isNull(endDate)? null  : DateUtils.convertStringToDate(endDate + " 23:59:59",DateUtils.CURRENT_TIME);

		return repository.findListByName(name, code, lot,start,end,sap, woCode,PageRequest.of(page, size));
	}

	// danh sach cac work step
	public Page<PqcWorkOrder> getLstByUserStep(int page, int size, String name, String code, String lot, String step,
			String userId, String startDate,String endDate, String sap, String woCode) {
		page = page - 1;

		name= Utils.isNull(name) ? null : name.trim();
		code = Utils.isNull(code) ? null : code.trim();
		lot = Utils.isNull(lot) ? null : lot.trim();
		sap = Utils.isNull(sap)? null : sap.trim();
		woCode = Utils.isNull(woCode)? null : woCode.trim();


		Date start = Utils.isNull(startDate)? null  : DateUtils.convertStringToDate(startDate + " 00:00:00",DateUtils.CURRENT_TIME);
		Date end =Utils.isNull(endDate)? null  : DateUtils.convertStringToDate(endDate + " 23:59:59",DateUtils.CURRENT_TIME);

		AppLog.info("page: " + page + " | size :" + size);
		return repository.findListByStep(name, code, lot, step, userId, start, end,sap,woCode,PageRequest.of(page, size));
	}

	public PqcWorkOrder getById(Long id) {
		return repository.getById(id);
	}

	public void stepCheckList(Long id, PartNumberDetail profile) {
		PqcWorkOrder order = repository.getById(id);
		if (order != null) {
			order.setStatus(Constant.STATUS_CHECK_LIST);
//			order.setProfileCode(profile.getId());
//			order.setProfileName(profile.getName());
//			order.setProfileId(profile.getId() +"");
			repository.save(order);

//			PqcProfile pqcProfile =  new PqcProfile();
//			pqcProfile.setProfileCode(profile.getId());
//			pqcProfile.setProfileName(profile.getName());
//			pqcProfile.setProfileId(profile.getId());
//			pqcProfile.setWorkOrderId(id);
//			pqcProfileRepository.save(pqcProfile);

		}
	}

	/**
	 * ktra in kem thiec
	 * 
	 * @param lstTin
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckTinPqc(List<PqcDttdTinCheck> lstTin, Long workOrderId, String userId, String action) {
		// update status check
		updateStatusCheck(workOrderId, Constant.TIN, userId, action);

		// update check
		if (lstTin != null) {
			for (PqcDttdTinCheck tin : lstTin) {
				tin.setWorkOrderId(workOrderId);
				tinRepository.save(tin);
				// update error
				if (tin.getErrorLists() != null) {
					for (PqcErrorList pqcDttdTinCheck : tin.getErrorLists()) {
						pqcDttdTinCheck.setDttdType(Constant.TIN);
						pqcDttdTinCheck.setDttdCheckId(tin.getDttdCheckId());
						errorListRepository.save(pqcDttdTinCheck);
					}
				}
			}
		}
	}

	/**
	 * lay danh sach loi theo id check tung cong doan
	 * 
	 * @param idDdtcheck
	 * @param step
	 * @return
	 */
	public List<PqcErrorList> getLstErrorCheckStep(Long idDdtcheck, String step) {
		return errorListRepository.getLstErrorStepByIdcheck(idDdtcheck, step);
	}

	/**
	 * luu thong tin check gan linh kien
	 *
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckMountComponentsPqc(List<PqcDttdMountCompCheck> lstmount, Long workOrderId, String userId,
			String action) {

		// update status check
		updateStatusCheck(workOrderId, Constant.MOUNT_COMPONENTS, userId, action);

		// update check
		if (lstmount != null) {
			for (PqcDttdMountCompCheck mount : lstmount) {
				mount.setWorkOrderId(workOrderId);
				mountCompCheckRepository.save(mount);
				// update error
				if (mount.getLstError() != null) {
					for (PqcDttdMountError pqcDttdTinCheck : mount.getLstError()) {
						pqcDttdTinCheck.setDttdType(Constant.MOUNT_COMPONENTS);
						pqcDttdTinCheck.setDttdCheckId(mount.getDttdMountCompId());
						pqcDttdMountErrorRepository.save(pqcDttdTinCheck);
					}
				}
			}
		}
	}

	/**
	 * luu thong tin check lo han
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckSoderPqc(List<PqcDttdSolderCheck> lstSolder, Long workOrderId, String userId, String action) {

		updateStatusCheck(workOrderId, Constant.SOLDER, userId, action);

		// update check
		if (lstSolder != null) {
			for (PqcDttdSolderCheck solder : lstSolder) {
				solder.setWorkOrderId(workOrderId);
				pqcSoderCompCheckRepository.save(solder);
				// update error
//				if (solder.getErrorLists() != null) {
//					for (PqcErrorList pqcDttdTinCheck : solder.getErrorLists()) {
//						pqcDttdTinCheck.setDttdType(Constant.SOLDER);
//						pqcDttdTinCheck.setDttdCheckId(solder.getDttdSolderCheckId());
//						errorListRepository.save(pqcDttdTinCheck);
//					}
//				}
			}
		}
	}

	/**
	 * kiem tra thong tin lap lan
	 * 
	 * @param lstInter
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckInterchangeability(List<PqcDttdInterchangeabilityCheck> lstInter, Long workOrderId,
			String userId, String action) {
		// update status check
		updateStatusCheck(workOrderId, Constant.INTERCHANGEABILITY, userId, action);

		// update check
		if (lstInter != null) {
			for (PqcDttdInterchangeabilityCheck inter : lstInter) {
				inter.setWorkOrderId(workOrderId);
				interchangeabilityCheckRepository.save(inter);
			}
		}
	}

	/**
	 * kiem tra thong tin lap hoan chinh
	 * 
	 * @param lstAssembles
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckAssembles(List<PqcAssemblesSuccessCheck> lstAssembles, Long workOrderId, String userId,
			String action) {
		// update status check
		updateStatusCheck(workOrderId, Constant.ASSEMBLES, userId, action);

		// update check
		if (lstAssembles != null) {
			for (PqcAssemblesSuccessCheck as : lstAssembles) {
				as.setWorkOrderId(workOrderId);
				assemblesCheckRepository.save(as);
				// update error
				if (as.getErrorLists() != null) {
					for (PqcErrorList error : as.getErrorLists()) {
						error.setDttdType(Constant.ASSEMBLES);
						error.setDttdCheckId(as.getId());
						errorListRepository.save(error);
					}
				}
			}
		}
	}

	/**
	 * luu thong tin check nvl
	 * 
	 * @param lstNvl
	 * @param workOrderId
	 * @param userId
	 */
	public void stepNVL(List<PqcDrawNvl> lstNvl, Long workOrderId, String userId, String action) {
		// update status check
		updateStatusCheck(workOrderId, Constant.NVL, userId, action);

		// update check
//		if (lstNvl != null) {
//			for (PqcDrawNvl nvl : lstNvl) {
//				nvl.setWorkOrderId(workOrderId);
//				drawNVLCheckRepository.save(nvl);
//
//				if (nvl.getLstPqcDrawNvl() != null) {
//					for (PqcDrawTestNvl nvlTest : nvl.getLstPqcDrawNvl()) {
//						nvlTest.setPqcDrawNvlId(nvlTest.getDrawTestNvlId());
////						nvlCheckRepository.save(nvlTest);
//					}
//				}
//			}
//		}
	}

	/**
	 * Kiem tra thong so quang dien
	 * 
	 * @param lstPhotoelectrics
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckPhotoElectric(List<PqcPhotoelectric> lstPhotoelectrics, Long workOrderId, String userId,
			String action) {

		updateStatusCheck(workOrderId, Constant.PHOTOELECTRIC_PRODUCT, userId, action);

		// update check
		if (lstPhotoelectrics != null) {
			for (PqcPhotoelectric photoelectric : lstPhotoelectrics) {
				photoelectric.setWorkOrderId(workOrderId);
				photoelectricRepository.save(photoelectric);

				if (photoelectric.getLstLkdt() != null) {
					for (PqcPhotoelectricLkdt lkdt : photoelectric.getLstLkdt()) {
						lkdt.setPqcPhotoelectricId(photoelectric.getId());
						photoelectricLkdtRepository.save(lkdt);
					}
				}

				if (photoelectric.getLstParam() != null) {
					for (PqcPhotoelectricParam lkdtParam : photoelectric.getLstParam()) {

						lkdtParam.setPqcPhotoelectricId(photoelectric.getId());
						photoElecParamRepository.save(lkdtParam);
					}
				}

			}
		}
	}

	/**
	 * kiem tra thong so quang dien sp
	 * 
	 * @param lstPhotoelectricProducts
	 * @param workOrderId
	 * @param userId
	 */
	public void stepCheckPhotoElectricProduct(List<PqcPhotoelectricProduct> lstPhotoelectricProducts, Long workOrderId,
			String userId, String action) {
		// update status check
		this.updateStatusCheck(workOrderId, Constant.PHOTOELECTRIC_PRODUCT, userId, action);

		// save check
		if (lstPhotoelectricProducts != null) {
			for (PqcPhotoelectricProduct pqcPhotoelectricProduct : lstPhotoelectricProducts) {
				pqcPhotoelectricProduct.setWorkOrderId(workOrderId);
				photoelectricProductRepository.save(pqcPhotoelectricProduct);
			}
		}
	}

	/**
	 * sua loi
	 * 
	 * @param lstFixError
	 * @param workOrderId
	 * @param userId
	 */
	public void stepFixError(List<PqcFixErr> lstFixError, Long workOrderId, String userId, String action) {
		// TODO Auto-generated method stub
		this.updateStatusCheck(workOrderId, Constant.FIX_ERR, userId, action);

		if (lstFixError != null) {
			for (PqcFixErr pqcFixErr : lstFixError) {
				pqcFixErr.setWorkOrderId(workOrderId);
				pqcFixErr.setUserId(userId);
				fixErrorRepository.save(pqcFixErr);
			}
		}

	}

	/**
	 * cap nhat trang thai thuc hien check
	 * 
	 * @param workOrderId
	 * @param step
	 * @param userId
	 */
	public void updateStatusCheck(Long workOrderId, String step, String userId, String status) {
		// update status check

		if ("success".equalsIgnoreCase(status)) {
			status = Constant.SUCCESS;
		} else {
			status = Constant.WAIT;
		}

		List<PqcWorkOrderStepStatus> lstCheck = orderStepStatusRepository.getStepbyUserId(workOrderId, step, userId);
		if (lstCheck != null) {
			for (PqcWorkOrderStepStatus pqcWorkOrderStepStatus : lstCheck) {
				pqcWorkOrderStepStatus.setStatus(status);
				orderStepStatusRepository.save(pqcWorkOrderStepStatus);
			}
		}
	}

	public void stepStoreCheck(List<PqcStoreCheck> lstCheckStore, Long workOrderId, String userId, String action) {
		this.updateStatusCheck(workOrderId, Constant.STORE_CHECK, userId, action);

		if (lstCheckStore != null && !lstCheckStore.isEmpty()) {
			for (PqcStoreCheck pqcStoreCheck : lstCheckStore) {
				pqcStoreCheck.setWorkOrderId(workOrderId);
				pqcStoreCheckRepository.save(pqcStoreCheck);
				
				if(pqcStoreCheck.getLsPows() != null) {
					for (PqcStorePow pow : pqcStoreCheck.getLsPows()) {
						
					}
				}
				
				if(pqcStoreCheck.getLsPqcStoreSafes() != null) {
					
				}
				
				if(pqcStoreCheck.getLsSizes() != null) {
					
				}
				
				if(pqcStoreCheck.getLstConfused() != null) {
					
				}
				
				if (pqcStoreCheck.getLstPqcStoreErrs() != null) {
					
				}
			}
		}
	}

	public void stepApproveStore(Object approveStore, Long workOrderId, String userId, String action) {
		// TODO Auto-generated method stub

	}

	public void stepQcCheck(List<PqcQuality> lstPqcQualities, Long workOrderId, String userId, String status) {
		if ("success".equalsIgnoreCase(status)) {
			status = Constant.SUCCESS;
		} else {
			status = Constant.WAIT;
		}
		if (lstPqcQualities != null) {
			for (PqcQuality pqcQuality : lstPqcQualities) {
				pqcQuality.setWorkOrderId(workOrderId);
				pqcQualityRepository.save(pqcQuality);

//				if (pqcQuality.getLstCheck() != null) {
//					for (PqcQualityCheck check : pqcQuality.getLstCheck()) {
//						check.setQualityId(pqcQuality.getId());
////						check.setTemplateId(check.getQualityId());
//						check.setWorkOrderId(workOrderId);
//						pqcQualityCheckRepository.save(check);
//					}
//				}

			}
		}
	}
}
