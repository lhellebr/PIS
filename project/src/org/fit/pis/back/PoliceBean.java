package org.fit.pis.back;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.BodovySystemManager;
import org.fit.pis.service.KradezManager;
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
    
    @EJB
    private OsobaManager osobaMgr;
    private Osoba osoba;
    
    @EJB
    private KradezManager kradezMgr;
    private Kradez kradez;
    private List<Kradez> history;
    
    @EJB
    private BodovySystemManager pointMgr;
    private BodovySystem point;
    
    public PoliceBean()
    {
    	vozidlo = null;
    	found = false;
    	kradez = null;
    	history = null;
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
	
	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public Kradez getKradez() {
		return kradez;
	}

	public void setKradez(Kradez kradez) {
		this.kradez = kradez;
	}

	public List<Kradez> getHistory() {
		return history;
	}

	public void setHistory(List<Kradez> history) {
		this.history = history;
	}
	
	public BodovySystem getPoint() {
		return point;
	}

	public void setPoint(BodovySystem point) {
		this.point = point;
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
    
    public int getPointSum()
    {
    	int sum = 0;
    	for (BodovySystem point:osoba.getBodovySystem())
    	{
    		sum += point.getBody();
    	}
    	return (sum > 12) ? 12 : (sum < 0) ? 0 : sum;
    }
    
    //===============================
    
    public String actionPoints(Osoba osoba)
    {
    	setOsoba(osoba);
    	return "points";
    }
    
    
    public String actionTheft()
    {
		setKradez(new Kradez());
    	return "theft";
    }

	public String actionTheft(Kradez kradez)
    {
		setKradez(kradez);
    	return "theft";
    }
	
	public String actionTheftAdd()
	{
		//TODO kradez.setPolicista();
		kradez.setVozidlo(vozidlo);
		vozidlo.getThefts().add(kradez);
		kradezMgr.save(kradez);
		setKradez(new Kradez());
		return "save";
	}
	
	public String actionHistory(Vozidlo vozidlo)
	{
		setVozidlo(vozidlo);
		return "history";
	}
	
	public String actionInfo()
	{
		return "info";
	}
	
	public String actionBack()
	{
		setKradez(new Kradez());
		return "back";
	}
	
	public String actionPoints()
	{
		return "points";
	}
	
	public String actionAddRecord()
	{
		setPoint(new BodovySystem());
		point.setDatumUdeleni(new Date());
		return "record";
	}

	public String actionPointsAdd()
	{
		//TODO point.setPolicista()
		osoba.getBodovySystem().add(point);
		pointMgr.save(point);
		osobaMgr.save(osoba);
		setPoint(new BodovySystem());
		return "save";
	}
	
}
