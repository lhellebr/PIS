package org.fit.pis.data;

import java.util.Date;
import java.util.Collection;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;


@Entity
@Table(name = "ridicskyprukaz")
public class RidicskyPrukaz{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Temporal(DATE)
	private Date platnostOd;
	@Temporal(DATE)
	private Date platnostDo;
	private String vydavatel;
	@ManyToOne(cascade = { ALL }, fetch = EAGER)
	private Osoba osoba;
	@OneToMany(orphanRemoval=true, fetch = EAGER)
	private Collection<RidicskyPrukazSkupina> skupiny;
	private int cisloPrukazu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPlatnostOd() {
		return platnostOd;
	}
	public void setPlatnostOd(Date platnostOd) {
		this.platnostOd = platnostOd;
	}
	public Date getPlatnostDo() {
		return platnostDo;
	}
	public void setPlatnostDo(Date platnostDo) {
		this.platnostDo = platnostDo;
	}
	public String getVydavatel() {
		return vydavatel;
	}
	public void setVydavatel(String vydavatel) {
		this.vydavatel = vydavatel;
	}
	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	public Collection<RidicskyPrukazSkupina> getSkupiny() {
		return skupiny;
	}
	public void setSkupiny(Collection<RidicskyPrukazSkupina> skupiny) {
		this.skupiny = skupiny;
	}
	public int getCisloPrukazu() {
		return cisloPrukazu;
	}
	public void setCisloPrukazu(int cislo_prukazu) {
		this.cisloPrukazu = cislo_prukazu;
	}
}
