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
	@OneToOne(cascade = { ALL }, fetch = EAGER)
	private Ucet urednik;
	@OneToMany(cascade = { ALL }, fetch = EAGER)
	private Collection<Skupina> skupiny;
	
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
	public Ucet getUrednik() {
		return urednik;
	}
	public void setUrednik(Ucet urednik) {
		this.urednik = urednik;
	}
	public Collection<Skupina> getSkupiny() {
		return skupiny;
	}
	public void setSkupiny(Collection<Skupina> skupiny) {
		this.skupiny = skupiny;
	}
}
