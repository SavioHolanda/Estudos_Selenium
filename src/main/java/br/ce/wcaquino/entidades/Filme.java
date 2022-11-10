package br.ce.wcaquino.entidades;

public class Filme {
	
	private int estoque;
	private int aluguel;

	public void setEstoque(int int1) {
		this.estoque = int1;
	}

	public void setAluguel(int int1) {
		this.aluguel = int1;
	}
	
	public int getAluguel() {
		return aluguel;
	}

	public int getEstoque() {
		return estoque;
	}
}