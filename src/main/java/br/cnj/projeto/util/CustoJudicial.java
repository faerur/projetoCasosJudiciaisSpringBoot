package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {

	public double adicionarCusto(int anoJulgamento) {
		if(anoJulgamento >= 2024) {
			return 20;
		}
		return 10;
	}

}
