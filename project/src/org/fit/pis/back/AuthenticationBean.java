package org.fit.pis.back;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fit.pis.data.Ucet;
import org.fit.pis.enums.Opravneni;
import org.fit.pis.service.UcetManager;

@ManagedBean
@SessionScoped
public class AuthenticationBean
{
	private static final Logger log = Logger.getLogger( UcetBean.class.getName() );
	@EJB
	private UcetManager ucetMgr;
	private Ucet ucet;
    private boolean authenticated;
    private boolean admin;

	private String login;
    private String password;
    
    
    
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

	public static Logger getLog() {
		return log;
	}

	public AuthenticationBean()
    {
        authenticated = false;
    }

    public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
    public boolean isAdmin(){
    	return authenticated && ucet.getOpravneni()==Opravneni.ADMINISTRATOR;
    }
    
    public boolean isAuthorized(String path)
    {
        if(!authenticated){
        	return false;
        }
        if(ucet.getOpravneni()==Opravneni.ADMINISTRATOR){
        	return true;
        }
        if(path.startsWith("/faces/user/") || path.startsWith("/user/")){
        	return ucet.getOpravneni()==Opravneni.UREDNIK;
        }
        if(path.startsWith("/faces/police/") || path.startsWith("/police/")){
        	return ucet.getOpravneni()==Opravneni.POLICISTA;
        }
        return false;
    }

    public void setAuthorized(boolean authenticated)
    {
        this.authenticated = authenticated;
    }
    
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String actionLogout()
    {
        authenticated = false;
        return "/login";
    }
    
    public String actionLogin()
    {
    	ucet=ucetMgr.find(login);
        if (ucet!=null && ucet.verifyPassword(password))
        {
            authenticated = true;
            password = "";
            if(ucet.getOpravneni()==Opravneni.ADMINISTRATOR){
            	admin = true;
            	return "admin";
            }
            if(ucet.getOpravneni()==Opravneni.UREDNIK){
            	return "user";
            }
            if(ucet.getOpravneni()==Opravneni.POLICISTA){
            	return "police";
            }
            return "failed";
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid login or password"));
            return "failed";
        }
    }
}
