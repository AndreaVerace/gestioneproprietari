package it.prova.gestioneproprietariJPA.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.model.Automobile;
import it.prova.gestioneproprietariJPA.model.Proprietario;
import it.prova.gestioneproprietariJPA.service.MyServiceFactory;
import it.prova.gestioneproprietariJPA.service.automobile.AutomobileService;
import it.prova.gestioneproprietariJPA.service.proprietario.ProprietarioService;


public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {
			
			//testListProprietario(proprietarioService);
			
			//testGetProprietario(proprietarioService);
			
			//testInsertProprietario(proprietarioService);
			
			//testUpdateProprietario(proprietarioService);
			
			//testDeleteProprietario(proprietarioService);
			
			//testInsertAutomobile(proprietarioService, automobileService);
			
			//testListAutomobili(proprietarioService, automobileService);
			
			//testGetAutomobile(proprietarioService, automobileService);
			
			//testUpdateAutomobile(proprietarioService, automobileService);
			
			//testRemoveAutomobile(automobileService);
			
			//testGetEagerProprietario(proprietarioService);
			
			//testQuantiConImmatricolazioneAPartire(proprietarioService, automobileService);
			
			//testProprietariCheHannoCFCheIniziaCon(proprietarioService, automobileService);
			
			//testAutoConErrori(proprietarioService, automobileService);
			
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
		
		Date datanascita = new SimpleDateFormat("dd-MM-yyyy").parse("23-11-1967");
		
		Proprietario nuovoProprietario = new Proprietario("Aldo","Baglio","LDBGLO67",datanascita);
		
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
		
		Proprietario daEliminare = proprietarioService.listAllProprietari().get(4);
		
			proprietarioService.rimuovi(daEliminare);
			
			System.out.println(proprietarioService.listAllProprietari().size());
		
	}
	
	private static void testInsertAutomobile(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		Proprietario dellAutoDaInserire = proprietarioService.listAllProprietari().get(2);
		
		Automobile daInserire = new Automobile("Fiat","Modello15","BF936BF",2018);
		
		daInserire.setProprietario(dellAutoDaInserire);
		
		automobileService.inserisciNuovo(daInserire);
		
		if(daInserire.getId() == null)
			throw new Exception("Test failed.");
		
		System.out.println(daInserire.getId());
	}
	
	private static void testListAutomobili(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		System.out.println("Elementi presenti nella tabella Automobili: " + automobileService.listAllAutomobili().size());
	}
	
	private static void testGetAutomobile(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		long id = automobileService.listAllAutomobili().get(0).getId();
		
		Automobile result = automobileService.caricaSingoloAutomobile(id);
		
		System.out.println(result.getMarca());
	}
	
	private static void testUpdateAutomobile(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		
		Automobile daCambiare =  automobileService.listAllAutomobili().get(6);
		
		daCambiare.setMarca("Fiat");
		daCambiare.setModello("Modello78");
		daCambiare.setTarga("NA094GT");
		daCambiare.setAnnoImmatricolazione(2000);
		daCambiare.setProprietario(proprietarioService.listAllProprietari().get(2));
		
		automobileService.aggiorna(daCambiare);
	}
	
	private static void testRemoveAutomobile(AutomobileService automobileService) throws Exception {
		
		Automobile daEliminare = automobileService.listAllAutomobili().get(6);
		
		automobileService.rimuovi(daEliminare);
		
		System.out.println(automobileService.listAllAutomobili().size());
	}
	
	private static void testGetEagerProprietario(ProprietarioService proprietarioService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		long id = proprietarioService.listAllProprietari().get(0).getId();
		
		Proprietario ricercato = proprietarioService.caricaSingoloProprietarioConAutomobili(id);
	}
	
	private static void testQuantiConImmatricolazioneAPartire(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		int annoImmatricolazioneDiPartenza = 2015;
		
		List<Proprietario> result = proprietarioService.contaQuantiConImmatricolazioneAPartire(annoImmatricolazioneDiPartenza);
		
		System.out.println(result.size());
	}
	
	private static void testProprietariCheHannoCFCheIniziaCon(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		String inizialeCF = "VRC";
		
		List<Automobile> result = automobileService.proprietariCheHannoCFCheIniziaCon(inizialeCF);
		
		System.out.println(result.size());
	}
	
	private static void testAutoConErrori(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if(listaProprietariPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti proprietari.");
		
		List<Automobile> listaAutoiPresenti = automobileService.listAllAutomobili();
		if(listaAutoiPresenti.size() < 1)
			throw new Exception("Test Failed,non sono presenti automobili.");
		
		Date datanascita = new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2003");
		
		List<Automobile> result = automobileService.autoConErrori(datanascita);
		
		System.out.println(result.size());
	}
	
	
	
}
