package com.udemy.parimparjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParImparStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeParImparStep(
			ItemReader<Integer> contaAteDezReader, 
			ItemProcessor<Integer, String> parOuImparProcessor, 
			ItemWriter<String> imprimeWriter) {
		return stepBuilderFactory
				.get("imprimeParImparStep")
				.<Integer, String>chunk(1)
				.reader(contaAteDezReader)
				.processor(parOuImparProcessor)
				.writer(imprimeWriter)
				.build();
	}
}
