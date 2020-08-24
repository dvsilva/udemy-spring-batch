package com.springbatch.folhaponto.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import com.springbatch.folhaponto.dominio.Funcionario;

public class FolhaPontoInvalidaItemProcessor implements ItemProcessor<Funcionario, FolhaPonto> {

	@Override
	public FolhaPonto process(Funcionario funcionario) throws Exception {
		FolhaPonto folhaPonto = new FolhaPonto();
		folhaPonto.setMatricula(funcionario.getMatricula());
		return folhaPonto;
	}

}
