package com.fn.qms.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.fn.qms.models.NotiConfig;
import com.fn.qms.repository.NotiConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fn.qms.models.Setting;
import com.fn.qms.repository.SettingRepository;

@Component
public class DataCache {

    @Autowired
    NotiConfigRepository notiConfigRepository;
    @Autowired
    SettingRepository settingRepository;

    public static Map<String, Setting> cacheStep = new HashMap();
    public static Map<String, Setting> cacheStepCode = new HashMap();
    public static Map<String, NotiConfig> notiConfigMap = new HashMap<>();


    @PostConstruct
    public void init() {
        addSetting();
        addNotiSetting();
    }

    public void addSetting() {
        List<Setting> lst = settingRepository.findAll();
        if (lst != null) {
            for (Setting setting : lst) {
                cacheStep.put(setting.getKey(), setting);
                cacheStepCode.put(setting.getCode(), setting);
            }
        }
    }

    public void addNotiSetting(){
        List<NotiConfig>  lst = notiConfigRepository.findAll();
        if(lst != null){
            for (NotiConfig noti : lst) {
                notiConfigMap.put(noti.getType(), noti);
            }
        }
    }

    public static Setting getSettingByCode(String code) {
        return cacheStep.get(code);
    }

    public static Setting getSettingByCodeName(String code) {
        return cacheStepCode.get(code);
    }

    public static NotiConfig getNoticonfig(String code){
        return notiConfigMap.get(code);
    }
}
