package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	DIARIA(1), SEMANAL(7);
	
	private int fator;
	
	Periodicidade(int fator) {
		this.fator = fator;
	}
	
	public int getFator() {
		return fator;
	}
}
