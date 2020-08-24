package com.springbatch.folhaponto.writer;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class ArquivoFolhaPontoWriterConfig {
	@Bean
	public FlatFileItemWriter<FolhaPonto> arquivoFolhaPontoWriter() {
		return new FlatFileItemWriterBuilder<FolhaPonto>().name("arquivoFolhaPontoWriter")
				.resource(new FileSystemResource("files/folha_ponto.txt")).lineAggregator(lineAggregator())
				.headerCallback(cabecalhoCallback()).footerCallback(rodapeCallback()).build();
	}

	private FlatFileHeaderCallback cabecalhoCallback() {
		return new FlatFileHeaderCallback() {

			@Override
			public void writeHeader(Writer writer) throws IOException {
				writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n",
						new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
				writer.append(String.format("MÓDULO: RH \t\t\t\t\t\t\t\t HORA: %s\n",
						new SimpleDateFormat("HH:MM").format(new Date())));
				writer.append(String.format("\t\t\t\tFOLHA DE PONTO\n"));
			}
		};
	}
	
	private FlatFileFooterCallback rodapeCallback() {
		return new FlatFileFooterCallback() {
			
			@Override
			public void writeFooter(Writer writer) throws IOException {
				writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s\n", "fkyew6868fewjfhjjewf"));
			}
		};
	}

	private LineAggregator<FolhaPonto> lineAggregator() {
		return new LineAggregator<FolhaPonto>() {

			@Override
			public String aggregate(FolhaPonto folhaPonto) {
				StringBuilder writer = new StringBuilder();
				writer.append(String.format("----------------------------------------------------------------------------\n"));
				writer.append(String.format("NOME:%s\n", folhaPonto.getNome()));
				writer.append(String.format("MATRICULA:%s\n", folhaPonto.getMatricula()));
				writer.append(String.format("----------------------------------------------------------------------------\n"));
				writer.append(String.format("%10s%10s%10s%10s%10s","DATA", "ENTRADA", "SAIDA", "ENTRADA", "SAIDA"));
				
				for (String dataRegistroPonto : folhaPonto.getRegistrosPontos().keySet()) {
					writer.append(String.format("\n%s", dataRegistroPonto));
					
					for (String registro : folhaPonto.getRegistrosPontos().get(dataRegistroPonto)) {
						writer.append(String.format("%10s", registro));
					}
				}
				
				return writer.toString();
			}
		};
	}
}
