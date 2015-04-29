package org.fit.pis.data;

import java.math.BigInteger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

import org.fit.pis.enums.Opravneni;

@Entity
@Table(name = "ucet")
public class Ucet {
	private static final Logger log = Logger.getLogger( Ucet.class.getName() );
	
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
	public void setPassword(String password){
		byte[] salt;
		try {
			salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(32);
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 512);
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			byte[] hash = f.generateSecret(spec).getEncoded();
			this.password = DatatypeConverter.printBase64Binary(salt) + '$' + DatatypeConverter.printBase64Binary(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	public Opravneni getOpravneni() {
		return opravneni;
	}
	public void setOpravneni(Opravneni opravneni) {
		this.opravneni = opravneni;
	}
    public boolean verifyPassword(String password){
    	try {
			String[] parts = this.password.split("\\$");
			byte[] salt = DatatypeConverter.parseBase64Binary(parts[0]);
			byte[] hash = DatatypeConverter.parseBase64Binary(parts[1]);
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 512);
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			byte[] realHash = f.generateSecret(spec).getEncoded();
	    	return Arrays.equals(hash,realHash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return false;
		}
    }

}
