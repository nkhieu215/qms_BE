package com.fn.qms.rest;

import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.models.PqcPhotoelectric;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhotoelectricRequest extends BaseRequest{
    PqcPhotoelectricDTO data;
}
