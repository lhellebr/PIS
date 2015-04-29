package org.fit.pis.data;

import java.util.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name="vozidlo")
public class Vozidlo 
{
	private String vin;
    @Id
    private String rz;
    private String tovarniZnacka;
    private String obchOznaceni;
    private String druhVozidla;
    private int    hmotnost;
    private int    zdvihovyObjem;
    private String palivo;
    private int    maxVykon;
    private int    mistSezeni;
    private int    mistStani;
    private float  vykonHmotnost;
    private int    maxRychlost;
    private String razeni;
    private String barva;
    private String spojovaciZarizeni;
    private String jine;
    @Temporal(DATE)
    private Date   datumPrihlaseni;
    @Temporal(DATE)
    private Date   datumOdhlaseni;
    @ManyToOne(cascade = { ALL }, fetch = EAGER)
    private Osoba  owner;
    @OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "vozidlo", orphanRemoval = true)
    private Collection<Kradez> thefts;
	
    public Collection<Vozidlo> nactiVse() {
		return null;
	}
	
    public boolean equals(Object other)
    {
        if (other instanceof Vozidlo)
            return ((Vozidlo) other).getRz().equals(rz);
        else
            return false;
    }
    
	public String toString()
    {
    	return rz;
    }
	
	public boolean getNotStolen()
	{
		return (thefts.size() == 0);
	}
	
	public boolean getStolen()
	{
		return (thefts.size() > 0);
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getRz() {
		return rz;
	}

	public void setRz(String rz) {
		this.rz = rz;
	}

	public String getTovarniZnacka() {
		return tovarniZnacka;
	}

	public void setTovarniZnacka(String tovarniZnacka) {
		this.tovarniZnacka = tovarniZnacka;
	}

	public String getObchOznaceni() {
		return obchOznaceni;
	}

	public void setObchOznaceni(String obchOznaceni) {
		this.obchOznaceni = obchOznaceni;
	}

	public String getDruhVozidla() {
		return druhVozidla;
	}

	public void setDruhVozidla(String druhVozidla) {
		this.druhVozidla = druhVozidla;
	}

	public int getHmotnost() {
		return hmotnost;
	}

	public void setHmotnost(int hmotnost) {
		this.hmotnost = hmotnost;
	}

	public int getZdvihovyObjem() {
		return zdvihovyObjem;
	}

	public void setZdvihovyObjem(int zdvihovyObjem) {
		this.zdvihovyObjem = zdvihovyObjem;
	}

	public String getPalivo() {
		return palivo;
	}

	public void setPalivo(String palivo) {
		this.palivo = palivo;
	}

	public int getMaxVykon() {
		return maxVykon;
	}

	public void setMaxVykon(int maxVykon) {
		this.maxVykon = maxVykon;
	}

	public int getMistSezeni() {
		return mistSezeni;
	}

	public void setMistSezeni(int mistSezeni) {
		this.mistSezeni = mistSezeni;
	}

	public int getMistStani() {
		return mistStani;
	}

	public void setMistStani(int mistStani) {
		this.mistStani = mistStani;
	}

	public float getVykonHmotnost() {
		return vykonHmotnost;
	}

	public void setVykonHmotnost(float vykonHmotnost) {
		this.vykonHmotnost = vykonHmotnost;
	}

	public int getMaxRychlost() {
		return maxRychlost;
	}

	public void setMaxRychlost(int maxRychlost) {
		this.maxRychlost = maxRychlost;
	}

	public String getRazeni() {
		return razeni;
	}

	public void setRazeni(String razeni) {
		this.razeni = razeni;
	}

	public String getBarva() {
		return barva;
	}

	public void setBarva(String barva) {
		this.barva = barva;
	}

	public String getSpojovaciZarizeni() {
		return spojovaciZarizeni;
	}

	public void setSpojovaciZarizeni(String spojovaciZarizeni) {
		this.spojovaciZarizeni = spojovaciZarizeni;
	}

	public String getJine() {
		return jine;
	}

	public void setJine(String jine) {
		this.jine = jine;
	}

	public Date getDatumPrihlaseni() {
		return datumPrihlaseni;
	}

	public void setDatumPrihlaseni(Date datumPrihlaseni) {
		this.datumPrihlaseni = datumPrihlaseni;
	}

	public Date getDatumOdhlaseni() {
		return datumOdhlaseni;
	}

	public void setDatumOdhlaseni(Date datumOdhlaseni) {
		this.datumOdhlaseni = datumOdhlaseni;
	}

	public Osoba getOwner() {
		return owner;
	}

	public void setOwner(Osoba owner) {
		this.owner = owner;
	}

	public Collection<Kradez> getThefts() {
		return thefts;
	}

	public void setThefts(Collection<Kradez> thefts) {
		this.thefts = thefts;
	}
	
}
