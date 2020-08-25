package com.springbatch.contasbancarias.dominio;

import java.text.NumberFormat;

public class Conta {
	private Integer id;
	private TipoConta tipo;
	private Double limite;
	private String clienteId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	
	@Override
	public String toString() {
		return "Conta{" +
				"clienteId=" + this.clienteId +
				",tipo=" + this.tipo +
				",limite=" + NumberFormat.getCurrencyInstance().format(this.limite) +
				"}";
	}
}
