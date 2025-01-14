package dev.jmv.config;

import dev.jmv.model.AccountDetails;
import dev.jmv.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final AccountDetailsRepository accountDetailsRepository;

    public Job job(JobRepository jobRepository, Step updateH2) {
        return new JobBuilder("data-manipulation", jobRepository)
                .start(updateH2)
                .build();
    }

    @Bean
    public Step readCSV(JobRepository jobRepository, DataSourceTransactionManager transactionManager) {
        return new StepBuilder("updateH2", jobRepository)
                .<AccountDetails, AccountDetails>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public RepositoryItemReader<AccountDetails> reader() {
        System.out.println("Reading");
        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        RepositoryItemReader<AccountDetails> reader = new RepositoryItemReader<>();
        reader.setRepository(accountDetailsRepository);
        reader.setMethodName("findAll");
        reader.setSort(sorts);
        return reader;
    }

    @Bean
    public RepositoryItemWriter<AccountDetails> writer() {
        System.out.println("Writing");
        RepositoryItemWriter<AccountDetails> writer = new RepositoryItemWriter<>();
        writer.setRepository(accountDetailsRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public AccountDetailsProcessor processor() {
        System.out.println("Processing");
        return new AccountDetailsProcessor();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
