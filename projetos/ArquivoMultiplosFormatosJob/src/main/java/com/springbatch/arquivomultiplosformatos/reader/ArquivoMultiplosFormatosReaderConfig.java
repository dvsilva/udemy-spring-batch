package com.springbatch.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;

@Configuration
public class ArquivoMultiplosFormatosReaderConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@StepScope
	@Bean
	public FlatFileItemReader arquivoMultiplosFormatosItemReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoCLientes, LineMapper lineMapper) {
		
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("arquivoMultiplosFormatosItemReader")
				.resource(arquivoCLientes)
				.encoding("UTF-8")
				.lineMapper(lineMapper)
				.build();
	}
}
