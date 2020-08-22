package com.springbatch.demonstrativo.orcamentario.dominio;

import java.util.Date;

public class Lancamento {
	private String descricao;
	private Date data;
	private Double valor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Lancamento [descricao=" + descricao + ", data=" + data + ", valor=" + valor + "]";
	}

}
