package com.springbatch.folhaponto.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import com.springbatch.folhaponto.dominio.Funcionario;

@Configuration
public class FolhaPontoProcessorConfig {
	@Bean
	public ItemProcessor<Funcionario, FolhaPonto> folhaPontoProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<Funcionario, FolhaPonto>()
				.classifier(new FolhaPontoClassifier()).build();
	}
}
