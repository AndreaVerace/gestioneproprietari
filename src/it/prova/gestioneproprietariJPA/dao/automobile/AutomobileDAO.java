package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {
	
public List<Automobile> proprietariCheHannoCFCheIniziaCon(String cf);
	
	public List<Automobile> autoConErrori(Date datanascita);

}
