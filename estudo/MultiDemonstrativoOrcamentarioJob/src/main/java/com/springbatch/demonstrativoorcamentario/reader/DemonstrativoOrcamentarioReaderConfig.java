package com.springbatch.demonstrativoorcamentario.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;

@Configuration
public class DemonstrativoOrcamentarioReaderConfig {
	@StepScope
	@Bean
	public MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader(
			@Value("#{jobParameters['arquivosLancamento']}") Resource[] arquivosLancamento,
			GrupoLancamentoReader grupoLancamentoReader) {
		return new MultiResourceItemReaderBuilder<GrupoLancamento>()
				.name("demonstrativoOrcamentarioReader")
				.resources(arquivosLancamento)
				.delegate(grupoLancamentoReader)
				.build();
	}
}
