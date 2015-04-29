package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Vozidlo;
import org.fit.pis.data.Kradez;


@Stateless
public class KradezManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(Kradez k)
    {
    	em.merge(k);
    }
	
    public void remove(Kradez k)
    {
    	em.remove(em.merge(k));
    }
    
    public Kradez find(String id)
    {
    	return em.find(Kradez.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Kradez> findAll()
    {
    	return em.createQuery("SELECT k FROM Kradez k").getResultList();
    }

    
    @SuppressWarnings("unchecked")
    public List<Kradez> findByCar(Vozidlo car)
    {
    	return em.createQuery("SELECT k FROM Kradez k WHERE k.vozidlo_rz = :rz").setParameter("rz", car.getRz()).getResultList();
    }
}
