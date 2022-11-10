package br.ce.wcaquino.entidades;

import java.util.Date;

public class NotaAluguel {
	
	private int preco;
	private Date dataEntrega;

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntega(Date time) {
		dataEntrega = time;
		
	}
}