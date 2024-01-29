package com.techchallenge.streaming.services;

import com.techchallenge.streaming.entities.Titulo;

public class CalculaTempo {
	private int tempoTotal;

	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public void inclui (Titulo t) {
		this.tempoTotal += t.getDuracaoMinuto();
	}

}
