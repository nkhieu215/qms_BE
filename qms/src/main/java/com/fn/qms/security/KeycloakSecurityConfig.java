//package com.fn.qms.security;
//
//import com.fn.qms.utils.AppLog;
//import com.fn.qms.utils.Utils;
//import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticatedActionsFilter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
//import org.keycloak.adapters.springsecurity.filter.KeycloakSecurityContextRequestFilter;
//import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Value("${appName.allowedApi}")
//    private String myAllowedApi;
//
//    @Autowired
//    private JwtAuthConverter jwtAuthConverter;
//
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new NullAuthenticatedSessionStrategy();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Bean
//    public FilterRegistrationBean<?> keycloakAuthenticationProcessingFilterRegistrationBean(
//            KeycloakAuthenticationProcessingFilter filter) {
//
//        FilterRegistrationBean<?> registrationBean = new FilterRegistrationBean<>(filter);
//
//        registrationBean.setEnabled(false);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<?> keycloakPreAuthActionsFilterRegistrationBean(
//            KeycloakPreAuthActionsFilter filter) {
//
//        FilterRegistrationBean<?> registrationBean = new FilterRegistrationBean<>(filter);
//        registrationBean.setEnabled(false);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<?> keycloakAuthenticatedActionsFilterBean(
//            KeycloakAuthenticatedActionsFilter filter) {
//
//        FilterRegistrationBean<?> registrationBean = new FilterRegistrationBean<>(filter);
//
//        registrationBean.setEnabled(false);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<?> keycloakSecurityContextRequestFilterBean(
//            KeycloakSecurityContextRequestFilter filter) {
//
//        FilterRegistrationBean<?> registrationBean = new FilterRegistrationBean<>(filter);
//
//        registrationBean.setEnabled(false);
//
//        return registrationBean;
//    }
//
//    @Bean
//    @Override
//    @ConditionalOnMissingBean(HttpSessionManager.class)
//    protected HttpSessionManager httpSessionManager() {
//        return new HttpSessionManager();
//    }
//
//
//    //
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        AppLog.info(myAllowedApi);
//        if (!Utils.isNull(myAllowedApi)) {
//            configuration.setAllowedOrigins(Arrays.asList(myAllowedApi.split(",")));
//        }
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type"));
//        configuration.setExposedHeaders(Arrays.asList("X-Get-Header"));
//        configuration.setMaxAge(3600L);
//        configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//        http.authorizeHttpRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .anyRequest().authenticated();
//        http.oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(jwtAuthConverter);
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        return http.build();
//    }
//}