package com.springbatch.processadorclassifier.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessadorClassifierReaderConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	@StepScope
	public FlatFileItemReader processadorClassifierReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes, 
			LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder()
				.name("processadorClassifierReader")
				.resource(arquivoClientes)
				.lineMapper(lineMapper).build();

	}

}
