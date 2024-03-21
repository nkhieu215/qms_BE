package com.fn.logging;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class GsonParserUtils {
    public static String parseObjectToString(Object object) {
        ObjectMapper mappper  = new ObjectMapper();
        try {
            String json  = mappper.writeValueAsString(object);
            return json;
        }catch (Exception ex){

        }
        return  "";
    }

    public static <T> T parseStringToObject(String json, Class<T> classObject) {
        try {
            return new Gson().fromJson(json, classObject);
        } catch (Exception e) {
            return null;
        }
    }
}