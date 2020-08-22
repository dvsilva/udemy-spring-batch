package com.springbatch.arquivolargurafixa.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {
	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
		return System.out::println;
		/**
		return items -> {
			for (Cliente cliente : items) {
				if(cliente.getNome().equals("Maria"))
					throw new Exception();
				else
					System.out.println(cliente);
			}
		};
		*/
	}
}
