package com.springbatch.processadorclassifier.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.processadorclassifier.dominio.Transacao;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

	@Override
	public Transacao process(Transacao transacao) throws Exception {
		System.out.println(String.format("\nAplicando regras de negócio no transacao %s", transacao.getId()));
		return transacao;
	}

}
