package com.fn.qms;

import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.repository.PqcStoreCheckRepository;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication(scanBasePackages = {"com.fn.**"})
@EnableScheduling
@ComponentScan(basePackages = {"com.fn.**"})
public class QmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("file.encoding","UTF-8");

		SpringApplication.run(QmsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(QmsApplication.class);
	}


    //Creating bean keycloakConfigResolver
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer configurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*")
						.allowedOrigins("*");
			}
		};
	}


}
