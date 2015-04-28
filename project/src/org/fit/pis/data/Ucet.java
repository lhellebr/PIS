package org.fit.pis.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ucet")
public class Ucet {
	public enum Opravneni{
		ADMINISTRATOR, UREDNIK, POLICISTA
	}
	
	@Id
	private String login;
	private String password;
	@Enumerated(EnumType.STRING)
	private Opravneni opravneni;
	
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
    public boolean verifyPassword(String password){
    	return password.equals(this.password);
    }
}
