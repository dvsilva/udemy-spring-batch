package com.springbatch.folhaponto.writer;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class FolhaPontoValidaWriterConfig {
	@Bean
	public CompositeItemWriter<FolhaPonto> folhaPontoValidaWriter(
			@Qualifier("arquivoFolhaPontoWriter") FlatFileItemWriter<FolhaPonto> arquivoFolhaPontoWriter,
			JdbcBatchItemWriter<FolhaPonto> folhaPontoJdbcWriter) {
		return new CompositeItemWriterBuilder<FolhaPonto>()
				.delegates(arquivoFolhaPontoWriter, folhaPontoJdbcWriter)
				.build();
	}
}