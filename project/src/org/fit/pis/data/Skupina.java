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
		
}
