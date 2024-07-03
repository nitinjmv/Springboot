package com.example.sbpgcrypto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostgresConfig {

    @Bean(name = "pgDataSource")
    @ConfigurationProperties(prefix = "pg.datasource")
    public DataSource pgDataSource(){
        return DataSourceBuilder.create().build();
    }
}
