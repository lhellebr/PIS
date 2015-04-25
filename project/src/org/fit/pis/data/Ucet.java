package org.fit.pis.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ucet {
	public enum Opravneni{
		ADMINISTRATOR, UREDNIK, POLICISTA
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String login;
	private String password;
	private Opravneni opravneni;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Opravneni getOpravneni() {
		return opravneni;
	}
	public void setOpravneni(Opravneni opravneni) {
		this.opravneni = opravneni;
	}
}
