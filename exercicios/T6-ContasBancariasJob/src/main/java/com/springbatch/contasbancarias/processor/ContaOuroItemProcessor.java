package com.springbatch.contasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.contasbancarias.dominio.Cliente;
import com.springbatch.contasbancarias.dominio.Conta;
import com.springbatch.contasbancarias.dominio.TipoConta;

public class ContaOuroItemProcessor implements ItemProcessor<Cliente, Conta> {
	
	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.OURO);
		conta.setLimite(1000.0);
		return conta;
	}
	
}
