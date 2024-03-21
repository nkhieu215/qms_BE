package com.fn.qms.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.fn.sap.repository", entityManagerFactoryRef = "sapEntityManagerFactory", transactionManagerRef = "sapTransactionManager")
public class DataSourceSAPConfig {

	@Bean
    @ConfigurationProperties("spring.sapdatasource")
    public DataSourceProperties sapDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    @ConfigurationProperties("spring.sapdatasource.configuration")
    public DataSource sapDataSource() {
        return sapDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Bean(name = "sapEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sapEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(sapDataSource()).packages("com.fn.sap.models").build();
    }
    
    @Bean(name = "sapTransactionManager")
    public PlatformTransactionManager sapTransactionManager(
            final @Qualifier("sapEntityManagerFactory") LocalContainerEntityManagerFactoryBean sapEntityManagerFactory) {
        return new JpaTransactionManager(sapEntityManagerFactory.getObject());
    }
	

}
