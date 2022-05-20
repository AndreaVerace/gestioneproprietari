package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietariJPA.model.Proprietario;



public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario",Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario o) throws Exception {
		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Proprietario o) throws Exception {
		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);

	}

	@Override
	public void delete(Proprietario o) throws Exception {

		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<Proprietario> contaQuantiConImmatricolazioneAPartire(int annoimmatricolazione) throws Exception {
		if(annoimmatricolazione < 1980)
			throw new Exception ("valore non valido");
		
		TypedQuery<Proprietario> query = entityManager.createQuery("select distinct p from Proprietario p join p.automobili a where a.annoImmatricolazione > ?1",Proprietario.class);
		return query.setParameter(1, annoimmatricolazione).getResultList();
		
		// se devo ritornare un int aggiungo il .size() a .getResultList()
	}


	@Override
	public Proprietario getEagerAutomobili(long id) throws Exception {
		TypedQuery<Proprietario> query = entityManager
				.createQuery("from Proprietario p left join fetch p.automobili where p.id = ?1", Proprietario.class);
		query.setParameter(1, id);
		
		return query.getResultStream().findFirst().orElse(null);
	}


	

}
