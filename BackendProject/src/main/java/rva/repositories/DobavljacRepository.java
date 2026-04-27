package rva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Dobavljac;

public interface DobavljacRepository extends JpaRepository<Dobavljac, Long> {

	List<Dobavljac> findByNazivContainingIgnoreCase(String naziv);
	}
