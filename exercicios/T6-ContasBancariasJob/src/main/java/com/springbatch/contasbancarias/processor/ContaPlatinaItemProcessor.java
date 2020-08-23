package com.springbatch.contasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.contasbancarias.dominio.Cliente;
import com.springbatch.contasbancarias.dominio.Conta;
import com.springbatch.contasbancarias.dominio.TipoConta;

public class ContaPlatinaItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.PLATINA);
		conta.setLimite(2500.0);
		return conta;
	}

}
