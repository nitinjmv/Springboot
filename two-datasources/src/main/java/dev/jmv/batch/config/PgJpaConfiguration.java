package dev.jmv.batch.config;

import dev.jmv.batch.domain.pg.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {"dev.jmv.batch.domain.pg", "dev.jmv.batch.repository.pg"},
        entityManagerFactoryRef = "pgEntityManagerFactory",
        transactionManagerRef = "pgTransactionManager"
)
public class PgJpaConfiguration {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean pgEntityManagerFactory(
            @Qualifier("pgDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages(Account.class)
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager pgTransactionManager(
            @Qualifier("pgEntityManagerFactory") LocalContainerEntityManagerFactoryBean pgEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(pgEntityManagerFactory.getObject()));
    }

}
