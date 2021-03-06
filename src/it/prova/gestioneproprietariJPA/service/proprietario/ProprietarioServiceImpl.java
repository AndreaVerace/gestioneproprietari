package it.prova.gestioneproprietariJPA.service.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;


public class ProprietarioServiceImpl implements ProprietarioService {

	private ProprietarioDAO proprietarioDAO;
	
	@Override
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}
	
	
	@Override
	public List<Proprietario> listAllProprietari() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public Proprietario caricaSingoloProprietario(Long id) throws Exception {
		
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				// uso l'injection per il dao
				proprietarioDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				return proprietarioDAO.get(id);
	
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}	
	}

	@Override
	public Proprietario caricaSingoloProprietarioConAutomobili(Long id) throws Exception {
	
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				// uso l'injection per il dao
				proprietarioDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				return proprietarioDAO.getEagerAutomobili(id);
	
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
	}

	@Override
	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// questo ?? come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.update(proprietarioInstance);

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
	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo ?? come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.insert(proprietarioInstance);

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
	public void rimuovi(Proprietario proprietarioInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		
		try {
			// questo ?? come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.delete(proprietarioInstance);

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
	public List<Proprietario> contaQuantiConImmatricolazioneAPartire(int annoimmatricolazione) throws Exception {
		
	EntityManager entityManager = EntityManagerUtil.getEntityManager();
			
			try {
				// uso l'injection per il dao
				proprietarioDAO.setEntityManager(entityManager);
	
				// eseguo quello che realmente devo fare
				return proprietarioDAO.contaQuantiConImmatricolazioneAPartire(annoimmatricolazione);
	
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
		
	}


}
