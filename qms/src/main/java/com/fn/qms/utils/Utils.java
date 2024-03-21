package com.fn.qms.utils;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.config.DataCache;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.dto.warning.PqcWarning;
import com.fn.qms.models.*;
import com.fn.qms.process.Queue;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;

import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.ExaminationServiceBase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Utils {
    public static boolean isNull(String s) {
        return s == null || s.equalsIgnoreCase("null") || s.trim().length() == 0;
    }

    public static UserDetailsImpl convertKeycloakToUserUtil(HttpServletRequest requestClient) {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) requestClient.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        String username = accessToken.getPreferredUsername();
        Set<String> roles = accessToken.getRealmAccess().getRoles();

        List<SimpleGrantedAuthority> listAuthorities = new ArrayList<>();
        SimpleGrantedAuthority grantedAuthority;
        if (!roles.isEmpty()) {
            for (String role : roles) {
                grantedAuthority= new SimpleGrantedAuthority(role);
                listAuthorities.add(grantedAuthority);
            }
        }
        UserDetailsImpl user = new UserDetailsImpl(null, username, accessToken.getEmail(), "",listAuthorities );
        return user;
    }

    public static void buildPqcWarning(String step, String userId,PqcWorkOrder pqcWorkOrder , String conclude, String note) {

            List<String> concludeLst = new ArrayList<>();
            concludeLst.add("NHÂN NHƯỢNG");
            concludeLst.add("KHÔNG ĐẠT");

            boolean noti = false;
            String url = "";
            if (concludeLst.contains(conclude.toUpperCase())){
                noti = true;
            }

            NotiConfig notiConfig = DataCache.getNoticonfig(step);
            if (notiConfig != null && noti) {
                ObjectMapper objectMapper = new ObjectMapper();
                String stepName = DataCache.getSettingByCodeName(step).getName();


                // get step by user
                NotiDto notiDto = new NotiDto();
                notiDto.setType(notiConfig.getType());
                notiDto.setTitle(notiConfig.getTitle());
                notiDto.setTopic(notiConfig.getTopic());
                notiDto.setAppName(notiConfig.getAppName());

                PqcWarning pqcWarning = new PqcWarning();
                pqcWarning.setWo(pqcWorkOrder.getSapWo());
                pqcWarning.setNote(note);
                pqcWarning.setConclude(conclude);
                pqcWarning.setStep(stepName);
                pqcWarning.setLotnumber(pqcWorkOrder.getLotNumber());
                pqcWarning.setUrl(url);
                pqcWarning.setPoCode(pqcWorkOrder.getSapWo());
                pqcWarning.setDateStart(pqcWorkOrder.getStartTime());
                pqcWarning.setProductName(pqcWorkOrder.getProductionName());
                pqcWarning.setProductCode(pqcWorkOrder.getProductionCode());
                try {
                    notiDto.setContent(objectMapper.writeValueAsString(pqcWarning));
                    Queue.notiQueue.add(notiDto);
                }catch (Exception exception){

                }

            }

    }

}
