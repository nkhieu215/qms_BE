package com.fn.qms.rest;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.dto.PqcQualityDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QcCheckRequest extends BaseRequest{
    PqcQualityDTO data;
}
