/**
 * Stateless bean pro praci s daty uctu
 */
package org.fit.pis.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    public Integer adminsTotal()
    {
    	Integer count = (int)(long)em.createQuery("SELECT COUNT(u) FROM Ucet u").getSingleResult();
    	return count;
    }
    
    public void install()
    {
    	try {
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('admin',	'ADMINISTRATOR',	'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'ADMINISTRATOR', `PASSWORD` = 'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==';").executeUpdate();
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('policista',	'POLICISTA',	'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'ADMINISTRATOR', `PASSWORD` = 'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==';").executeUpdate();
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('urednik',	'UREDNIK',	'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'ADMINISTRATOR', `PASSWORD` = 'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==';").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
