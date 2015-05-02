package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.RidicskyPrukazManager;


@ManagedBean
@SessionScoped
public class PublicBean {
	@EJB
	private RidicskyPrukazManager ridicskyPrukazManager;
	private RidicskyPrukaz prukaz;
    private String find;
    private boolean found;
	
    public PublicBean() 
    {
    	prukaz = null;
    	found = false;
    }
    
    public RidicskyPrukaz getPrukaz() {
		return prukaz;
	}

	public void setPrukaz(RidicskyPrukaz prukaz) {
		this.prukaz = prukaz;
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

	public String findPrukaz()
    {
		if (find != null)
		{
			prukaz = ridicskyPrukazManager.findByNumber(find);
	        found = true;
		}
        return "ok";
    }
	
	public int getPointSum()
    {
    	int sum = 0;
    	for (BodovySystem point:prukaz.getOsoba().getBodovySystem())
    	{
    		sum += point.getBody();
    	}
    	return (sum > 12) ? 12 : (sum < 0) ? 0 : sum;
    }
	
	public String actionBody()
	{
		findPrukaz();
		if (prukaz != null)
		{
			return "body";
		}
		else
		{
			return "index";
		}
		
	}
	
	public String actionIndex()
	{
		return "index";
	}
}
