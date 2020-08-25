package com.springbatch.migracaodados.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step migrarPessoaStep(
			ItemReader<Pessoa> arquivoPessoaReader,
			ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter,
			FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter) {
		return stepBuilderFactory
				.get("migrarPessoaStep")
				.<Pessoa, Pessoa>chunk(10000)
				.reader(arquivoPessoaReader)
				.writer(pessoaClassifierWriter)
				// registrar todo escritor stream que estiver sendo usado no classificador
				// controle do ciclo de vida de abertura e fechamento da streams nao e feita com classificador
				// nao implementa a classe ItemStream
				.stream(arquivoPessoasInvalidasWriter) 
				.build();
	}
}
