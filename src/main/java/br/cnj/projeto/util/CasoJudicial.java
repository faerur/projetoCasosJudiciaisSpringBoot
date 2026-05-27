package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

public class CasoJudicial {
	private int numero;
	private String decisao;
	private String descricao;
	
	public CasoJudicial(int numero, String decisao, String descricao) {
		this.numero = numero;
		this.decisao = decisao;
		this.descricao = descricao;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDecisao() {
		return decisao;
	}


	public void setDecisao(String decisao) {
		this.decisao = decisao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	
	
	
}
