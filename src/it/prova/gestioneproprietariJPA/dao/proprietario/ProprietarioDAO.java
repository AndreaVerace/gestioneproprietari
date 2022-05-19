package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {
	
	public Proprietario getEagerAutomobili(long id) throws Exception;
	
	public List<Proprietario> contaQuantiConImmatricolazioneAPartire(int annoimmatricolazione);

}
