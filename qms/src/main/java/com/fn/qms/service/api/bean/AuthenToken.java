package com.fn.qms.service.api.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthenToken {
	@JsonProperty("access_token")
	public String accessToken;	
	@JsonProperty("token_type")
	public String tokenType;
	@JsonProperty("refresh_token")
	public String refreshToken;
	@JsonProperty("expires_in")
	public int expiresIn;
	public String scope;
	@JsonProperty("OAuth2.SESSION_ID")
	public String oAuth2SESSIONID;
}
