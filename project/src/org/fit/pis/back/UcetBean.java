package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fit.pis.data.Ucet;
import org.fit.pis.enums.Opravneni;
import org.fit.pis.service.UcetManager;


@ManagedBean
@SessionScoped
public class UcetBean
{
	@EJB
	private UcetManager ucetMgr;
	@ManagedProperty(value="#{authenticationBean}")
    private AuthenticationBean authenticationBean;
	private Ucet ucet;
    
	public void setAuthenticationBean(AuthenticationBean authenticationBean) {
		this.authenticationBean = authenticationBean;
	}
	
    public Opravneni[] getEnumOpravneni(){
    	return Opravneni.values();
    }
	
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
	
	public String actionInsertNew()
    {
		if(ucetMgr.find(ucet.getLogin())!=null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ucet s timto jmenem jiz existuje!"));
			return "new";
		}
        ucetMgr.save(ucet);
        return "insert";
    }
	
    public String actionUpdate()
    {
    	if(authenticationBean.isAdmin() || ucet.getLogin().equals(authenticationBean.getLogin())){
    		ucetMgr.save(ucet);
    	}else{
    		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Nope, you can't change another user's password unless you are admin. Don't try to hack me, please! :("));
    		return "edit";
    	}
        return "update";
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
