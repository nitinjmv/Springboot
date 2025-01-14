package dev.jmv.batch.config;

import dev.jmv.batch.domain.sql.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {"dev.jmv.batch.domain.sql", "dev.jmv.batch.repository.sql"},
        entityManagerFactoryRef = "sqlEntityManagerFactory",
        transactionManagerRef = "sqlTransactionManager"
)
public class SqlJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory(
            @Qualifier("sqlDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages(Account.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager sqlTransactionManager(
            @Qualifier("sqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(sqlEntityManagerFactory.getObject()));
    }

}
