package com.fn.qms.dto;

import com.fn.qms.models.IqcAuditResultItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class IqcAuditResultItemDTO {
    private String auditType;
    private List<IqcAuditResultItem> item;
}
