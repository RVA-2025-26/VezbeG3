package rva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Dobavljac;
import rva.model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {

	List<Porudzbina> findByIznosLessThan (double iznos);
	List<Porudzbina> findByPlacenoEquals (boolean placeno);
	
	List<Porudzbina> findByDobavljac (Dobavljac dobavljac);
}
