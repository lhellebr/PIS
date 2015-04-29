package org.fit.pis.back;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public final class AuthenticationFilter implements Filter 
{
    @SuppressWarnings("unused")
	private FilterConfig filterConfig = null;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpSession session = ((HttpServletRequest) request).getSession();
        AuthenticationBean auth = (AuthenticationBean) session.getAttribute("authenticationBean");
        String path = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length());
        if(auth!=null && auth.isAuthorized(path)){
    		chain.doFilter(request, response);
        }else{
        	((HttpServletResponse)response).sendRedirect("/project/faces/login.xhtml");
        }
    }

    public void destroy() 
    {
    }

    public void init(FilterConfig filterConfig) 
    {
        this.filterConfig = filterConfig;
    }
}
