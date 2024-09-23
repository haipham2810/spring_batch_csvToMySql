package com.bean_notation.springbatch_haipham2.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Jobs")
public class JobController {

    private final JobLauncher jobLauncher;
    private final Job job;
    private final JobOperator jobOperator;

    @Autowired
    public JobController(JobLauncher joblauncher, Job job, JobOperator jobOperator){
        this.jobLauncher = joblauncher;
        this.job = job;
        this.jobOperator = jobOperator;

    }

    @GetMapping("/importCustomers")
    public String importCsvToDBJob(){
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try{
            jobLauncher.run(job, jobParameters);
            return "Job started successfully!";
        }catch(Exception e){
            return "Error starting job!" + e.getMessage();
        }
    }

    @PostMapping("/stop")
    public String stopJob(){
        try{
            jobOperator.stop(jobOperator.getRunningExecutions(job.getName()).iterator().next());
            return "Job stop successfully!";
        }catch (Exception e){
            return "Error stopping job: " + e.getMessage();
        }

    }
}
