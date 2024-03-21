package com.fn.qms.dto;

import com.fn.qms.models.PqcDrawTestNvl;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PqcDrawNvlDTO {
    private Long id;
    private String note;

    private String conclude;

    private String checkPerson;

    private Long workOrderId;

    private Date createdAt;

    private Date updatedAt;

    private List<PqcDrawNvlTestDTO> lstPqcDrawNvl;
}
