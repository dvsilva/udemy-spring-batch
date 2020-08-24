package com.springbatch.demonstrativoorcamentario.dominio;

import java.util.ArrayList;
import java.util.List;

public class GrupoLancamento {
	private Integer codigoNaturezaDespesa;
	private String descricaoNaturezaDespesa;
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	private Lancamento lancamentoTmp;
	
	public Lancamento getLancamentoTmp() {
		return lancamentoTmp;
	}

	public void setLancamentoTmp(Lancamento lancamentoTmp) {
		this.lancamentoTmp = lancamentoTmp;
	}

	public Integer getCodigoNaturezaDespesa() {
		return codigoNaturezaDespesa;
	}

	public void setCodigoNaturezaDespesa(Integer codigoNaturezaDespesa) {
		this.codigoNaturezaDespesa = codigoNaturezaDespesa;
	}

	public String getDescricaoNaturezaDespesa() {
		return descricaoNaturezaDespesa;
	}

	public void setDescricaoNaturezaDespesa(String descricaoNaturezaDespesa) {
		this.descricaoNaturezaDespesa = descricaoNaturezaDespesa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Double getTotal() {
		return lancamentos
				.stream()
				.mapToDouble(Lancamento::getValor)
				.reduce(0.0, Double::sum);
	}
}
