package com.springbatch.contasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.contasbancarias.dominio.Cliente;
import com.springbatch.contasbancarias.dominio.Conta;

public class ContaInvalidaItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		return conta;
	}

}
