package com.springbatch.multiplosarquivosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.multiplosarquivosformatos.dominio.Cliente;

@Configuration
public class MultiplosArquivosFormatosReaderConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@StepScope
	@Bean
	public FlatFileItemReader multiplosArquivosFormatosItemReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoCLientes, LineMapper lineMapper) {
		
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("multiplosArquivosFormatosItemReader")
				.resource(arquivoCLientes)
				.encoding("UTF-8")
				.lineMapper(lineMapper)
				.build();
	}
}
