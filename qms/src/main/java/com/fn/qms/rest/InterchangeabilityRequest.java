package com.fn.qms.rest;

import com.fn.qms.dto.InterchangeabilityCheckDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InterchangeabilityRequest extends BaseRequest{

	public InterchangeabilityCheckDTO data;

}
