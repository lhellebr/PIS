package org.fit.pis.data;

import org.fit.pis.data.Vozidlo;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "kradez")
public class Kradez {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date datumNahlaseni;
	@Temporal(TemporalType.DATE)
	private Date datumNalezeni;
	private String poznamky;
	@ManyToOne(fetch=EAGER)
	private Vozidlo vozidlo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatumNahlaseni() {
		return datumNahlaseni;
	}
	public void setDatumNahlaseni(Date datumNahlaseni) {
		this.datumNahlaseni = datumNahlaseni;
	}
	public Date getDatumNalezeni() {
		return datumNalezeni;
	}
	public void setDatumNalezeni(Date datumNalezeni) {
		this.datumNalezeni = datumNalezeni;
	}
	public String getPoznamky() {
		return poznamky;
	}
	public void setPoznamky(String poznamky) {
		this.poznamky = poznamky;
	}
	public Vozidlo getVozidlo() {
		return vozidlo;
	}
	public void setVozidlo(Vozidlo vozidlo) {
		this.vozidlo = vozidlo;
	}
	
	public String toString()
	{
		return "Vozidlo " + vozidlo + ": " + datumNahlaseni + " - " + datumNalezeni + ": " + poznamky; 
	}
}
