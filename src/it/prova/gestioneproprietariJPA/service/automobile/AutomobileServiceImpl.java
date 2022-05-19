package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.Date;
import java.util.List;

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
		
		return null;
	}

	@Override
	public Automobile caricaSingoloAutomobile(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Automobile> proprietariCheHannoCFCheIniziaCon(String cf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Automobile> autoConErrori(Date datanascita) {
		// TODO Auto-generated method stub
		return null;
	}

}
