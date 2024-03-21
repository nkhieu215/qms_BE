package com.fn.qms.planning.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenOutput {

	public String access_token;
    public String token_type;
    public String refresh_token;
    public int expires_in;
    public String scope;
    @JsonProperty("OAuth2.SESSION_ID") 
    public String oAuth2SESSIONID;
}
