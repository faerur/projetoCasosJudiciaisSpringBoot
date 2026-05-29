package br.cnj.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnj.projeto.model.CasoJudicial;

@Repository
public interface CasoJudicialRepository extends JpaRepository<CasoJudicial, Integer>{
	CasoJudicial findByNumero(int numero);
}
