package com.fn.qms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@EnableJpaRepositories(basePackages = "com.fn.qms.repository", entityManagerFactoryRef = "inMpEntityManagerFactory", transactionManagerRef = "inMpTransactionManager")

public class DataSourceQmsConfig {

	@Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties inMpDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource inMpDataSource() {
        return inMpDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    /*Primary Entity manager*/
    @Primary
    @Bean(name = "inMpEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean inMpEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(inMpDataSource()).packages("com.fn.qms.models").build();
    }
    
    @Primary
    @Bean
    public PlatformTransactionManager inMpTransactionManager(
            final @Qualifier("inMpEntityManagerFactory") LocalContainerEntityManagerFactoryBean inMpEntityManagerFactory) {
        return new JpaTransactionManager(inMpEntityManagerFactory.getObject());
    }
}