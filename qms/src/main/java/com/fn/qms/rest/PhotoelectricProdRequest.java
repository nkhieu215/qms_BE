package com.fn.qms.rest;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.dto.PqcPhotoelectricProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoelectricProdRequest extends BaseRequest{
    PqcPhotoelectricProductDTO data;
}
