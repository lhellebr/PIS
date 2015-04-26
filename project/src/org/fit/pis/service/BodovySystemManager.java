package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.BodovySystem;


@Stateless
public class BodovySystemManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(BodovySystem b)
    {
    	em.merge(b);
    }
	
    public void remove(BodovySystem b)
    {
    	em.remove(em.merge(b));
    }
    
    public BodovySystem find(String id)
    {
    	return em.find(BodovySystem.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<BodovySystem> findAll()
    {
    	return em.createQuery("SELECT b FROM BodovySystem b").getResultList();
    }
}
