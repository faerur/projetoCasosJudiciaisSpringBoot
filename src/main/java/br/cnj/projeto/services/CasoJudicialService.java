package br.cnj.projeto.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import br.cnj.projeto.util.CasoJudicial;

@Service
public class CasoJudicialService {

	private List<CasoJudicial> casos;
	
	public CasoJudicialService() {
		casos = new ArrayList<CasoJudicial>(Arrays.asList(new CasoJudicial[] {
				new CasoJudicial(1, "A", "Caso 1"), new CasoJudicial(2, "I", "Caso 2"), 
				new CasoJudicial(3, "I", "Caso 3"), new CasoJudicial(4, "A", "Caso 4")
		}));
	}



	public List<CasoJudicial> consultaTodosOsCasos(){
		return casos;
	}
	
	public CasoJudicial pegarCasoPorId(int id) {
		for(CasoJudicial caso: casos) {
			if(caso.getNumero() == id) {
				return caso;
			}
		}
		return null;
	}
	
	public CasoJudicial criarNovoCaso(CasoJudicial caso) {
		casos.add(caso);
		return caso;
	}



	public CasoJudicial atualizarCaso(int id, CasoJudicial casoAtualizado) {
		casos.remove(pegarCasoPorId(id));
		casos.add(casoAtualizado);
		return casoAtualizado;
	}



	public void deletarCaso(int id) {
		casos.remove(pegarCasoPorId(id));
		
	}



	public boolean existe(CasoJudicial novoCaso) {
		for(CasoJudicial caso: casos) {
			if(novoCaso.getNumero() == caso.getNumero()) {
				return true;
			}
		}
		return false;
	}



}
