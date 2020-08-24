package com.springbatch.folhaponto.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class ClassifierFolhaPontoWriterConfig {
	@Bean
	public ClassifierCompositeItemWriter<FolhaPonto> folhaPontoWriter(
			@Qualifier("folhaPontoInvalidaWriter") FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter,
			CompositeItemWriter<FolhaPonto> folhaPontoValidaWriter) {
		return new ClassifierCompositeItemWriterBuilder<FolhaPonto>()
				.classifier(classifier(folhaPontoInvalidaWriter, folhaPontoValidaWriter))
				.build();
	}

	private Classifier<FolhaPonto, ItemWriter<? super FolhaPonto>> classifier(
			FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter,
			CompositeItemWriter<FolhaPonto> folhaPontoValidaWriter) {
		return new Classifier<FolhaPonto, ItemWriter<? super FolhaPonto>>() {
			private static final long serialVersionUID = 4904496673294853515L;

			@Override
			public ItemWriter<? super FolhaPonto> classify(FolhaPonto folhaPonto) {
				if (folhaPonto.getRegistrosPontos().isEmpty())
					return folhaPontoInvalidaWriter;
				else
					return folhaPontoValidaWriter;
			}

		};
	}

}
