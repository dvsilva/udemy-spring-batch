package com.springbatch.folhaponto.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import com.springbatch.folhaponto.dominio.Funcionario;

public class FuncionarioReader implements ItemStreamReader<Funcionario> {
	private Funcionario funcionarioAtual;
	private JdbcCursorItemReader<Funcionario> delegate;

	public FuncionarioReader(JdbcCursorItemReader<Funcionario> delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public Funcionario read() throws Exception {
		if (funcionarioAtual == null)
			funcionarioAtual = delegate.read();

		Funcionario funcionario = funcionarioAtual;
		
		if (funcionarioAtual != null) {
			if (funcionarioAtual.getData() != null)
				funcionario.getRegistrosPonto().add(funcionarioAtual.getData());
			
			
			Funcionario proximoFuncionario = peek();
			while (proximoFuncionario != null && proximoFuncionario.getMatricula() == funcionario.getMatricula()) {
				funcionario.getRegistrosPonto().add(proximoFuncionario.getData());
				proximoFuncionario = peek();
			}
		}
		return funcionario;
	}

	private Funcionario peek() throws Exception {
		funcionarioAtual = delegate.read();
		return funcionarioAtual;
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
}
