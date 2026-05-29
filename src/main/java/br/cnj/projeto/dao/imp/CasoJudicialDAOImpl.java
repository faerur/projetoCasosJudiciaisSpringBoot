package br.cnj.projeto.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cnj.projeto.dao.CasoJudicialDAO;
import br.cnj.projeto.model.CasoJudicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CasoJudicialDAOImpl implements CasoJudicialDAO{
//Para utilizar JPA basta implementar a interface CasoJudicialRepository
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CasoJudicial> findAll() {
		return entityManager.createQuery("SELECT c FROM CasoJudicial c", CasoJudicial.class).getResultList();
	}
	
	@Override
	public CasoJudicial findByID(int id) {
		CasoJudicial caso = entityManager.find(CasoJudicial.class, id);
		return caso;
	}


	@Override
	public List<CasoJudicial> findAll(int page, int pageSize, String sortBy, String sortOrder) {
		int offset = (page - 1) * pageSize;
		String queryString = "SELECT c FROM CasoJudicial c ORDER BY c." + sortBy + " " + sortOrder;
		return entityManager.createQuery(queryString, CasoJudicial.class)
				.setFirstResult(offset)
				.setMaxResults(pageSize)
				.getResultList();
		
	}

	@Transactional
	@Override
	public void save(CasoJudicial casoJudicial) {
		entityManager.persist(casoJudicial);
		
	}

	@Override
	public void update(CasoJudicial casoJudicial) {
	entityManager.merge(casoJudicial);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		CasoJudicial caso = entityManager.find(CasoJudicial.class, id);
		if(caso != null) {
			entityManager.remove(caso);
		} 
		
	}

}
