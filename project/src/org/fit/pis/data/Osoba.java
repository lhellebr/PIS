package org.fit.pis.data;

import java.util.Collection;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "osoba")
public class Osoba
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
	private long id;
	private String jmeno;
    private String prijmeni;
    private String mistoNarozeni;
    private String bydlisteObec;
    @OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "owner", orphanRemoval = true)
	private Collection<Vozidlo> vozidla;
	@OneToMany(cascade = { ALL }, fetch = EAGER)
	private Collection<BodovySystem> bodovySystem;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "osoba", orphanRemoval = true)
	private Collection<RidicskyPrukaz> ridicskePrukazy;

    public Osoba()
    {
        vozidla = new Vector<Vozidlo>();
        ridicskePrukazy = new Vector<RidicskyPrukaz>();
    }
    
    public Collection<RidicskyPrukaz> getRidicskePrukazy()
    {
        return ridicskePrukazy;
    }
    
    public void setPrukazy(Collection<RidicskyPrukaz> ridicskePrukazy)
    {
        this.ridicskePrukazy = ridicskePrukazy;
    }
    
    public Collection<Vozidlo> getVozidla()
    {
        return vozidla;
    }

    public void setVozidla(Collection<Vozidlo> vozidla)
    {
        this.vozidla = vozidla;
    }

    /**
     * @return the name
     */
    public String getJmeno()
    {
        return jmeno;
    }
    
    /**
     * @param name the name to set
     */
    public void setJmeno(String jmeno)
    {
        this.jmeno = jmeno;
    }
    
    /**
     * @return the surname
     */
    public String getPrijmeni()
    {
        return prijmeni;
    }
    
    /**
     * @param surname the surname to set
     */
    public void setPrijmeni(String prijmeni)
    {
        this.prijmeni = prijmeni;
    }
    
    /**
     * @return the rc
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * @param rc the rc to set
     */
    public void setId(long id)
    {
        this.id = id;
    }
    
    
    @Override
    public String toString()
    {
        return "Person: " + jmeno + " " + prijmeni + "(" + vozidla.size() + " cars)";
    }

	public String getMistoNarozeni() {
		return mistoNarozeni;
	}

	public void setMistoNarozeni(String mistoNarozeni) {
		this.mistoNarozeni = mistoNarozeni;
	}

	public String getBydlisteObec() {
		return bydlisteObec;
	}

	public void setBydlisteObec(String bydlisteObec) {
		this.bydlisteObec = bydlisteObec;
	}

	public Collection<BodovySystem> getBodovySystem() {
		return bodovySystem;
	}

	public void setBodovySystem(Collection<BodovySystem> bodovySystem) {
		this.bodovySystem = bodovySystem;
	}
}
