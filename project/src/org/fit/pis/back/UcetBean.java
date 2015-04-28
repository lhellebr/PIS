package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Osoba;
import org.fit.pis.data.Ucet;
import org.fit.pis.service.UcetManager;


@ManagedBean
@SessionScoped
public class UcetBean
{
	@EJB
	private UcetManager ucetMgr;
	private Ucet ucet;
    
	public UcetManager getUcetMgr() {
		return ucetMgr;
	}

	public void setUcetMgr(UcetManager ucetMgr) {
		this.ucetMgr = ucetMgr;
	}

	public Ucet getUcet() {
		return ucet;
	}

	public void setUcet(Ucet ucet) {
		this.ucet = ucet;
	}

	public List<Ucet> getOsoby(){
		return ucetMgr.findAll();
	}
	
	public String actionNew()
	{
		ucet = new Ucet();
		return "new";
	}
	
    public String actionEdit(Ucet ucet)
    {
    	setUcet(ucet);
    	return "edit";
    }
    
    public String actionDelete(Ucet ucet)
    {
    	ucetMgr.remove(ucet);
    	return "delete";
    }
}
