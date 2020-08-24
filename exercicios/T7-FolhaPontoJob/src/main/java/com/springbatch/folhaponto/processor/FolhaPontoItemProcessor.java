package com.springbatch.folhaponto.processor;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import com.springbatch.folhaponto.dominio.Funcionario;
import com.springbatch.folhaponto.util.DataUtil;

public class FolhaPontoItemProcessor implements ItemProcessor<Funcionario, FolhaPonto> {
	@Override
	public FolhaPonto process(Funcionario funcionario) throws Exception {
		FolhaPonto folhaPonto = new FolhaPonto();
		folhaPonto.setMatricula(funcionario.getMatricula());
		folhaPonto.setNome(funcionario.getNome());
		Collections.sort(funcionario.getRegistrosPonto());
		folhaPonto.setRegistrosPontos(gerarRegistrosPonto(funcionario.getRegistrosPonto()));
		folhaPonto.setMes(funcionario.getMes());
		folhaPonto.setAno(funcionario.getAno());
		return folhaPonto;
	}

	private Map<String, List<String>> gerarRegistrosPonto(List<Date> pontos) {
		return pontos.stream().collect(Collectors.groupingBy(DataUtil::formatDia,
				Collectors.mapping(DataUtil::formatHoraDoDia, Collectors.toList())));
	}
}
