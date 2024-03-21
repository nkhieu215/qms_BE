package com.fn.qms.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.keycloak.representations.AccessToken;


import java.util.Set;

@Data
class CustomKeycloakAccessToken extends AccessToken {

    @JsonProperty("roles")
    protected Set<String> roles;

}