package com.springbatch.demonstrativoorcamentario.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativoorcamentario.reader.GrupoLancamentoReader;
import com.springbatch.demonstrativoorcamentario.writer.DemonstrativoOrcamentarioRodape;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step demonstrativoOrcamentarioStep(
			// Esse aqui lê dos arquivos
			//MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
			// Esse aqui lê do banco de dados
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			MultiResourceItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter, 
			DemonstrativoOrcamentarioRodape rodapeCallback) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				// .<GrupoLancamento,GrupoLancamento>chunk(100)
				.<GrupoLancamento,GrupoLancamento>chunk(1) // gerar um item por arquivo
				.reader(demonstrativoOrcamentarioReader)
				.writer(demonstrativoOrcamentarioWriter)
				.listener(rodapeCallback)
				.build();
	}
}
