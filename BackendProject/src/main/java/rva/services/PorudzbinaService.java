package rva.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rva.model.Dobavljac;
import rva.model.Porudzbina;

@Service
public interface PorudzbinaService extends CrudService<Porudzbina> {

	List<Porudzbina> getPorudzbinasByPlaceno (boolean placeno);
	List<Porudzbina> getPorudzbinasByIznosLessThan (double iznos);
	List<Porudzbina> getPorudzbinasByDobavljac (Dobavljac dobavljac);
}
