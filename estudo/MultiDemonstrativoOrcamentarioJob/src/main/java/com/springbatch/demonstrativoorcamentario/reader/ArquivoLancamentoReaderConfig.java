package com.springbatch.demonstrativoorcamentario.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativoorcamentario.dominio.Lancamento;

@Configuration
public class ArquivoLancamentoReaderConfig {
	
	@Bean
	public FlatFileItemReader<GrupoLancamento> arquivoLancamentoReader() {
		return new FlatFileItemReaderBuilder<GrupoLancamento>()
				.name("arquivoLancamentoReader")
				.delimited()
				.names("codigoNaturezaDespesa", 
						"descricaoNaturezaDespesa", 
						"descricaoLancamento", 
						"dataLancamento", 
						"valorLancamento")
				.fieldSetMapper(grupoLancamentoFieldSetMapper())
				.build();
	}

	private FieldSetMapper<GrupoLancamento> grupoLancamentoFieldSetMapper() {
		return new FieldSetMapper<GrupoLancamento>() {

			@Override
			public GrupoLancamento mapFieldSet(FieldSet fieldSet) throws BindException {
				GrupoLancamento grupo = new GrupoLancamento();
				grupo.setCodigoNaturezaDespesa(fieldSet.readInt("codigoNaturezaDespesa"));
				grupo.setDescricaoNaturezaDespesa(fieldSet.readString("descricaoNaturezaDespesa"));
				grupo.setLancamentoTmp(new Lancamento());
				grupo.getLancamentoTmp().setData(fieldSet.readDate("dataLancamento"));
				grupo.getLancamentoTmp().setDescricao(fieldSet.readString("descricaoLancamento"));
				grupo.getLancamentoTmp().setValor(fieldSet.readDouble("valorLancamento"));
				return grupo;
			}
			
		};
	}
}
