package rva.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rva.model.Dobavljac;

@Service
public interface DobavljacService extends CrudService<Dobavljac> {

	List<Dobavljac> getDobavljacsByNaziv (String naziv);
}
