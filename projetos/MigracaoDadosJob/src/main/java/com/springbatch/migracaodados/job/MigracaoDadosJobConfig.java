package com.springbatch.migracaodados.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@EnableBatchProcessing
@Configuration
public class MigracaoDadosJobConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job migracaoDadosJob(
			@Qualifier("migrarPessoaStep")  Step migrarPessoaStep,
			@Qualifier("migrarDadosBancariosStep") Step migrarDadosBancariosStep) {
		return jobBuilderFactory
				.get("migracaoDadosJob")
				.start(stepsParalelos(migrarPessoaStep, migrarDadosBancariosStep))
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Flow stepsParalelos(Step migrarPessoaStep, Step migrarDadosBancariosStep) {
		Flow migrarDadosBancariosFlow = new FlowBuilder<Flow>("migrarDadosBancariosFlow")
				.start(migrarDadosBancariosStep)
				.build();
		
		Flow stepsParalelos = new FlowBuilder<Flow>("stepsParalelosFlow")
				.start(migrarPessoaStep)
				.split(new SimpleAsyncTaskExecutor()) // divide a tarefa em paralelo [cuida das threads]
				.add(migrarDadosBancariosFlow)
				.build();
		
		return stepsParalelos;
	}
}
