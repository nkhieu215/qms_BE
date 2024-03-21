package com.fn.qms.command;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.dto.SettingMachineDTO;
import com.fn.qms.dto.WoDTO;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.models.PqcWorkOrderStepStatus;
import com.fn.qms.planning.rest.WorkOderInput;
import com.fn.qms.repository.DAO.PQCWorkOrderDAO;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.rest.ProductionStepResponse;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.rest.bean.WorkOder;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class ProductionCRUDAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		ProductionStepResponse res = new ProductionStepResponse();
		Request request = context.getRequest();
		ProductionStepRequest param = request.getPlanningRequest();
		UserDetailsImpl user = context.getUser();

		WorkOderInput input = new WorkOderInput();
		String type = param.getTypeRequest();

		PQCWorkOrderDAO dao = ctx.getBean(PQCWorkOrderDAO.class);
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		switch (type) {
		case Constant.ACTION_ADD:
			saveProduction(dao, param);
			response.setObj(res);
			break;

		case Constant.ACTION_BROWS:
			Page<PqcWorkOrder> lstOrder = dao.searchByProduct(param.getPage(), param.getSize(), param.getName(),
					param.getCode(), null,param.getStartDate(),param.getEndDate(), param.getSap(), param.getWoCode());



			res.setLstOrder(lstOrder.getContent());
			res.setTotal(lstOrder.getTotalPages());
			response.setObj(res);
			break;

		case Constant.ACTION_SHOW:
			PqcWorkOrder order = dao.getById(param.getId());
			ModelMapper modelMapper = new ModelMapper();
			res.setPqcWorkOrder(modelMapper.map(order, WoDTO.class));
			response.setObj(res);
			break;

		case Constant.ACTION_BROWS_STEP:
			PqcWorkOrderResponse respo = new PqcWorkOrderResponse();
			String userId = user.getUsername();
			if ("CREATE".equalsIgnoreCase(param.getStep())) {

				Page<PqcWorkOrder> lstCheckStep = dao.searchByProduct(param.getPage(), param.getSize(),
						param.getName(), param.getCode(),param.getLot(),param.getStartDate(),param.getEndDate(), param.getSap(), param.getWoCode());
				List<WoDTO> lstStep = Arrays.asList(mapper.convertValue(lstCheckStep.getContent(), WoDTO[].class));
				respo.setLstOrder(lstStep);
				respo.setTotal(lstCheckStep.getTotalPages());

			} else {
				Page<PqcWorkOrder> lstCheckStep = dao.getLstByUserStep(param.getPage(), param.getSize(),
						param.getName(), param.getCode(), param.getLot(), param.getStep(), userId, param.getStartDate(),param.getEndDate(), param.getSap(), param.getWoCode());


				List<WoDTO> lstStep = Arrays.asList(mapper.convertValue(lstCheckStep.getContent(), WoDTO[].class));
				respo.setLstOrder(lstStep);
				respo.setTotal(lstCheckStep.getTotalPages());
			}

			response.setObj(respo);
			break;

		case Constant.ACTION_BROWS_ERROR_STEP:
			PqcWorkOrderResponse respoErrLst = new PqcWorkOrderResponse();
			List<PqcErrorList> lstError = dao.getLstErrorCheckStep(param.getId(), param.getStep());
			respoErrLst.setErrList(lstError);
			response.setObj(respoErrLst);
			break;

		case Constant.ACTION_STEP:
			saveActionStep(param, dao, user.getUsername());
			response.setObj(new PqcWorkOrderResponse());
			break;
		default:
			break;
		}

		context.setResult(result);
		return !result.isOk();
	}

	private void saveProduction(PQCWorkOrderDAO dao, ProductionStepRequest param) {
		WorkOder data = param.getData();
		PqcWorkOrder pqcWorkOrder = new PqcWorkOrder();
		pqcWorkOrder.setStatus(Constant.STATUS_CREATE);
		pqcWorkOrder.setProductionName(data.getProductName());
		pqcWorkOrder.setBomVersion(data.getBomVersion());
		pqcWorkOrder.setProductionCode(data.getProductCode());
		pqcWorkOrder.setWorkOrderId(data.getWoId());
		pqcWorkOrder.setPlaningWorkOrderCode(data.getPlanningWorkOrderId());
		pqcWorkOrder.setLotNumber(data.getLotNumber());
		pqcWorkOrder.setBranchName(data.getBranchName());
		pqcWorkOrder.setGroupName(data.getGroupName());
		pqcWorkOrder.setQuantityPlan(data.getQuantityPlan());
		pqcWorkOrder.setProfileCode(data.getProfileCode());
		pqcWorkOrder.setProfileName(data.getProfileName());
		pqcWorkOrder.setProfileId(data.getProfileId());
		dao.save(pqcWorkOrder, param.getBomversion(), param.getLstUserDetail());
	}

	private void saveActionStep(ProductionStepRequest param, PQCWorkOrderDAO dao, String userId) {
		String step = param.getStep();
		String action = param.getAction();

		switch (step) {
		case Constant.CHECK_LIST:
//			dao.stepCheckList(param.getData().getId(),param.getProfile());
			break;

		case Constant.NVL:
			dao.stepNVL(param.getLstNvl(), param.getWorkOrderId(), userId, action);
			break;

		case Constant.NVL100:
//			dao.stepCheckList(param.getData().getId(),param.getProfile());
			break;

		case Constant.TIN:
			dao.stepCheckTinPqc(param.getLstTin(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.MOUNT_COMPONENTS:
			dao.stepCheckMountComponentsPqc(param.getLstMountCheck(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.SOLDER:
			dao.stepCheckSoderPqc(param.getLstSolder(), param.getWorkOrderId(), userId,action);

		case Constant.INTERCHANGEABILITY:
			dao.stepCheckInterchangeability(param.getLstInter(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.ASSEMBLES:
			dao.stepCheckAssembles(param.getLstAssembles(), param.getWorkOrderId(), userId,action);
			break;

		case Constant.PHOTOELECTRIC:
			dao.stepCheckPhotoElectric(param.getLstPhotoelectrics(), param.getWorkOrderId(), userId,action);
			break;

		case Constant.PHOTOELECTRIC_PRODUCT:
			dao.stepCheckPhotoElectricProduct(param.getLstPhotoelectricProducts(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.FIX_ERR:
			dao.stepFixError(param.getLstFixError(), param.getWorkOrderId(), userId,action);
			break;

		case Constant.STORE_CHECK:
			dao.stepStoreCheck(param.getLstCheckStore(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.QC_CHECK:
			dao.stepQcCheck(param.getLstPqcQualities(), param.getWorkOrderId(), userId,action);
			break;
		case Constant.APPROVE_STORE:
			dao.stepApproveStore(param.getApproveStore(), param.getWorkOrderId(), userId,action);
			break;
		default:
			break;
		}

//		param.getProfile();
	}
}
