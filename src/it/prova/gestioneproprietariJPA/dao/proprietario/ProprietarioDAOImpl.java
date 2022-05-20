package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Proprietario> contaQuantiConImmatricolazioneAPartire(int annoimmatricolazione) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Proprietario getEagerAutomobili(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
