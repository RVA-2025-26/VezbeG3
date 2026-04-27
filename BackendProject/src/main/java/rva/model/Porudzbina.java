package rva.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Porudzbina {

	@Id
	@SequenceGenerator(name = "porudzbina_seq", sequenceName = "porudzbina_seq",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "porudzbina_seq")
	private long id;
	private Date datumPorudzbine;
	private Date datumIsporuke;
	private double iznos;
	private boolean placeno;
	
	@ManyToOne
	@JoinColumn(name = "dobavljac")
	private Dobavljac dobavljac;
	
	@OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL)
	private List<StavkaPorudzbine> stavkePorudzbine;
	
	public Porudzbina() {
		
	}

	public Porudzbina(Date datumPorudzbine, Date datumIsporuke, double iznos, boolean placeno) {
		super();
		this.datumPorudzbine = datumPorudzbine;
		this.datumIsporuke = datumIsporuke;
		this.iznos = iznos;
		this.placeno = placeno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatumPorudzbine() {
		return datumPorudzbine;
	}

	public void setDatumPorudzbine(Date datumPorudzbine) {
		this.datumPorudzbine = datumPorudzbine;
	}

	public Date getDatumIsporuke() {
		return datumIsporuke;
	}

	public void setDatumIsporuke(Date datumIsporuke) {
		this.datumIsporuke = datumIsporuke;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public boolean isPlaceno() {
		return placeno;
	}

	public void setPlaceno(boolean placeno) {
		this.placeno = placeno;
	}

}
