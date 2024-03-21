package com.fn.sap.service;

import feign.Client;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class SSLSapConfiguration {

  @Bean
  public Client feignClient() {
    Client trustSSLSockets = new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
    return trustSSLSockets;
  }


  private SSLSocketFactory getSSLSocketFactory() {
    try {
      TrustStrategy acceptingTrustStrategy = new TrustStrategy() {

        @Override
        public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
          return true;
        }
      };

      SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
          .build();
      return sslContext.getSocketFactory();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }
}