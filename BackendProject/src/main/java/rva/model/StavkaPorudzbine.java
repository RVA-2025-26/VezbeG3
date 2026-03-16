package rva.model;

public class StavkaPorudzbine {

	private long id;
	private int redniBroj;
	private double kolicina;
	private String jedinicaMere;
	private double cena;

	public StavkaPorudzbine(long id, int redniBroj, double kolicina, String jedinicaMere, double cena) {
		super();
		this.id = id;
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
