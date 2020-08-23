package com.springbatch.processadorscript.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.processadorscript.dominio.Cliente;

@Configuration
public class ProcessadorScriptStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step processadorScriptStep(
			ItemReader<Cliente> processadorScriptReader,
			ItemProcessor<Cliente, Cliente> processadorScriptProcessor,
			ItemWriter<Cliente> processadorScriptWriter) {
		return stepBuilderFactory
				.get("processadorScriptStep")
				.<Cliente, Cliente>chunk(1)
				.reader(processadorScriptReader)
				.processor(processadorScriptProcessor)
				.writer(processadorScriptWriter)
				.build();
	}
}
