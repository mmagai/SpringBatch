package com.example.listner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobExecutionListner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub

		System.out.println("Job Name    "+jobExecution.getJobInstance().getJobName());
		System.out.println("Job Execution Paramter    "+jobExecution.getJobParameters());
		System.out.println("Job Execution Context    "+jobExecution.getExecutionContext());
		
		
		
		jobExecution.getExecutionContext().put("First Name   " , "MAHESH");
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub

		System.out.println("Job Name    "+jobExecution.getJobInstance().getJobName());
		System.out.println("Job Execution Paramter    "+jobExecution.getJobParameters());
		System.out.println("Job Execution Context    "+jobExecution.getExecutionContext());
	}

}
