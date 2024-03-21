package com.fn.sap.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.utils.AppLog;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class SapClientDecoder implements ErrorDecoder {

  private final ErrorDecoder errorDecoder = new Default();

  @SneakyThrows
  @Override
  public Exception decode(String s, Response response) {

    String message = null;
    Reader reader = null;

    try {
      reader = response.body().asReader();
      //Easy way to read the stream and get a String object
      String result = CharStreams.toString(reader);
      //use a Jackson ObjectMapper to convert the Json String into a
      //Pojo
      ObjectMapper mapper = new ObjectMapper();
      //just in case you missed an attribute in the Pojo
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      //init the Pojo
      SapServiceResult exceptionMessage = mapper.readValue(result,  SapServiceResult.class);

    } catch (IOException e) {
      AppLog.info("inquiry request: {}," + ExceptionUtils.getStackTrace(e));
    }

    switch (response.status()) {

      case 404:
        return new FileNotFoundException(message == null ? "File no found" :
            message);

    }

    return errorDecoder.decode(s, response);
  }
}
