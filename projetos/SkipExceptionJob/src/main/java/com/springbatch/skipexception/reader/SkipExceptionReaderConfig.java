package com.springbatch.skipexception.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.springbatch.skipexception.dominio.Cliente;

@Configuration
public class SkipExceptionReaderConfig {
	@Bean
	public ItemReader<Cliente> skipExceptionReader(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("skipExceptionReader")
				.dataSource(dataSource)
				.sql("select * from cliente")
				.rowMapper(rowMapper())
				//.beanRowMapper(Cliente.class)
				.build();
	}

	private RowMapper<Cliente> rowMapper() {
		return new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				if(rs.getRow() == 11)
					throw new SQLException(String.format("Encerrando a execução - Cliente inválido %s", rs.getString("email")));
				else
					return clienteRowMapper(rs);
			}

			private Cliente clienteRowMapper(ResultSet rs) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setNome(rs.getString("sobrenome"));
				cliente.setNome(rs.getString("idade"));
				cliente.setNome(rs.getString("email"));
				return cliente;
			}
		};
	}
}
