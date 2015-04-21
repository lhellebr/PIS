/**
 * Stateless bean pro pr�ci s daty osoby
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    @SuppressWarnings("unchecked")
    public List<Osoba> findAll()
    {
    	return em.createQuery("SELECT o FROM Osoba o").getResultList();
    }

}
