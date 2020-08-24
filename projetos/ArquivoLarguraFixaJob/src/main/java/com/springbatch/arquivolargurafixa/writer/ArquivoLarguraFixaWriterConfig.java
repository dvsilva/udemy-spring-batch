package com.springbatch.arquivolargurafixa.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

/**
 * O job vai ler clientes e imprimí-los no arquivo (mostrar o job config).
 * 
 * Rodar aplicação com: arquivoClientesSaida=file:files/clientesSaida.txt
 */
@Configuration
public class ArquivoLarguraFixaWriterConfig {
	
	@StepScope
	@Bean
	public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter(
			@Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClientesSaida) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("escritaArquivoLarguraFixaWriter")
				.resource(arquivoClientesSaida)
				.formatted()
				// %9s %9s %2s %19s -> primeiro espacos depois string
				// %-9s %-9s %-2s %-19s -> primeiro string depois espacos
				.format("%-9s %-9s %-2s %-19s")
                .names(new String[] {"nome", "sobrenome", "idade", "email"})
				.build();
		
		// return System.out::println;
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
