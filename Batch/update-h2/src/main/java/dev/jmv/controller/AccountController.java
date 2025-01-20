package dev.jmv.controller;

import dev.jmv.model.AccountDetails;
import dev.jmv.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountDetailsRepository accountDetailsRepository;

    private final JobLauncher jobLauncher;

    private final Job job;

    @GetMapping
    public ResponseEntity<List<AccountDetails>> findAll() {
        return ResponseEntity.ok(accountDetailsRepository.findAll());
    }

    @GetMapping("migrate")
    public ResponseEntity<List<AccountDetails>> migrateData() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobRestartException, JobParametersInvalidException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("sad", new Date().getTime())
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
        return ResponseEntity.ok(accountDetailsRepository.findAll());
    }


}
