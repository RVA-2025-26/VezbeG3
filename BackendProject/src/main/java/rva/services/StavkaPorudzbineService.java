package rva.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rva.model.Artikl;
import rva.model.Porudzbina;
import rva.model.StavkaPorudzbine;

@Service
public interface StavkaPorudzbineService extends CrudService<StavkaPorudzbine> {

	List<StavkaPorudzbine> getStavkasByArtikl (Artikl artikl);
	List<StavkaPorudzbine> getStavkasByPorudzbina (Porudzbina porudzbina);
	List<StavkaPorudzbine> getStavkasByCenaLessThan (double cena);
}
