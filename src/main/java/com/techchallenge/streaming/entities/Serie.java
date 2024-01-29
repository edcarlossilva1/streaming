package com.techchallenge.streaming.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_serie")
public class Serie extends Titulo {

	private int temporadas;
	private int episodioPorTemporada;
	private boolean ativa;
	private int minutoPorEpisodio;
	
	public Serie() {

	}

	public Serie(int temporadas, int episodioPorTemporada, boolean ativa, int minutoPorEpisodio) {
		this.temporadas = temporadas;
		this.episodioPorTemporada = episodioPorTemporada;
		this.ativa = ativa;
		this.minutoPorEpisodio = minutoPorEpisodio;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getEpisodioPorTemporada() {
		return episodioPorTemporada;
	}

	public void setEpisodioPorTemporada(int episodioPorTemporada) {
		this.episodioPorTemporada = episodioPorTemporada;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public int getMinutoPorEpisodio() {
		return minutoPorEpisodio;
	}

	public void setMinutoPorEpisodio(int minutoPorEpisodio) {
		this.minutoPorEpisodio = minutoPorEpisodio;
	}
	
//Sobreescrita de metodo Reescrevendo o metodo da classe Titulo para utilizar na classe Serie
	@Override
	public int getDuracaoMinuto(){
		return temporadas * episodioPorTemporada * minutoPorEpisodio;
	}
	
	
	
	
}
