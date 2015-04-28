package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fit.pis.data.Ucet;
import org.fit.pis.service.UcetManager;

@ManagedBean
@SessionScoped
public class AuthenticationBean
{
	@EJB
	private UcetManager ucetMgr;
	private Ucet ucet;
    private boolean authorized;
    private String login;
    private String password;
    private boolean admin;

    
    public AuthenticationBean()
    {
        authorized = false;
        admin = true;
    }

    public boolean isAuthorized()
    {
        return authorized;
    }

    public void setAuthorized(boolean authorized)
    {
        this.authorized = authorized;
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
        authorized = false;
        return "/login";
    }
    
    public String actionLogin()
    {
    	ucet=ucetMgr.find(login);
        if (ucet!=null && ucet.verifyPassword(password))
        {
            authorized = true;
            password = "";
            return "login";
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid login or password"));
            return "failed";
        }
    }

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
