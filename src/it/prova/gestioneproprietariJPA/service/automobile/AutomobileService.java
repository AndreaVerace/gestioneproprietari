package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;
import it.prova.gestioneproprietariJPA.model.Proprietario;


public interface AutomobileService {

	public List<Automobile> listAllAutomobili() throws Exception;

	public Automobile caricaSingoloAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;

	
	//per injection
	public void setAutomobileDAO(AutomobileDAO automobileDAO);
	
	public List<Automobile> proprietariCheHannoCFCheIniziaCon(String cf);
	
	public List<Automobile> autoConErrori(Date datanascita);
	
	
}
