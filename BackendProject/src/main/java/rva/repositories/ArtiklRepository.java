package rva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rva.model.Artikl;

@Repository
public interface ArtiklRepository extends JpaRepository<Artikl, Long> {

	List<Artikl> findByNazivLike(String naziv);
}
