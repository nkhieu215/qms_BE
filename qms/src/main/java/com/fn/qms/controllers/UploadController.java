package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.UploadForm;
import com.fn.qms.rest.UploadFileResponse;
import com.fn.qms.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/store")
public class UploadController {
    @Autowired
    StorageService storageService;

    @PostMapping(value = "/image/uploadMultiFiles")
    public ResponseEntity uploadFileMulti(@RequestParam("file") MultipartFile[] files){
        Validator.Result result = Validator.Result.OK;
        UploadFileResponse uploadFileResponse =  new UploadFileResponse();
        List<String> lstImage  = storageService.store(files,"root");
        uploadFileResponse.setLstFile(lstImage);
        uploadFileResponse.setResult(result);

        return new ResponseEntity(uploadFileResponse, HttpStatus.OK);
    }
}
