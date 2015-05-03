package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.fit.pis.service.UcetManager;

@ManagedBean
@SessionScoped
public class InstallBean
{
	@EJB
	private UcetManager ucetMgr;
    
    public UcetManager getUcetMgr() {
		return ucetMgr;
	}

	public void setUcetMgr(UcetManager ucetMgr) {
		this.ucetMgr = ucetMgr;
	}
	
	public String checkTotalUsers() {
		if (this.ucetMgr.adminsTotal() == 0) {
			this.ucetMgr.install();
		}
		return "";
	}

}
