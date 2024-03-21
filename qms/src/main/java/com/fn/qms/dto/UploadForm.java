package com.fn.qms.dto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadForm {
    private MultipartFile[] files;
}
