package com.example.service;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class SecondTaskletStep implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("I am in Second Tasklet Step and accessing Job Execution Context Value  "+chunkContext.getStepContext().getJobExecutionContext());
		System.out.println("I am in Second Tasklet Step");
		return RepeatStatus.FINISHED;
	}

}
