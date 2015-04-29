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

@Entity
@Table(name = "bodovysystem")
public class BodovySystem {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int body;
	private String zaznam;
	@Temporal(DATE)
	private Date datumUdeleni;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBody() {
		return body;
	}
	public void setBody(int body) {
		this.body = body;
	}
	public String getZaznam() {
		return zaznam;
	}
	public void setZaznam(String zaznam) {
		this.zaznam = zaznam;
	}
	public Date getDatumUdeleni() {
		return datumUdeleni;
	}
	public void setDatumUdeleni(Date datumUdeleni) {
		this.datumUdeleni = datumUdeleni;
	}
}
