package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.OsobaManager;
import org.fit.pis.service.VozidloManager;

@ManagedBean
@SessionScoped
public class PoliceBean 
{
	@EJB
	private VozidloManager vozidloMgr;
	private Vozidlo vozidlo;
    private String find;
    private boolean found;
    
    public PoliceBean()
    {
    	vozidlo = new Vozidlo();
    	found = false;
    }
    
    
    public List<Vozidlo> autocomplete(String prefix) 
    {
        return vozidloMgr.findBegining(prefix);
    }
    
        
	public Vozidlo getVozidlo() {
		return vozidlo;
	}
	
	public void setVozidlo(Vozidlo vozidlo) {
		this.vozidlo = vozidlo;
	}
	
	public String getFind() {
		return find;
	}
	
	public void setFind(String find) {
		this.find = find;
	}
	
	public boolean isFound() {
		return found;
	}
	
	public void setFound(boolean found) {
		this.found = found;
	}
	
    
	public String findVozidlo()
    {
		vozidlo = vozidloMgr.find(find);
        found = true;
        return "ok";
    }
    
    public String clearSearch()
    {
        found = false;
        return "ok";
    }
}
