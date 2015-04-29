package org.fit.pis.back;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.OneToMany;

import org.fit.pis.data.*;
import org.fit.pis.service.OsobaManager;


@ManagedBean
@SessionScoped
public class OsobaBean
{
	@EJB
	private OsobaManager osobaMgr;
    private Osoba osoba;
    private Vozidlo vozidlo;
    private boolean update;
    
    public OsobaBean()
    {
        osoba = new Osoba();
        vozidlo = new Vozidlo();
        update = false;
    }
    
    /**
     * @return the person
     */
    public Osoba getOsoba()
    {
        return osoba;
    }

    /**
     * @param person the person to set
     */
    public void setOsoba(Osoba osoba)
    {
        this.osoba = osoba;
    }
    
    public List<Osoba> getOsoby()
    {
		return osobaMgr.findAll();
    }
    
    public Vozidlo getVozidlo()
    {
        return vozidlo;
    }

    public void setVozidlo(Vozidlo vozidlo)
    {
        this.vozidlo = vozidlo;
    }

   //====================================================
    public String actionList(){
    	return "list";
    }
    
	public String actionNew()
	{
		osoba = new Osoba();
		return "new";
	}
	
	public String actionInsertNew()
    {
        osobaMgr.save(osoba);
        return "insert";
    }
    
    public String actionUpdate()
    {
        osobaMgr.save(osoba);
        return "update";
    }
    
    public String actionEdit(Osoba osoba)
    {
    	setOsoba(osoba);
    	return "edit";
    }
    
    public String actionDelete(Osoba osoba)
    {
    	osobaMgr.remove(osoba);
    	return "delete";
    }

    public String actionVozidloNew()
    {
        vozidlo = new Vozidlo();
        vozidlo.setDatumPrihlaseni(new Date());
        return "newcar";
    }
    
    public String actionVozidloNew(Vozidlo vozidlo)
    {
    	this.vozidlo = vozidlo;
    	this.update = true;
    	return "newcar";
    }
    
    public String actionVozidloAdd()
    {
    	if (!update)
    	{
	        vozidlo.setOwner(osoba);
	        osoba.getVozidla().add(vozidlo);
    	}
        return "add";
    }
    
    public String actionVozidloDel(Vozidlo vozidlo)
    {
        osoba.getVozidla().remove(vozidlo);
        return "delete";
    }
    
}
