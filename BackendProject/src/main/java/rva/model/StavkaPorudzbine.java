package rva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class StavkaPorudzbine {

	@Id
	@SequenceGenerator(name = "stavka_porudzbine_seq", sequenceName = "stavka_porudzbine_seq",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stavka_porudzbine_seq")
	private long id;
	private int redniBroj;
	private double kolicina;
	private String jedinicaMere;
	private double cena;
	
	@ManyToOne
	@JoinColumn(name = "artikl")
	private Artikl artikl;
	
	@ManyToOne
	@JoinColumn(name = "porudzbina")
	private Porudzbina porudzbina;
	
	public StavkaPorudzbine() {
		
	}

	public StavkaPorudzbine(int redniBroj, double kolicina, String jedinicaMere, double cena) {
		super();
		this.redniBroj = redniBroj;
		this.kolicina = kolicina;
		this.jedinicaMere = jedinicaMere;
		this.cena = cena;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

}
