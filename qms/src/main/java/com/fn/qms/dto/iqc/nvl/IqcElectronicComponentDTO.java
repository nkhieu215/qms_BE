package com.fn.qms.dto.iqc.nvl;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class IqcElectronicComponentDTO {

    private Long id;
    public String conclusion;
    public String reportCode;
    public String itemType;
    public String electCompName;
    public String poQuantity;
    public Date checkDate;
    public Date importDate;
    public String batchNumber;
    public String invoiceNumber;
    public String checkingQuantity;
    public String origin;
    public String grpoNumber;
    public String importDateStr;
    public String checkDateStr;
    public String elecCompCode;
    public String type;
    public String status;
    public String templateCode;
    public Date createdAt;
    public String createBy;
    public String spkphNumber;
    public String approveNote;
    public String note;
    public String suggestion;
    public String iqcElectType;


    private List<IqcAuditResultNvlDTO> resultNvls;
    private List<IqcElectCompErrDTO> resultError;
    private List<IqcAuditResultLkdtDTO> resultLkdt;
    private List<IqcAuditResultParameterDTO> resultParam;
}
