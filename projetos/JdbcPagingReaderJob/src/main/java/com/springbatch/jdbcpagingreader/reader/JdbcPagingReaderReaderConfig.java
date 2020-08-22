package com.springbatch.jdbcpagingreader.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.springbatch.jdbcpagingreader.dominio.Cliente;

@Configuration
public class JdbcPagingReaderReaderConfig {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public JdbcPagingItemReader<Cliente> jdbcPagingReader(
			@Qualifier("appDataSource") DataSource dataSource,
			PagingQueryProvider queryProvider) {
		
		return new JdbcPagingItemReaderBuilder()
				.name("jdbcPagingReader")
				.dataSource(dataSource)
				.queryProvider(queryProvider)
				.pageSize(1)
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("from cliente");
		queryProvider.setSortKey("email");
		return queryProvider;
	}
}
