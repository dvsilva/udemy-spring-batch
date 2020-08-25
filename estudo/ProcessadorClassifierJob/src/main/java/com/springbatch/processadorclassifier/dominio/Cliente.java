package com.springbatch.processadorclassifier.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String sobrenome;
	private String idade;
	private String email;
	private List<Transacao> transacoes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public String toString() {
		return "Cliente{" + "nome='" + nome + "'" + ", sobrenome='" + sobrenome + "'" + ", idade='" + idade + "'"
				+ ", email='" + email + "'" + 
				(transacoes.isEmpty() ? "" : ", transacoes=" + transacoes) 
				+ '}';
	}
}
