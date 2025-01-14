package dev.jmv.config;

import dev.jmv.model.PanDetails;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    public Job job(JobRepository jobRepository, Step readCSV) {
        return new JobBuilder("pg2sql", jobRepository)
                .start(readCSV)
                .build();
    }

    @Bean
    public Step readCSV(JobRepository jobRepository, DataSourceTransactionManager transactionManager) {
        return new StepBuilder("read-csv", jobRepository)
                .<PanDetails, PanDetails>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader<PanDetails> reader() {
        System.out.println("Reading");
        return () -> PanDetails.builder().build();
    }

    @Bean
    public ItemWriter<PanDetails> writer() {
        System.out.println("Writing");
        return item -> PanDetails.builder().build();
    }

    @Bean
    public PanDetailsProcessor processor() {
        System.out.println("Processing");
        return new PanDetailsProcessor();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
