package com.fn.qms.rest;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.dto.SettingMachineDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhotoelectricResponse extends BaseResponse{
    PqcPhotoelectricDTO photoelectricDTO;
}
