/**
 * Stateless bean pro praci s daty ridicskeho prukazu
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.RidicskyPrukaz;
import org.fit.pis.data.Osoba;


@Stateless
public class RidicskyPrukazManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(RidicskyPrukaz p)
    {
        em.merge(p);
    }
    
    public void remove(RidicskyPrukaz p)
    {
        em.remove(em.merge(p));
    }
    
    public RidicskyPrukaz find(String id)
    {
        return em.find(RidicskyPrukaz.class, id);
    }
    
    public RidicskyPrukaz findByNumber(String id)
    {
    	try {
	        List<RidicskyPrukaz> list = em.createQuery("SELECT p FROM RidicskyPrukaz p WHERE p.cisloPrukazu=:cislo")
	        		.setParameter("cislo",Integer.parseInt(id))
	        		.getResultList();
	    	
	        if (list.size() > 0)
	        {
	        	return list.get(0);
	        }
	        else
	        {
	        	return null;
	        }
        
    	} catch (NumberFormatException | NullPointerException ex) {
    		return null;
    	}
    	
    }
    
    @SuppressWarnings("unchecked")
    public List<RidicskyPrukaz> findAll()
    {
        return em.createQuery("SELECT p FROM RidicskyPrukaz p").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<RidicskyPrukaz> findFor(Osoba osoba)
    {
        return em.createQuery("SELECT p FROM RidicskyPrukaz p WHERE Osoba_ID=:osoba_ID")
                .setParameter("osoba_ID", osoba.getId())
                .getResultList();
    }

}
