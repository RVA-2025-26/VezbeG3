package rva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Artikl;
import rva.model.Porudzbina;
import rva.model.StavkaPorudzbine;

public interface StavkaPorudzbineRepository extends JpaRepository<StavkaPorudzbine, Long> {

	List<StavkaPorudzbine> findByCenaLessThan (double cena);
	List<StavkaPorudzbine> findByArtikl (Artikl artikl);
	List<StavkaPorudzbine> findByPorudzbina (Porudzbina porudzbina);
}
