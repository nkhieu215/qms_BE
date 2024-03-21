package com.fn.qms.rest;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoelectricProdResponse extends BaseResponse{
    PqcPhotoelectricDTO photoelectricDTO;
}
