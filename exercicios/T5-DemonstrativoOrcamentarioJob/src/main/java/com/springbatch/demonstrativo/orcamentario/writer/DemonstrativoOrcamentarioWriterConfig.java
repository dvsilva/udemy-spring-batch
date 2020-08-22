package com.springbatch.demonstrativo.orcamentario.writer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demonstrativo.orcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativo.orcamentario.dominio.Lancamento;

@Configuration
public class DemonstrativoOrcamentarioWriterConfig {
	@Bean
	public ItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter() {
		return itens -> {
			System.out.println("---- Demonstrativo orçamentário ----");
			for (GrupoLancamento grupo : itens) {
				System.out.println(String.format("[%d] %s - %s", grupo.getCodigoNaturezaDespesa(),
						grupo.getDescricaoNaturezaDespesa(),
						NumberFormat.getCurrencyInstance().format(grupo.getTotal())));
				for (Lancamento lancamento : grupo.getLancamentos()) {
					System.out.println(String.format("\t [%s] %s - %s", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
							NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
				}
			}
		};
	}
}
