package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.*;
import com.fn.qms.models.ApproveStoreSap;
import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.repository.ApproveStoreSapRepository;
import com.fn.qms.repository.AqlTemplateRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.AqlTemplateResponse;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.SapCommonResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.ObjectMapperUtils;
import com.fn.qms.utils.Utils;
import com.fn.sap.models.*;
import com.fn.sap.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class SapService {

    @Autowired
    KhoBhRepository khoBhRepository;
    @Autowired
    SapBpGroupRepository sapBpGroupRepository;

    @Autowired
    OwhsRepository owhsRepository;

    @Autowired
    ApproveStoreSapRepository pqcWorkOrderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SapCommonResponse getCommonApproveSap() {

        Validator.Result result = Validator.Result.OK;
        SapCommonResponse response = new SapCommonResponse();

        List<KhoBh> lstKhoBhs = khoBhRepository.getAll();
        List<SapBpGroup> lstSapBp = sapBpGroupRepository.findAll();
        List<OWHS> lstOwhs = owhsRepository.findAll();

        List<KhoBhDTO> lstKhoDTO = Arrays.asList(modelMapper.map(lstKhoBhs, KhoBhDTO[].class));
        List<SapBPGroupDTO> lstSapBPGroupDTOS = Arrays.asList(modelMapper.map(lstSapBp, SapBPGroupDTO[].class));
        List<OwhsDTO> lstOwhsDto = Arrays.asList(modelMapper.map(lstOwhs, OwhsDTO[].class));

        response.setLstOwhsDTOS(lstOwhsDto);
        response.setLstKhoBhDTOS(lstKhoDTO);
        response.setLstBpGroupDTOS(lstSapBPGroupDTOS);
        return response;
    }

    public PqcWorkOrderResponse getWaitApproveSap(int page, int size, String name, String code, String lot, String startDate, String endDate, String sap, String woCode, String groupName, String branchName) {
        page = page - 1;

        name = Utils.isNull(name) ? null : name.trim();
        groupName = Utils.isNull(groupName) ? null : groupName.trim();
        branchName = Utils.isNull(branchName) ? null : branchName.trim();
        code = Utils.isNull(code) ? null : code.trim();
        lot = Utils.isNull(lot) ? null : lot.trim();
        sap = Utils.isNull(sap) ? null : sap.trim();
        woCode = Utils.isNull(woCode) ? null : woCode.trim();
        Date start = Utils.isNull(startDate) ? null : DateUtils.convertStringToDate(startDate + " 00:00:00", DateUtils.CURRENT_TIME);
        Date end = Utils.isNull(endDate) ? null : DateUtils.convertStringToDate(endDate + " 23:59:59", DateUtils.CURRENT_TIME);


        AppLog.info("page: " + page + " | size :" + size);
        PqcWorkOrderResponse respo = new PqcWorkOrderResponse();

        Page<ApproveStoreSap> lstApprove = pqcWorkOrderRepository.findStoreSapApprove(name, code, lot, start, end, sap, woCode, groupName, branchName, PageRequest.of(page, size));
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<WoDTO> lstStep = Arrays.asList(mapper.convertValue(lstApprove.getContent(), WoDTO[].class));
        respo.setLstOrder(lstStep);
        respo.setTotal(lstApprove.getTotalPages());

        return respo;
    }

    @Autowired
    ColorRepository colorRepository;

    public SapCommonResponse getColor() {
        SapCommonResponse response = new SapCommonResponse();
        Validator.Result result = Validator.Result.OK;
        response.setResult(result);
        List<Color> lstColor = colorRepository.findAll();
        List<ColorDTO> lstColorDTOS = Arrays.asList(modelMapper.map(lstColor, ColorDTO[].class));
        response.setLstColor(lstColorDTOS);
        return response;
    }

    @Autowired
    OcrdRepository ocrdRepository;

    public SapCommonResponse getOcrd(String name) {
        SapCommonResponse response = new SapCommonResponse();
        Validator.Result result = Validator.Result.OK;
        response.setResult(result);
        List<Ocrd> lstOcrd = ocrdRepository.findByName(name);
        List<OcrdDTO> lstOcrdDTO = Arrays.asList(modelMapper.map(lstOcrd, OcrdDTO[].class));
        response.setLstOcrd(lstOcrdDTO);
        return response;
    }
}
