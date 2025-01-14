package dev.jmv.batch.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.pg")
    public DataSourceProperties pgDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.sql")
    public DataSourceProperties sqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource pgDataSource() {
        return pgDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public DataSource sqlDataSource() {
        return sqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

//    @Bean
//    public JdbcTemplate pgJdbcTemplate(@Qualifier("pgDataSource") DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

}
