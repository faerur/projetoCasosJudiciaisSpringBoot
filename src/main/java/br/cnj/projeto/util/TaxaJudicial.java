package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {

	public double adicionarTaxa(String estado) {
		if(estado.equals("RJ")) {
			return 20;
		}
		return 10;
	}
	
}
