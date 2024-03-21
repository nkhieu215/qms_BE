package com.fn.qms.rest;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class SapRequest extends BaseRequest{
    String proCode;
    String version;
}
