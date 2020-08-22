package com.springbatch.arquivomultiplosformatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;
import com.springbatch.arquivomultiplosformatos.dominio.Transacao;

public class ArquivoClienteTransacaoReader
		implements ItemStreamReader<Cliente> {

	private ItemStreamReader<Object> delegate;
	private Object objAtual;

	public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
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

}
