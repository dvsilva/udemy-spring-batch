package com.springbatch.processadorclassifier.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassifierStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Step processadorClassifierStep(
			FlatFileItemReader processadorClassifierReader,
			ItemProcessor processadorClassifierProcessor,
 			ItemWriter processadorClassifierWriter) {
		return stepBuilderFactory
				.get("processadorClassifierStep")
				.chunk(1)
				.reader(processadorClassifierReader)
				.processor(processadorClassifierProcessor)
				.writer(processadorClassifierWriter)
				.build();
	}
}
