package com.techchallenge.streaming.services;

public class Recomendacao {

	public void recomendacao(Avaliavel avaliavel) {
		if (avaliavel.getAvaliacao() >= 4) {
			System.out.println("Esta entre os preferidos do momento");
		} else if (avaliavel.getAvaliacao() >= 2) {
			System.out.println("Muito bem avaliado no momento");
		} else {
			System.out.println("Coloque na sua lista para assistir depois");
		}
	}
}
