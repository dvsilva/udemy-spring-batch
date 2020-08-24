package com.springbatch.arquivodelimitado.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivodelimitado.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step arquivoDelimitadoStep(ItemReader<Cliente> arquivoDelimitadoReader,
			ItemWriter<Cliente> arquivoDelimitadoWriter) {
		return stepBuilderFactory
				.get("arquivoDelimitadoStep")
				.<Cliente, Cliente>chunk(1)
				.reader(arquivoDelimitadoReader)
				.writer(arquivoDelimitadoWriter)
				.build();
	}
}
