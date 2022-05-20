package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietariJPA.model.Automobile;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;
		
		public void setEntityManager(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
	
	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile",Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile o) throws Exception {
		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Automobile o) throws Exception {
		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);

	}

	@Override
	public void delete(Automobile o) throws Exception {
		if(o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}


	@Override
	public List<Automobile> proprietariCheHannoCFCheIniziaCon(String cf) throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery("select distinct a from Automobile a join a.proprietario p where p.codiceFiscale like ?1",Automobile.class);
		return query.setParameter(1, cf + "%").getResultList();
	}

	@Override
	public List<Automobile> autoConErrori(Date datanascita) throws Exception {
		TypedQuery<Automobile> query =  entityManager.createQuery("select a from Automobile a join a.proprietario p where p.dataNascita > ?1",Automobile.class);
		return query.setParameter(1, datanascita).getResultList();
	}

	

	

}
