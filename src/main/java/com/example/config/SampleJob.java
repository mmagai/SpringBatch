package com.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ItemProcessor.FirstItemProcessor;
import com.example.ItemReader.FirstItemReader;
import com.example.ItemWriter.FirstItemWriter;
import com.example.listner.FirstJobExecutionListner;
import com.example.service.SecondTaskletStep;

@Configuration
public class SampleJob {
	
	@Autowired
	private FirstJobExecutionListner firstJobExecutionListner;
	
	
	@Autowired
	private SecondTaskletStep secondTaskletStep;
	
	@Autowired
	private JobBuilderFactory JobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private FirstItemReader firstItemReader;
	
	@Autowired
	private FirstItemProcessor firstItemProcessor;
	
	@Autowired
	private FirstItemWriter firstItemWriter;
	
	
	//@Bean
	public Job firstJob() {
		
		 return JobBuilderFactory.get("First Job")
		.start(firstStep())
		.next(secondStep())
		.incrementer(new RunIdIncrementer())
		.listener(firstJobExecutionListner)
		.build();
		
		
	}

	@Bean
	public Job secondJob() {
		
		return JobBuilderFactory.get("Second Job")
				.incrementer(new RunIdIncrementer())
				.start(firstChunkOrientedStep())
				.build();
		
		
		
		
		
		
	}

	private Step firstChunkOrientedStep() {
		
		return stepBuilderFactory.get("Chunk Oriented Step")
				.<Integer, Long>chunk(3)
				.reader(firstItemReader)
				.processor(firstItemProcessor)
				.writer(firstItemWriter)
				.build();
		
		
		
	}
	private Step firstStep() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("First Step")
				.tasklet(firstTaskletStep())
				.build();
	}

	private Step secondStep() {
		
		
		 return stepBuilderFactory.get("Second Step")
		.tasklet(secondTaskletStep)
		.build();
		
		
		
	}



	private Tasklet firstTaskletStep() {
		// TODO Auto-generated method stub
		return new Tasklet(){

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("I am in First Tasklet Step");
				return RepeatStatus.FINISHED;
			}};
	}
	

}
