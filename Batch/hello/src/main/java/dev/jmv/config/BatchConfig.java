package dev.jmv.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class BatchConfig {
    private final List<String> names = Arrays.asList("RAM", "JMV", "SITA");

    @Bean
    public Job job(JobRepository jobRepository, Step helloStep) {
        return new JobBuilder("hello2", jobRepository)
                .start(helloStep)
                .build();
    }

    @Bean
    public Step helloStep(JobRepository jobRepository, DataSourceTransactionManager transactionManager) {
        return new StepBuilder("hello-step", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(reader())
                .writer(writer())
                .processor(processor())
                .build();
    }


    @Bean
    public ItemProcessor<String, String> processor() {
        return item -> item.concat("#Processor!");
    }

    @Bean
    public ListItemReader<String> reader() {
        return new ListItemReader<String>(names);
    }

    @Bean
    public ItemWriter<String> writer() {
        return chunk -> {
            System.out.println(chunk.getItems());
        };
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
