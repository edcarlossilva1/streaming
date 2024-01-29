package com.techchallenge.streaming.entities;

import com.techchallenge.streaming.services.Avaliavel;


public class Episodio implements Avaliavel {

	private int numero;
	private String nome;
	private Serie serie;
	private int totalVizualizacao;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public int getTotalVizualizacao() {
		return totalVizualizacao;
	}

	public void setTotalVizualizacao(int totalVizualizacao) {
		this.totalVizualizacao = totalVizualizacao;
	}

	@Override
	public int getAvaliacao() {
		if (totalVizualizacao > 100) {
			return 4;
		} else {
			return 2;
		}

	}

}
