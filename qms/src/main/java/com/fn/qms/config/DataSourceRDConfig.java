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
@EnableJpaRepositories(basePackages = "com.fn.rd.repository", entityManagerFactoryRef = "sgcEntityManagerFactory", transactionManagerRef = "sgcTransactionManager")
public class DataSourceRDConfig {

	@Bean
    @ConfigurationProperties("spring.seconddatasource")
    public DataSourceProperties sgcDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    @ConfigurationProperties("spring.seconddatasource.configuration")
    public DataSource sgcDataSource() {
        return sgcDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    
    @Bean(name = "sgcEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sgcEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(sgcDataSource()).packages("com.fn.rd.models").build();
    }
    
    @Bean(name = "sgcTransactionManager")
    public PlatformTransactionManager sgcTransactionManager(
            final @Qualifier("sgcEntityManagerFactory") LocalContainerEntityManagerFactoryBean sgcEntityManagerFactory) {
        return new JpaTransactionManager(sgcEntityManagerFactory.getObject());
    }
	

}
