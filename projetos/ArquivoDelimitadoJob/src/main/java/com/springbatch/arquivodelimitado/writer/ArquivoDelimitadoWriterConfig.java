package com.springbatch.arquivodelimitado.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivodelimitado.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoWriterConfig {
	
	@StepScope
	@Bean
	public FlatFileItemWriter<Cliente> arquivoDelimitadoWriter(
			@Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClientesSaida) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("arquivoDelimitadoWriter")
				.resource(arquivoClientesSaida)
				.delimited()
				.delimiter(";")
                .names("nome", "sobrenome", "idade", "email")
				.build();
		
		// return items -> items.forEach(System.out::println);
	}
}
