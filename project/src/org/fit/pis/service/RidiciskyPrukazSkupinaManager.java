/**
 * Stateless bean pro praci s daty skupin ridicskeho prukazu
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.RidicskyPrukazSkupina;
import org.fit.pis.data.Skupina;


@Stateless
public class RidiciskyPrukazSkupinaManager 
{
    @PersistenceContext
    private EntityManager em;

    public void save(RidicskyPrukazSkupina p)
    {
        em.merge(p);
    }
    
    public void remove(RidicskyPrukazSkupina p)
    {
        em.remove(em.merge(p));
    }
    
    public RidicskyPrukazSkupina find(int id)
    {
        return em.find(RidicskyPrukazSkupina.class, id);
    }
    
    public Skupina findSkupina(int id)
    {
        return em.find(Skupina.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Skupina> findAllSkupina()
    {
        return em.createQuery("SELECT p FROM Skupina p ORDER BY p.oznaceni")
                .getResultList();
    }
}
