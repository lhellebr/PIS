package org.fit.pis.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;

public final class AuthenticationFilter implements Filter 
{
    @SuppressWarnings("unused")
	private FilterConfig filterConfig = null;
    private static final Logger log = Logger.getLogger( AuthenticationFilter.class.getName() );

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpSession session = ((HttpServletRequest) request).getSession();
        AuthenticationBean auth = (AuthenticationBean) session.getAttribute("authenticationBean");
        String path = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length());
        if (auth != null && auth.isAuthorized())
        {
        	if(auth.isAdmin() || !(path.startsWith("/faces/admin/") || path.startsWith("/admin/"))){
        		chain.doFilter(request, response);
        		return;
        	}
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Bad login</title></head><body>");
        out.println("<h1>Access denied</h1>");
        out.println("Access denied. <a href=\"../login.xhtml\">Try again</a>.");
        out.println("</body></html>");
    }

    public void destroy() 
    {
    }

    public void init(FilterConfig filterConfig) 
    {
        this.filterConfig = filterConfig;
    }
}
