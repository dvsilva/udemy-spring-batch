package com.springbatch.folhaponto.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class FolhaPontoInvalidaWriterConfig {
	@Bean
	public FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter() {
		return new FlatFileItemWriterBuilder<FolhaPonto>()
				.name("folhaPontoInvalidaWriter")
				.resource(new FileSystemResource("files/funcionarios_sem_ponto.txt"))
				.delimited()
				.names("matricula")
				.build();
	}
}
