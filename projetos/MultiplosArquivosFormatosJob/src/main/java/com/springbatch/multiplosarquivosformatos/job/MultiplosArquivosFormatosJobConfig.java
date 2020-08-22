package com.springbatch.multiplosarquivosformatos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class MultiplosArquivosFormatosJobConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job multiplosArquivosFormatosJob(Step leituramultiplosarquivosformatosStep) {
		return jobBuilderFactory
				.get("multiplosArquivosFormatosJob")
				.start(leituramultiplosarquivosformatosStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
