package com.springbatch.contasbancarias.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.contasbancarias.dominio.Conta;

@Configuration
public class ClienteInvalidoWriterConfig {

	@StepScope
	@Bean
	public FlatFileItemWriter<Conta> clienteInvalidoWriter() {
		
		return new FlatFileItemWriterBuilder<Conta>()
				.name("clienteInvalidoWriter")
				.resource(new FileSystemResource("./files/clientesInvalidos.txt"))
				.delimited()
				.names("clienteId")
				.build();
	}
	
}
