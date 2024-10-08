package com.fn.qms.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.config.DataCache;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.iqc.nvl.*;
import com.fn.qms.dto.warning.IqcWarning;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.dto.warning.PqcWarning;
import com.fn.qms.models.*;
import com.fn.qms.process.Queue;
import com.fn.qms.repository.*;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.bean.IqcSearchParam;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ElectronicComponentService {
    @Autowired
    ElectronicComponentRepository electronicComponentRepository;
    @Autowired
    IqcElectCompErrRepository iqcElectCompErrRepository;
    @Autowired
    IqcAuditResultNvlRepository iqcAuditResultNvlRepository;
    @Autowired
    IqcAuditResultParamRepository iqcAuditResultParamRepository;
    @Autowired
    IqcAuditResultLkdtRepository iqcAuditResultLkdtRepository;
    @Autowired
    ModelMapper modelMapper;

    public BaseResponse createUpdate(ElectronicComponentRequest param,String userName) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();

        IqcElectronicComponent iqcElectronicComponent = modelMapper.map(param.getComponent(), IqcElectronicComponent.class);
        iqcElectronicComponent.setCreateBy(userName);
        if(iqcElectronicComponent.getId() != null){
            IqcElectronicComponent checkDraw  = electronicComponentRepository.findById(iqcElectronicComponent.getId()).get();
            iqcElectronicComponent.setCreatedAt(checkDraw.getCreatedAt());
            iqcElectronicComponent.setUpdatedAt(new Date());
            iqcElectronicComponent.setTemplateCode(checkDraw.getTemplateCode());
            iqcElectronicComponent.setElecCompCode(checkDraw.getElecCompCode());
        }
        iqcElectronicComponent = electronicComponentRepository.save(iqcElectronicComponent);

        if(param.getLstIqcNvl() != null && !param.getLstIqcNvl().isEmpty()){
            for (IqcAuditResultNvlDTO dto: param.getLstIqcNvl() ) {
                IqcAuditResultNvl nvl = modelMapper.map(dto, IqcAuditResultNvl.class);
                nvl.setElectCompId(iqcElectronicComponent.getId());
                iqcAuditResultNvlRepository.save(nvl);
            }
        }


        if(param.getLstIqcParam() != null && !param.getLstIqcParam().isEmpty()){
            ObjectMapper objectMapper = new ObjectMapper();
            for (IqcAuditResultParameterDTO dto: param.getLstIqcParam() ) {
                IqcAuditResultParameter nvl = modelMapper.map(dto, IqcAuditResultParameter.class);
                if(dto.getData() != null && !dto.data.isEmpty()){
                    try {
                        nvl.setData(objectMapper.writeValueAsString(dto.data));
                    }catch (Exception ex){
                        AppLog.error(ex);
                    }
                }

                nvl.setElectCompId(iqcElectronicComponent.getId());
                iqcAuditResultParamRepository.save(nvl);
            }
        }
        if(param.getLstIqcLkdt() != null && !param.getLstIqcLkdt().isEmpty()){
            for (IqcAuditResultLkdtDTO dto: param.getLstIqcLkdt() ) {
                IqcAuditResultLkdt nvl = modelMapper.map(dto, IqcAuditResultLkdt.class);
                nvl.setElectCompId(iqcElectronicComponent.getId());
                iqcAuditResultLkdtRepository.save(nvl);
            }
        }

        // *cập nhật lỗi(tắt)
//        if(param.getLstError() != null){
//            for (IqcElectCompErrDTO dto: param.getLstError() ) {
//                IqcElectCompErr errror = modelMapper.map(dto, IqcElectCompErr.class);
//                errror.setElectCompId(iqcElectronicComponent.getId());
//                iqcElectCompErrRepository.save(errror);
//            }
//        }

        if(Constant.IQC_UNSATISFACTORY.equalsIgnoreCase(iqcElectronicComponent.getConclusion()) || Constant.IQC_CONCESSIONS.equalsIgnoreCase(iqcElectronicComponent.getConclusion())){
            AppLog.info("Send noti");
            NotiConfig notiConfig = DataCache.getNoticonfig(iqcElectronicComponent.getConclusion().equalsIgnoreCase(Constant.IQC_UNSATISFACTORY) ? "IQC_UNSATISFACTORY" : "IQC_CONCESSIONS");
            if (notiConfig != null) {
                AppLog.info("Send noti true");
                ObjectMapper objectMapper = new ObjectMapper();

                // get step by user
                NotiDto notiDto = new NotiDto();
                notiDto.setType(notiConfig.getType());
                notiDto.setTitle(notiConfig.getTitle());
                notiDto.setTopic(notiConfig.getTopic());
                notiDto.setAppName(notiConfig.getAppName());
                IqcWarning iqcWarning = new IqcWarning();
                iqcWarning.setCode(iqcElectronicComponent.getReportCode());
                iqcWarning.setNote(iqcElectronicComponent.getNote());
                iqcWarning.setPo(iqcElectronicComponent.getPoQuantity());
                iqcWarning.setGrpo(iqcElectronicComponent.getGrpoNumber());
                iqcWarning.setDate(DateUtils.convertToDateString(iqcElectronicComponent.getCheckDate(), DateUtils.DATE_WITH_DASH2));
                iqcWarning.setConclude(iqcElectronicComponent.getConclusion());
                iqcWarning.setName(iqcElectronicComponent.getElectCompName());
                iqcWarning.setQuantity(iqcElectronicComponent.getCheckingQuantity()+"");
                iqcWarning.setOrigin(iqcElectronicComponent.getOrigin());
                iqcWarning.setType("1".equalsIgnoreCase(iqcElectronicComponent.getType())?"Biên bản kiểm tra NVL":"Biên bản kiểm tra BTP");
                try {
                    notiDto.setContent(objectMapper.writeValueAsString(iqcWarning));
                    Queue.notiQueue.add(notiDto);
                }catch (Exception exception){

                }
            }
        }

        response.setId(iqcElectronicComponent.getId());
        response.setResult(result);

        return response;
    }


    public ElectronicComponentResponse getDetailElectronicComponent(Long id) {
        Validator.Result result = Validator.Result.OK;
        ElectronicComponentResponse response = new ElectronicComponentResponse();
        IqcElectronicComponent iqcElectronicComponent = electronicComponentRepository.findById(id).get();
        IqcElectronicComponentDTO dto = modelMapper.map(iqcElectronicComponent, IqcElectronicComponentDTO.class);
        response.setComponent(dto);
        response.setResult(result);
        return response;
    }

    /**
     * Copy bien ban
     * @param id
     * @return
     */
    public ElectronicComponentResponse copyElectronicComponent(Long id) {
        Validator.Result result = Validator.Result.OK;
        ElectronicComponentResponse response = new ElectronicComponentResponse();
        IqcElectronicComponent iqcElectronicComponent = electronicComponentRepository.findById(id).get();
        IqcElectronicComponentDTO dto = modelMapper.map(iqcElectronicComponent, IqcElectronicComponentDTO.class);

        // save
        dto.setId(null);
        IqcElectronicComponent copy = modelMapper.map(dto,IqcElectronicComponent.class);
        copy.setStatus(Constant.IQC_STATUS_DRAFF);
        copy.setReportCode(DateUtils.getDateStr(DateUtils.TIME_SIMPLE_REVERSE_2) +"-RANGDONG-QC");
        copy.setResultNvls(null);
        copy.setResultError(null);
        copy.setResultLkdt(null);
        copy.setResultParam(null);
        copy =  electronicComponentRepository.save(copy);

        if(dto.getResultNvls() != null && !dto.getResultNvls().isEmpty()){
            for (IqcAuditResultNvlDTO re: dto.getResultNvls() ) {
                re.setId(null);
                IqcAuditResultNvl nvl = modelMapper.map(re, IqcAuditResultNvl.class);
                nvl.setElectCompId(copy.getId());
                iqcAuditResultNvlRepository.save(nvl);
            }
        }


        if(dto.getResultParam() != null && !dto.getResultParam().isEmpty()){
            for (IqcAuditResultParameterDTO re: dto.getResultParam() ) {
                re.setId(null);
                IqcAuditResultParameter nvl = modelMapper.map(re, IqcAuditResultParameter.class);
                nvl.setElectCompId(copy.getId());
                iqcAuditResultParamRepository.save(nvl);
            }
        }
        if(dto.getResultLkdt() != null && !dto.getResultLkdt().isEmpty()){
            for (IqcAuditResultLkdtDTO re: dto.getResultLkdt() ) {
                re.setId(null);
                IqcAuditResultLkdt nvl = modelMapper.map(re, IqcAuditResultLkdt.class);
                nvl.setElectCompId(copy.getId());
                iqcAuditResultLkdtRepository.save(nvl);
            }
        }
        if(dto.getResultError() != null){
            for (IqcElectCompErrDTO re: dto.getResultError() ) {
                re.setId(null);
                IqcElectCompErr errror = modelMapper.map(re, IqcElectCompErr.class);
                errror.setElectCompId(copy.getId());
                iqcElectCompErrRepository.save(errror);
            }
        }

        response.setId(copy.getId());
        response.setResult(result);
        return response;
    }

    public ElectronicComponentResponse getListByUser(String username, ElectronicComponentRequest param) {
        Validator.Result result = Validator.Result.OK;
        ElectronicComponentResponse response = new ElectronicComponentResponse();
        int page = param.getPage() - 1;
        AppLog.info("page: " + page + " | size :" + param.getSize());
        IqcSearchParam paramSearch = param.getParam();

        Date startDate = DateUtils.convertStringToDate(paramSearch.getStartDate(), DateUtils.CURRENT_TIME);
        Date endDate = DateUtils.convertStringToDate(paramSearch.getEndDate(), DateUtils.CURRENT_TIME);
        List<String> lstStatus = new ArrayList<>();
        Page<IqcElectronicComponent> iqcElectronicComponents = null;

        if(!Utils.isNull(paramSearch.getStatus())){
            lstStatus.add(paramSearch.getStatus());
        }else{
            if(!Constant.ACTION_APPROVE.equalsIgnoreCase(param.getTypeRequest())){
                lstStatus.add(Constant.IQC_STATUS_DRAFF);
            }
            lstStatus.add(Constant.IQC_STATUS_APPROVE);
            lstStatus.add(Constant.REJECT);
            lstStatus.add(Constant.IQC_STATUS_CONCESSIONS);
            lstStatus.add(Constant.IQC_STATUS_WAIT_APPROVE);
        }

        if(!Constant.ACTION_APPROVE.equalsIgnoreCase(param.getTypeRequest())){
            iqcElectronicComponents = electronicComponentRepository.findIqc(param.getType(), username,
                    paramSearch.getName(),
                    paramSearch.getCode(),
                    paramSearch.getReportCode(),
                    paramSearch.getInvoiceNumber(),
                    startDate,
                    endDate,
                    lstStatus,
                    paramSearch.getItemType(),
                    PageRequest.of(page, param.getSize())
            );
        }else{
            iqcElectronicComponents = electronicComponentRepository.findIqc(param.getParam().getType(), null,
                    paramSearch.getName(),
                    paramSearch.getCode(),
                    paramSearch.getReportCode(),
                    paramSearch.getInvoiceNumber(),
                    startDate,
                    endDate,
                    lstStatus,
                    paramSearch.getItemType(),
                    PageRequest.of(page, param.getSize()));
        }


        List<IqcElectronicComponent> lst = iqcElectronicComponents.getContent();
        Type listType = new TypeToken<List<IqcElectronicComponentDTO>>() {}.getType();
        List<IqcElectronicComponentDTO> lstDto = modelMapper.map(lst, listType);

        response.setTotalPages(iqcElectronicComponents.getTotalPages());
        response.setLst(lstDto);
        response.setTotal(iqcElectronicComponents.getTotalPages());
        response.setResult(result);
        return response;

    }

    public BaseResponse removeCheck(Long id, String username) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        IqcElectronicComponent iqcElectronicComponent = electronicComponentRepository.findById(id).get();
        if(iqcElectronicComponent != null && Constant.IQC_STATUS_DRAFF.equalsIgnoreCase(iqcElectronicComponent.getStatus())){
            electronicComponentRepository.delete(iqcElectronicComponent);
        }else{
            result =  new SimpleResult(ResponseCode.STATUS_INVALID.getDesc(), false,ResponseCode.STATUS_INVALID.getErrorCode());
        }
        response.setResult(result);
        return response;
    }

    public BaseResponse removeCheckResult(Long id, Long electronicComponentId,String type) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();

        switch (type){
            case Constant.TYPE_CHECK_NVL:
                iqcAuditResultNvlRepository.deleteById(id);
                break;

            case Constant.TYPE_CHECK_PARAM:
                iqcAuditResultParamRepository.deleteById(id);
                break;

            case Constant.TYPE_CHECK_LKDT:
                iqcAuditResultLkdtRepository.deleteById(id);
                break;
            case Constant.TYPE_CHECK_ERROR:
                iqcElectCompErrRepository.deleteById(id);
                break;
            default:
                result = new SimpleResult(ResponseCode.INVALID_INPUT.getDesc(), false, ResponseCode.INVALID_INPUT.getErrorCode());
        }

        response.setResult(result);
        return response;
    }


    public BaseResponse createParamCheck(ElectronicComponentRequest param,String user) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        String type = param.getType();
        switch (type){
            case Constant.TYPE_CHECK_NVL:
                IqcAuditResultNvl iqcAuditResultNvl = modelMapper.map(param.getNvlParam(),IqcAuditResultNvl.class );
                iqcAuditResultNvl = iqcAuditResultNvlRepository.save(iqcAuditResultNvl);
                response.setId(iqcAuditResultNvl.getId());
                break;

            case Constant.TYPE_CHECK_ERROR:
                IqcElectCompErr iqcElectCompErr = modelMapper.map(param.getErrParam(),IqcElectCompErr.class);
                iqcElectCompErr = iqcElectCompErrRepository.save(iqcElectCompErr);
                response.setId(iqcElectCompErr.getId());
                break;
            default:
                result = new SimpleResult(ResponseCode.INVALID_INPUT.getDesc(), false, ResponseCode.INVALID_INPUT.getErrorCode());
        }

        response.setResult(result);
        return response;
    }
}
