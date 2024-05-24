package com.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory; 
	
	@Bean
	public Job firstJob() {
		
		return jobBuilderFactory.get("First Job")
		.start(firstStep())
		.build();
		
		
	}
	
	
	  private Step firstStep() {
		  
		  return stepBuilderFactory.get("First Step")
		    .tasklet(firstTask())
		    .build();
		  
	  }


	private Tasklet firstTask() {
		// TODO Auto-generated method stub
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Hi, This is First Spring Batch Job with One Tasklet Step");
				return RepeatStatus.FINISHED;
			}};
	}
	

}
