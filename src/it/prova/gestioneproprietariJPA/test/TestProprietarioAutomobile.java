package it.prova.gestioneproprietariJPA.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.model.Proprietario;
import it.prova.gestioneproprietariJPA.service.MyServiceFactory;
import it.prova.gestioneproprietariJPA.service.automobile.AutomobileService;
import it.prova.gestioneproprietariJPA.service.proprietario.ProprietarioService;


public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {
			
			testListProprietario(proprietarioService);
			
			//testGetProprietario(proprietarioService);
			
			//testInsertProprietario(proprietarioService);
			
			//testUpdateProprietario(proprietarioService);
			
			testDeleteProprietario(proprietarioService);
			
		}	catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}
	
	
	private static void testListProprietario(ProprietarioService proprietarioService) throws Exception {
		
		System.out.println("Elementi presenti nella tabella Proprietario: " + proprietarioService.listAllProprietari().size());
	}

	private static void testGetProprietario(ProprietarioService proprietarioService) throws Exception {
		
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		long id = proprietarioService.listAllProprietari().get(0).getId();
		
		Proprietario ricercato = proprietarioService.caricaSingoloProprietario(id);
		
		System.out.println(ricercato.getId());
	}
	
	private static void testInsertProprietario(ProprietarioService proprietarioService) throws Exception {
		
		Date datanascita = new SimpleDateFormat("dd-MM-yyyy").parse("23-11-1998");
		
		Proprietario nuovoProprietario = new Proprietario("Giovanni","Verace","VRCNDR98",datanascita);
		
		if(nuovoProprietario == null)
			throw new Exception("impossibile aggiungere proprietario senza valori");
		
		proprietarioService.inserisciNuovo(nuovoProprietario);
		
		if(nuovoProprietario.getId() == null)
			throw new Exception("test fallito");
		
		System.out.println(nuovoProprietario);
	}
	
	
	private static void testUpdateProprietario(ProprietarioService proprietarioService) throws Exception {
		
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		Date datanascita = new SimpleDateFormat("dd-MM-yyyy").parse("23-11-1967");
		
		Proprietario daCambiare = proprietarioService.listAllProprietari().get(0);
		
		daCambiare.setNome("Teo");
		daCambiare.setCognome("Teocoli");
		daCambiare.setCodiceFiscale("TETCL67");
		daCambiare.setDataNascita(datanascita);
		
		proprietarioService.aggiorna(daCambiare);
		
		System.out.println(proprietarioService.listAllProprietari().get(0).getCodiceFiscale());
	}
	
	
	private static void testDeleteProprietario(ProprietarioService proprietarioService) throws Exception {
		
		Proprietario daEliminare = proprietarioService.listAllProprietari().get(0);
		
		proprietarioService.rimuovi(daEliminare);
		
		System.out.println(proprietarioService.listAllProprietari().size());
		
	}
}
