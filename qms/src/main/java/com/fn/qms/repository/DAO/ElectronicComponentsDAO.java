package com.fn.qms.repository.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fn.qms.rest.bean.IqcSearchParam;
import com.fn.qms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.models.IqcAuditResultLkdt;
import com.fn.qms.models.IqcAuditResultNvl;
import com.fn.qms.models.IqcAuditResultParameter;
import com.fn.qms.models.IqcElectCompErr;
import com.fn.qms.models.IqcElectronicComponent;
import com.fn.qms.repository.ElectronicComponentRepository;
import com.fn.qms.repository.IqcAuditResultLkdtRepository;
import com.fn.qms.repository.IqcAuditResultNvlRepository;
import com.fn.qms.repository.IqcAuditResultParamRepository;
import com.fn.qms.repository.IqcElectCompErrRepository;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.utils.AppLog;

@Service
public class ElectronicComponentsDAO {

    @Autowired
    ElectronicComponentRepository repository;
    @Autowired
    IqcAuditResultNvlRepository auditResultNvlRepository;

    @Autowired
    IqcElectCompErrRepository iqcElectCompErrRepository;

    @Autowired
    IqcAuditResultParamRepository auditResultParamRepository;

    @Autowired
    IqcAuditResultLkdtRepository auditResultLkdtRepository;

    public Page<IqcElectronicComponent> getLstElectronicComponentsByPage(int page, int size, String name,
                                                                         List<String> status, String userId, String aproveBy, String type) {
        page = page - 1;
        AppLog.info("page: " + page + " | size :" + size);

        return repository.findListByName(name, status, userId, aproveBy, type, PageRequest.of(page, size));
    }

    public Page<IqcElectronicComponent> searcheElectronic(int page, int size, IqcSearchParam param,String userId, String type) {
        page = page - 1;
        AppLog.info("page: " + page + " | size :" + size);

        Date startDate= DateUtils.convertStringToDate(param.getStartDate(), DateUtils.CURRENT_TIME) ;
        Date endDate= DateUtils.convertStringToDate(param.getEndDate(), DateUtils.CURRENT_TIME) ;

        return repository.findIqc(type, userId,
                param.getName(),
                param.getCode(),
                param.getReportCode(),
                param.getInvoiceNumber(),
                startDate,
                endDate,
                new ArrayList<>(),
                param.getItemType(),
                PageRequest.of(page, size)
        );
    }

    public IqcElectronicComponent saveElectronicComponent(ElectronicComponentRequest param) {
        // TODO Auto-generated method stub

        if (param.getComponent() != null) {
//            IqcElectronicComponent component = param.getComponent();
//            repository.save(component);
//            if (param.getLstIqcNvl() != null) {
//                for (IqcAuditResultNvl nvl : param.getLstIqcNvl()) {
//                    nvl.setElectCompId(component.getId());
//                    nvl.setMin(nvl.getMinAudit());
//                    nvl.setMax(nvl.getMaxAudit());
//                    nvl.setApproveStatus(nvl.getApproveStatusAudit());
//                    nvl.setNote(nvl.getNoteAudit());
//                    nvl.setOrtherRequerement(nvl.getOrtherRequerementAudit());
//                    nvl.setAuditCriteriaId(nvl.getAuditCriteriaId());
//                    nvl.setQuantity(nvl.getQuantityAudit());
//                    nvl.setCheckResult(nvl.getCheckResultAudit());
//                    auditResultNvlRepository.save(nvl);
//                }
//            }
//
//            if (param.getLstError() != null) {
//                for (IqcElectCompErr error : param.getLstError()) {
//                    error.setIqcElectronicComponent(component);
//                    iqcElectCompErrRepository.save(error);
//                }
//
//            }
//
//            if (param.getLstIqcLkdt() != null) {
//                for (IqcAuditResultLkdt paramAudit : param.getLstIqcLkdt()) {
//                    paramAudit.setElectCompId(component.getId());
//                    paramAudit.setQuantity(paramAudit.getAuditQuantity());
//                    auditResultLkdtRepository.save(paramAudit);
//                }
//            }
//
//            if (param.getLstIqcParam() != null) {
//                for (IqcAuditResultParameter paramAudit : param.getLstIqcParam()) {
//                    paramAudit.setMin(paramAudit.getMinAudit());
//                    paramAudit.setMax(paramAudit.getMaxAudit());
//                    paramAudit.setElectCompId(component.getId());
//                    paramAudit.setQAvg(paramAudit.getAuditQAvg());
//                    paramAudit.setAvg(paramAudit.getAuditAvg());
//                    auditResultParamRepository.save(paramAudit);
//                }
//            }
//
//
//            //
//            return component;
        }

        return null;

    }

    public IqcElectronicComponent getById(Long id) {
        return repository.getById(id);
    }

    /**
     * cap nhat trang thai cua bien ban
     *
     * @param component
     */
    public void approveElectronicComponent(IqcElectronicComponent component) {
        IqcElectronicComponent componentElectronic = repository.getById(component.getId());
        if (componentElectronic != null) {
            componentElectronic.setNote(component.getNote());
            componentElectronic.setStatus(component.getStatus());
            componentElectronic.setAproveBy(component.getAproveBy());
            repository.save(componentElectronic);
        }
    }

    public void delete(Long id) {
        IqcElectronicComponent componentElectronic = repository.getById(id);
        if (componentElectronic != null) {
            componentElectronic.setStatus("DELETE");
            repository.save(componentElectronic);
        }

    }

}
