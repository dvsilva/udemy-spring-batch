package com.springbatch.multiplosarquivosformatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

import com.springbatch.multiplosarquivosformatos.dominio.Cliente;
import com.springbatch.multiplosarquivosformatos.dominio.Transacao;

public class ArquivoClienteTransacaoReader
		implements ItemStreamReader<Cliente>, ResourceAwareItemReaderItemStream<Cliente> {

	private FlatFileItemReader<Object> delegate;
	private Object objAtual;

	public ArquivoClienteTransacaoReader(FlatFileItemReader<Object> delegate) {
		this.delegate = delegate;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (objAtual == null)
			objAtual = delegate.read();// ler objeto

		Cliente cliente = (Cliente) objAtual;
		objAtual = null;

		if (cliente != null) {
			while (peek() instanceof Transacao)
				cliente.getTransacoes().add((Transacao) objAtual);
		}

		return cliente;
	}

	private Object peek() throws Exception {
		objAtual = delegate.read(); // leitura do proximo item
		return objAtual;
	}

	@Override
	public void setResource(Resource resource) {
		delegate.setResource(resource);
	}

}
