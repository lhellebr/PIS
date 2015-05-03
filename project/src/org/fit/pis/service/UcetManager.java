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
    
    public Integer adminsTotal()
    {
    	Integer count = (int)(long)em.createQuery("SELECT COUNT(u) FROM Ucet u").getSingleResult();
    	return count;
    }
    
    public void install()
    {
    	try {
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('admin',	'ADMINISTRATOR',	'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'ADMINISTRATOR', `PASSWORD` = 'OaqgsjzywnkBTEc7ymLeqFr5OcYETtamkpEzL1Z4rig=$Pf3NfHJ95bXJPWL35O2VOltlvH744cbrKqKGdPdeSUe6dNrA8V5xIpw9lfA2rf/aRC1bsiLlbZLoZ14WPAEXlQ==';").executeUpdate();
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('policista',	'POLICISTA',	'haGv4+CU58Y1W8JM9KgaVmfQGJkKDkq00CPMasRqCAw=$Eo0UNUsjkNW5WLxsDFml4C5UHcvwdbtMhK3jxriQhGY8+lPXaM+qNHMNWisnYKdK5YKx3VTpuTNGiCJIeIV1/A==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'POLICISTA', `PASSWORD` = 'haGv4+CU58Y1W8JM9KgaVmfQGJkKDkq00CPMasRqCAw=$Eo0UNUsjkNW5WLxsDFml4C5UHcvwdbtMhK3jxriQhGY8+lPXaM+qNHMNWisnYKdK5YKx3VTpuTNGiCJIeIV1/A==';").executeUpdate();
			em.createNativeQuery("INSERT INTO `ucet` (`LOGIN`, `OPRAVNENI`, `PASSWORD`) VALUES ('urednik',	'UREDNIK',	'O9ZdRfNw+K22rvxB8ueWPkQpYxv4LRRPy8BWDxSWiLY=$xUUPbibsTCoerSoZxKEcb3FxzytN+Oc8T51unj66iVn/UhO0dr/walOjKqt9cOGD/m0TZ0u+MKboY8uharq95A==') ON DUPLICATE KEY UPDATE `LOGIN` = 'admin', `OPRAVNENI` = 'UREDNIK', `PASSWORD` = 'O9ZdRfNw+K22rvxB8ueWPkQpYxv4LRRPy8BWDxSWiLY=$xUUPbibsTCoerSoZxKEcb3FxzytN+Oc8T51unj66iVn/UhO0dr/walOjKqt9cOGD/m0TZ0u+MKboY8uharq95A==';").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
