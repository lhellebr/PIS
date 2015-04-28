/**
 * Stateless bean pro praci s daty uctu
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Ucet;

@Stateless
public class UcetManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(Ucet p)
    {
    	em.merge(p);
    }
	
    public void remove(Ucet p)
    {
    	em.remove(em.merge(p));
    }
    
    public Ucet find(String login)
    {
    	return em.find(Ucet.class, login);
    }
    
    @SuppressWarnings("unchecked")
    public List<Ucet> findAll()
    {
    	return em.createQuery("SELECT u FROM Ucet u").getResultList();
    }

}
