//package com.fn.sap.config;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pvcb.common.constant.AppConstant;
//import com.pvcb.common.rediscache.RedisServer;
//import com.pvcb.common.thirdparty.fabric.esb.v1.dto.TokenJWTFabric;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import okhttp3.*;
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.api.RMapCache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class AuthenFabricAcctFeignConfig implements RequestInterceptor {
//
//  @Value("${fabric.auth.login.acct.url:#{null}}")
//  private String url;
//
//  @Value("${fabric.auth.acct.key:#{null}}")
//  private String appKey;
//
//  @Value("${fabric.auth.acct.secret:#{null}}")
//  private String appSecret;
//
//  @Autowired
//  ObjectMapper objectMapper;
//
//  @Autowired
//  RedisServer redisServer;
//
//  private TokenJWTFabric getNewToken() throws IOException {
//    OkHttpClient client = new OkHttpClient().newBuilder()
//        .build();
//    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//    RequestBody body = RequestBody.create(mediaType, "application/json");
//    Request request = new Request.Builder()
//        .url(url)
//        .method("POST", body)
//        .addHeader("x-kony-app-key", appKey)
//        .addHeader("x-kony-app-secret", appSecret)
//        .addHeader("Content-Type", "application/x-www-form-urlencoded").build();
//
//    Response response = client.newCall(request).execute();
//    TokenJWTFabric tokenJWTFabric = objectMapper.readValue(response.body().string(),
//        TokenJWTFabric.class);
//
//    return tokenJWTFabric;
//  }
//
//  private String getTokenFabric() throws IOException {
//    RMapCache<String, String> sessionMap = redisServer.getRedisClient()
//        .getMapCache(AppConstant.TOKEN_MAP_CACHE);
//    String token = sessionMap.get(AppConstant.TOKEN_MAP_REDIS);
//
//    Date expiresAt = null;
//    if (!StringUtils.isBlank(token)) {
//      DecodedJWT decodedJWT = JWT.decode(token);
//      expiresAt = decodedJWT.getExpiresAt();
//    }
//
//    if (StringUtils.isBlank(token) || expiresAt.before(new Date())) {
//      TokenJWTFabric tokenJWTFabric = getNewToken();
//      token = tokenJWTFabric.getClaimsToken().getValue();
//      sessionMap.fastPut(AppConstant.TOKEN_MAP_REDIS, token,
//          Long.parseLong(tokenJWTFabric.getClaimsToken().getExp()), TimeUnit.MILLISECONDS);
//    }
//
//    return token;
//  }
//
//  @Override
//  public void apply(RequestTemplate template) {
//
//    try {
//      if("SapRequestService".equals(template.feignTarget().name())){
//        template.header("x-kony-authorization", getTokenFabric());
//      }
//    } catch (Exception e) {
////      throw new BusinessException("401","Khong khoi tao duoc token");
//      e.printStackTrace();
//    }
//  }
//}
