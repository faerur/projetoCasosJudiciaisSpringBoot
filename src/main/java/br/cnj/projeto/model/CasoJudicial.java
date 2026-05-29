package br.cnj.projeto.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CasosJudiciais")
public class CasoJudicial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	private char decisao;
	private String descricao;
	
	
	
	public CasoJudicial() {
	}


	public CasoJudicial(char decisao, String descricao) {
		this.decisao = decisao;
		this.descricao = descricao;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public char getDecisao() {
		return decisao;
	}


	public void setDecisao(char decisao) {
		this.decisao = decisao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	
	
	
}
