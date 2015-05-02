package org.fit.pis.back;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.OsobaManager;
import org.fit.pis.service.RidicskyPrukazManager;
import org.fit.pis.service.RidiciskyPrukazSkupinaManager;


@ManagedBean
@SessionScoped
public class OsobaBean
{
	@EJB
	private OsobaManager osobaMgr;
	@EJB
	private RidicskyPrukazManager ridicskyPrukazMgr;
	@EJB
	private RidiciskyPrukazSkupinaManager ridicskyPrukazSkupinaMgr;
    private Osoba osoba;
    private Vozidlo vozidlo;
    private RidicskyPrukaz ridicskyPrukaz;
    private RidicskyPrukazSkupina skupina;
    private boolean update;
    private Map<String,String> skupinaList;
    private String skupinaId;
    
    public OsobaManager getOsobaMgr() {
		return osobaMgr;
	}

	public void setOsobaMgr(OsobaManager osobaMgr) {
		this.osobaMgr = osobaMgr;
	}

	public RidicskyPrukazManager getRidicskyPrukazMgr() {
		return ridicskyPrukazMgr;
	}

	public void setRidicskyPrukazMgr(RidicskyPrukazManager ridicskyPrukazMgr) {
		this.ridicskyPrukazMgr = ridicskyPrukazMgr;
	}

	public RidicskyPrukaz getRidicskyPrukaz() {
		return ridicskyPrukaz;
	}

	public void setRidicskyPrukaz(RidicskyPrukaz ridicskyPrukaz) {
		this.ridicskyPrukaz = ridicskyPrukaz;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

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
    
    public List<RidicskyPrukaz> getPrukazy()
    {
        return ridicskyPrukazMgr.findAll();
    }

    public RidicskyPrukazSkupina getSkupina() {
		return skupina;
	}

	public void setSkupina(RidicskyPrukazSkupina skupina) {
		this.skupina = skupina;
	}

	public String getSkupinaId() {
		return skupinaId;
	}

	public void setSkupinaId(String skupinaId) {
		this.skupinaId = skupinaId;
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
	    	this.osobaMgr.save(osoba);
    	}
        return "add";
    }
    
    public String actionVozidloDel(Vozidlo vozidlo)
    {
        osoba.getVozidla().remove(vozidlo);
        return "delete";
    }
    
    public String actionShowPrukazy(Osoba osoba){
    	setOsoba(osoba);
    	return "prukazy";
    }
    
    public String actionPrukazNew()
    {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.YEAR, 5);
        ridicskyPrukaz = new RidicskyPrukaz();
        ridicskyPrukaz.setPlatnostOd(new Date());
        ridicskyPrukaz.setPlatnostDo(cal.getTime());
        return "newPrukaz";
    }
    
    public String actionPrukazAdd()
    {
    	this.ridicskyPrukaz.setOsoba(osoba);
    	this.osoba.getRidicskePrukazy().add(ridicskyPrukaz);
    	this.osobaMgr.save(osoba);
        return "add";
    }
    
    public String actionEditRidicskyPrukaz(RidicskyPrukaz prukaz) {
    	ridicskyPrukaz = prukaz;
    	return "editPrukaz";
    }
    
    public String actionSaveRidicskyPrukaz(RidicskyPrukaz prukaz) {
    	ridicskyPrukazMgr.save(prukaz);
    	return "prukazy";
    }
    
    public String actionDeleteRidicskyPrukaz(RidicskyPrukaz prukaz) {
    	osoba.getRidicskePrukazy().remove(prukaz);
    	this.osobaMgr.save(osoba);
    	return "prukazy";
    }
    
    public String actionNewSkupina() {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.YEAR, 5);
    	skupina = new RidicskyPrukazSkupina();
    	skupina.setDatumUdeleni(new Date());
    	skupina.setPlatnostDo(cal.getTime());
    	skupina.setRidicskyPrukaz(ridicskyPrukaz);
    	return "newSkupina";
    }
    
    public String actionAddSkupina() {
    	Skupina s = ridicskyPrukazSkupinaMgr.findSkupina(Integer.parseInt(skupinaId));
    	skupina.setSkupina(s);
    	ridicskyPrukaz.getSkupiny().add(skupina);
    	ridicskyPrukazMgr.save(ridicskyPrukaz);
    	setSkupina(null);
    	return "saveSkupina";
    }
    
    public String actionEditSkupina(RidicskyPrukazSkupina s) {
    	skupina = s;
    	return "editSkupina";
    }
    
    public String actionSaveSkupina() {
    	ridicskyPrukazSkupinaMgr.save(skupina);
    	setSkupina(null);
    	return "saveSkupina";
    }
    
    public String actionDeleteSkupina(RidicskyPrukazSkupina skupina) {
    	ridicskyPrukaz.getSkupiny().remove(skupina);
    	return "deleteSkupina";
    }
    
    public Map<String,String> getSkupinaList() {
    	skupinaList = new LinkedHashMap<String,String>();
    	List<Skupina> skupiny = ridicskyPrukazSkupinaMgr.findAllSkupina();
    	for (ListIterator<Skupina> iter = skupiny.listIterator(); iter.hasNext(); ) {
    		Skupina s = iter.next();
    		skupinaList.put(s.getOznaceni(),Integer.toString(s.getId()));
    	}
    	return skupinaList;
    }
}
