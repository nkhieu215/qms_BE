package com.fn.qms.dto.iqc.nvl;

import com.fn.qms.dto.IqcAuditCriteriaParameterDTO;
import com.fn.qms.dto.PqcCriteriaQualityDTO;
import com.fn.qms.models.IqcAuditCriteriaLkdt;
import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditCriteriaParameter;
import com.fn.qms.models.PqcCriteriaQuality;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class IqcExaminationDTO {
    private Long id;
    private String code;
    private String name;
    private int status;
    private int type;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    private List<IqcAuditCriteriaNvlDTO> lstAuditCriteriaNvl;
    private List<IqcAuditCriteriaLkdtDTO> lstAuditCriteriaLkdt;
    private List<IqcAuditCriteriaParameterDTO> iqcAuditCriteriaParameters;
    private List<PqcCriteriaQualityDTO> lstPqcCriteriaQualities;
}
