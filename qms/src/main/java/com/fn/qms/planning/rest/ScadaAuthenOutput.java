package com.fn.qms.planning.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScadaAuthenOutput {

	public String token;
    public String refreshToken;

}
