/**
 * Stateless bean pro praci s daty ridicskeho prukazu
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.RidicskyPrukaz;


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
    
    @SuppressWarnings("unchecked")
    public List<RidicskyPrukaz> findAll()
    {
        return em.createQuery("SELECT p FROM RidicskyPrukaz p").getResultList();
    }
}
