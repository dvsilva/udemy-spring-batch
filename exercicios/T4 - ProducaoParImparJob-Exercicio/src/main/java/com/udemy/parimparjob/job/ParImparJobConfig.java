package com.udemy.parimparjob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParImparJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job imprimeParImparJob(Step imprimeParImparStep) {
		return jobBuilderFactory
				.get("imprimeParImparJob")
				.start(imprimeParImparStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
