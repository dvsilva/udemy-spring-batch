package com.springbatch.folhaponto.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {
	private int matricula;
	private String nome;
	private int idade;
	private Date data;
	private Integer mes;
	private Integer ano;
	private List<Date> registrosPonto = new ArrayList<>();

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Date> getRegistrosPonto() {
		return registrosPonto;
	}

	public void setRegistrosPonto(List<Date> registrosPonto) {
		this.registrosPonto = registrosPonto;
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

	@Override
	public String toString() {
		return "Funcionario{" +
				"matricula: " + matricula +
				", registrosPonto: " + registrosPonto +
				"}";
	}
}
