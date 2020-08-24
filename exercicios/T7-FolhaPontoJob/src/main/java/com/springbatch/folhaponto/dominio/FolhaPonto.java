package com.springbatch.folhaponto.dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolhaPonto {
	private String nome;
	private int matricula;
	private String data;
	private Integer mes;
	private Integer ano;
	private Map<String, List<String>> registrosPontos = new HashMap<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, List<String>> getRegistrosPontos() {
		return registrosPontos;
	}

	public void setRegistrosPontos(Map<String, List<String>> registrosPontos) {
		this.registrosPontos = registrosPontos;
	}
	
	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getRegistrosPontoTexto() {
		return this.registrosPontos.toString();
	}

	@Override
	public String toString() {
		return "FolhaPonto{" +
					"nome=" + this.nome +
					", matricula=" + this.matricula +
					", registrosPontos=" + this.registrosPontos +
				"}";
	}
}
