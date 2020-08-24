package com.springbatch.folhaponto.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.Funcionario;

@Configuration
public class FuncionarioReaderJdbcConfig {
	@Bean
	public JdbcCursorItemReader<Funcionario> funcionarioReaderJdbc(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Funcionario>()
				.name("funcionarioReaderJdbc")
				.dataSource(dataSource)
				.sql("select *, MONTH(data) as mes, YEAR(data) as ano from funcionario left join registro_ponto on (matricula = funcionario_id and (data is null or MONTH(data)=MONTH(now()) and YEAR(data)=YEAR(now()))) order by matricula")
				.beanRowMapper(Funcionario.class)
				.build();
	}
}
