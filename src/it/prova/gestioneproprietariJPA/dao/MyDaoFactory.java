package it.prova.gestioneproprietariJPA.dao;

import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAOImpl;
import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAOImpl;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static ProprietarioDAO proprietarioDAOInstance = null;
	private static AutomobileDAO automobileDAOInstance = null;

	public static ProprietarioDAO getProprietarioDAOInstance() {
		if (proprietarioDAOInstance == null)
			proprietarioDAOInstance = new ProprietarioDAOImpl();
		return proprietarioDAOInstance;
	}

	public static AutomobileDAO getAutomobileDAOInstance(){
		if(automobileDAOInstance == null)
			automobileDAOInstance= new AutomobileDAOImpl();
		return automobileDAOInstance;
	}

}
