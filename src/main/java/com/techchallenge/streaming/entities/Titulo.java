package com.techchallenge.streaming.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Classe criada como Super classe para implementação das classe Filme e Serie
 */
@MappedSuperclass
public class Titulo {

	// Atributos da classe video
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	protected String descricao;
	protected String url;
	protected LocalDate dataLancamento;
	protected double somaDaAvaliacao;
	protected int totalDeAvaliacao;
	protected int duracaoMinuto;
	protected String classificacao;

	// Construtor vazío
	public Titulo() {

	}
	// Construtor populado

	public Titulo(Long id, String nome, String descricao, String url, LocalDate dataLancamento, double somaDaAvaliacao,
			int totalDeAvaliacao, int duracaoMinuto, String classificacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.url = url;
		this.dataLancamento = dataLancamento;
		this.somaDaAvaliacao = somaDaAvaliacao;
		this.totalDeAvaliacao = totalDeAvaliacao;
		this.duracaoMinuto = duracaoMinuto;
		this.classificacao = classificacao;
	}

	// Criando Metodos

	public void avaliacao(double nota) {
		somaDaAvaliacao += nota;
		totalDeAvaliacao++;
	}
	
	public double mediaAvaliacao (){
      return somaDaAvaliacao / totalDeAvaliacao;
}
	// Criando Metodos Getters e Setters
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
    

	public double getSomaDaAvaliacao() {
		return somaDaAvaliacao;
	}


	public int getTotalDeAvaliacao() {
		return totalDeAvaliacao;
	}


	public int getDuracaoMinuto() {
		return duracaoMinuto;
	}


	public void setDuracaoMinuto(int duracaoMinuto) {
		this.duracaoMinuto = duracaoMinuto;
	}


	public String getClassificacao() {
		return classificacao;
	}


	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		return Objects.equals(id, other.id);
	}

}
