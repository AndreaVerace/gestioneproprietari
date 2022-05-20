package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDAO;
	
	
	@Override
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO=automobileDAO;
	}
	
	
	@Override
	public List<Automobile> listAllAutomobili() throws Exception {
		
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				// uso l'injection per il dao
				automobileDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				return automobileDAO.list();
	
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
	}

	@Override
	public Automobile caricaSingoloAutomobile(Long id) throws Exception {
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				// uso l'injection per il dao
				automobileDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				return automobileDAO.caricaSingoloAutomobile(id);
	
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.update(automobileInstance);;

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				entityManager.getTransaction().begin();
				// uso l'injection per il dao
				automobileDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				automobileDAO.insert(automobileInstance);;
	
				
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
		
	}

	@Override
	public void rimuovi(Automobile automobileInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.delete(automobileInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	@Override
	public List<Automobile> proprietariCheHannoCFCheIniziaCon(String cf) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.proprietariCheHannoCFCheIniziaCon(cf);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public List<Automobile> autoConErrori(Date datanascita) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.autoConErrori(datanascita);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

}
