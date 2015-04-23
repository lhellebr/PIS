/**
 * Stateless bean pro pr�ci s daty osoby
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Vozidlo;
import org.fit.pis.data.Osoba;


@Stateless
public class OsobaManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(Osoba p)
    {
    	em.merge(p);
    }
	
    public void remove(Osoba p)
    {
    	em.remove(em.merge(p));
    }
    
    public Osoba find(String id)
    {
    	return em.find(Osoba.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Osoba> findAll()
    {
    	return em.createQuery("SELECT o FROM Osoba o").getResultList();
    }
    
    public List<Osoba> findSubstring(String substring)
    {
    	String sub = "%" + substring + "%";
        @SuppressWarnings("unchecked")
		List<Osoba> ret = em.createQuery("SELECT o FROM Osoba o WHERE CONCAT(o.jmeno,' ',o.prijmeni) LIKE :sub").setParameter("sub", sub).getResultList();
    	return ret;
    }

}
