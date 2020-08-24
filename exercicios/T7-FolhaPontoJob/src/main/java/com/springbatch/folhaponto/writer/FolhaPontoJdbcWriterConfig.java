package com.springbatch.folhaponto.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class FolhaPontoJdbcWriterConfig {
	@Bean
	public JdbcBatchItemWriter<FolhaPonto> folhaPontoJdbcWriter(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<FolhaPonto>()
				.dataSource(dataSource)
				.sql("INSERT INTO folha_ponto (mes, ano, funcionario_id, registros_ponto) VALUES (:mes, :ano, :matricula, :registrosPontoTexto)")
				.beanMapped()
				.build();
	}
}
