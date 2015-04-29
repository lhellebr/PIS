package org.fit.pis.service;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Vozidlo;



@Stateless
public class VozidloManager 
{
    @PersistenceContext
    private EntityManager em;

    public Vozidlo find(String id)
    {
    	return em.find(Vozidlo.class, id);
    }
    
    public List<Vozidlo> findBegining(String id)
    {
        String pref = id + "%";
        @SuppressWarnings("unchecked")
		List<Vozidlo> ret = em.createQuery("SELECT v FROM Vozidlo v WHERE v.rz LIKE :pref").setParameter("pref", pref).getResultList();
    	return ret;
    }
    
    public void save(Vozidlo p)
    {
    	em.merge(p);
    }
	
    public void remove(Vozidlo p)
    {
    	em.remove(em.merge(p));
    }
    
    @SuppressWarnings("unchecked")
	public List<Vozidlo> findAll()
    {
    	return em.createQuery("SELECT v FROM Vozidlo v").getResultList();
    }

}
