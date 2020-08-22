package com.springbatch.arquivodelimitado.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivodelimitado.dominio.Cliente;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoCLientes) {
		
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoCLientes)
				//.encoding("UTF-8")
				.delimited()
				.names(new String[] {"nome", "sobrenome", "idade", "email"})
				.targetType(Cliente.class)
				.build();
	}
}
