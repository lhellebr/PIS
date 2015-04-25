package org.fit.pis.data;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.fit.pis.data.Ucet;

@Entity
@Table(name = "skupina")
public class Skupina {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String oznaceni;
	@Temporal(DATE)
	private Date datumUdeleni;
	@Temporal(DATE)
	private Date platnostDo;
	private String harmonizacniKod;
	@OneToOne(cascade = { ALL }, fetch = EAGER)
	private Ucet urednik;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOznaceni() {
		return oznaceni;
	}
	public void setOznaceni(String oznaceni) {
		this.oznaceni = oznaceni;
	}
	public Date getDatumUdeleni() {
		return datumUdeleni;
	}
	public void setDatumUdeleni(Date datumUdeleni) {
		this.datumUdeleni = datumUdeleni;
	}
	public Date getPlatnostDo() {
		return platnostDo;
	}
	public void setPlatnostDo(Date platnostDo) {
		this.platnostDo = platnostDo;
	}
	public String getHarmonizacniKod() {
		return harmonizacniKod;
	}
	public void setHarmonizacniKod(String harmonizacniKod) {
		this.harmonizacniKod = harmonizacniKod;
	}
	public Ucet getUrednik() {
		return urednik;
	}
	public void setUrednik(Ucet urednik) {
		this.urednik = urednik;
	}
	
	
}
