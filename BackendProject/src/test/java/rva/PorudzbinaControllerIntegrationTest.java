package rva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rva.model.Porudzbina;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PorudzbinaControllerIntegrationTest {
	
	static RestTemplate template = new RestTemplate();
	static String apiUrl = "http://localhost:8080/porudzbinas";
	static long largestId = 0;

	@Test
	@Order(1)
	void getAllPorudzbinas() {
		ResponseEntity<List<Porudzbina>> response = 
				template.exchange(apiUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Porudzbina>>() {});
		
		assertEquals(200, response.getStatusCode().value());
		assertNotEquals(0, response.getBody().size());
		
	}
	
	@Test
	@Order(2)
	void getPorudzbinaById() {
		int id = 3;
		
		ResponseEntity<Porudzbina> response = 
				template.exchange(apiUrl + "?id=" + id, HttpMethod.GET, null, 
				Porudzbina.class);
		
		assertEquals(200, response.getStatusCode().value());
		assertEquals(id, response.getBody().getId());
		
	}
	
	
	@Test
	@Order(3)
	void getPorudzbinaByDobavljac() {
		int foreignKey = 3;
		
		ResponseEntity<List<Porudzbina>> response = 
				template.exchange(apiUrl + "/dobavljac?dobavljacId=" + foreignKey, 
						HttpMethod.GET, null, 
						new ParameterizedTypeReference<List<Porudzbina>>() {});
		
		assertEquals(200, response.getStatusCode().value());
		for(Porudzbina p: response.getBody()) {
			assertEquals(foreignKey, p.getDobavljac().getId());
		}
		
	}
	
	@Test
	@Order(4)
	void getPorudzbinaByNaziv() {
		boolean placeno = true;
		
		ResponseEntity<List<Porudzbina>> response = 
				template.exchange(apiUrl + "?placeno=" + placeno, 
						HttpMethod.GET, null, 
						new ParameterizedTypeReference<List<Porudzbina>>() {});
		
		assertEquals(200, response.getStatusCode().value());
		for(Porudzbina p: response.getBody()) {
			assertEquals(placeno, p.isPlaceno());
		}
		
	}
	
	@Test
	@Order(5)
	void createPorudzbina() {
		Porudzbina porudzbina = new Porudzbina();
		
		porudzbina.setPlaceno(true);
		porudzbina.setIznos(2000);
		
		HttpEntity<Porudzbina> entity = new HttpEntity<Porudzbina>(porudzbina);
		
		ResponseEntity<Porudzbina> response =
		template.exchange(apiUrl, HttpMethod.POST, entity, Porudzbina.class);
		
		assertEquals(201, response.getStatusCode().value());
		assertEquals(porudzbina.getIznos(), response.getBody().getIznos());
		assertEquals(porudzbina.isPlaceno(), response.getBody().isPlaceno());
		
		if(largestId < response.getBody().getId()) largestId = response.getBody().getId();
	}
	
	@Test
	@Order(6)
	void updatePorudzbina() {
		Porudzbina porudzbina = new Porudzbina();
		
		porudzbina.setPlaceno(false);
		porudzbina.setIznos(2500);
		
		HttpEntity<Porudzbina> entity = new HttpEntity<Porudzbina>(porudzbina);
		
		ResponseEntity<Porudzbina> response =
		template.exchange(apiUrl + "?id=" + largestId, HttpMethod.PUT, entity, Porudzbina.class);
		
		assertEquals(200, response.getStatusCode().value());
		assertEquals(porudzbina.getIznos(), response.getBody().getIznos());
		assertEquals(porudzbina.isPlaceno(), response.getBody().isPlaceno());
		
	}
	
	@Test
	@Order(7)
	void deletePorudzbina(){
		ResponseEntity<?> response =
				template.exchange(apiUrl + "?id=" + largestId, HttpMethod.DELETE, 
						null, Object.class);
		
		assertEquals(204, response.getStatusCode().value());
		assertNull(response.getBody());
	}

}
