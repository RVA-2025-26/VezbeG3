package rva.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Artikl;
import rva.services.ArtiklService;

@RestController
public class ArtiklController {

	@Autowired
	private ArtiklService service;
	
//	1. Spring registruje http zahtev i prenosi ga odgovarajucem bean-u sa anotacijom @RestController
//	2. U kontroleru postoji anotacija koja prihvata specifican zahtev po metodi i resursu
//	3. Zahtev se prosledjuje metodi cija se anotacija poklapa sa tim parametrima
//	4. Izvrsava se logika te metode
//	5. Kontroler vraca Http odgovor - koji se sastoji od header-a, tela i statusnog koda
	
	@GetMapping("/artikls")
	public ResponseEntity<?> getArtikls(@RequestParam(required = false) String naziv,
			@RequestParam(required = false) Long id){
		if(naziv != null && id == null) {
			List<Artikl> artikls = service.getArtiklsByNaziv(naziv);
			if(artikls.isEmpty()) return ResponseEntity.status(404)
					.body(String.format("Artikl with naziv: %s does not exist", naziv));
			return ResponseEntity.ok(artikls);
		}else if(naziv == null && id !=null) {
			Optional<Artikl> artikl = service.findById(id);
			if(artikl.isEmpty()) return ResponseEntity.status(404)
					.body(String.format("Artikl with ID: %s does not exist", id));
			return ResponseEntity.ok(artikl);
		}else if(naziv !=null && id !=null) {
			return ResponseEntity.status(400).body("Only one query parameter can be used!");
		}else {
			return ResponseEntity.ok(service.getAll());
		}
	}
	
	@PostMapping("/artikls")
	public ResponseEntity<?> createArtikl(@RequestBody Artikl artikl){
		 Artikl savedArtikl = service.create(artikl);
		 URI uri = URI.create(String.format("/artikls?id=%s", savedArtikl.getId()));
		 return ResponseEntity.created(uri).body(savedArtikl);
	}
	
	@PutMapping("/artikls")
	public ResponseEntity<?> updateArtikl(@RequestBody Artikl artikl,
			@RequestParam Long id){
		Optional<Artikl> updatedArtikl = service.update(artikl, id);
		if(updatedArtikl.isEmpty()) return ResponseEntity.status(400)
				.body(String.format("Resource with requested ID: %s does not exist", id));
		return ResponseEntity.ok(updatedArtikl);
	}
	
	@DeleteMapping("/artikls")
	public ResponseEntity<?> deleteArtikl(@RequestParam Long id){
		if(!service.existsById(id)) return ResponseEntity.status(400)
				.body(String.format("Resource with requested ID: %s does not exist", id));
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
}
