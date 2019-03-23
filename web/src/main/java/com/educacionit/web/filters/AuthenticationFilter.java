
package com.educacionit.web.filters;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "/authenticationFilter",
           urlPatterns = "/*")
public class AuthenticationFilter implements Filter {


    private static final Logger logger = Logger.getLogger (AuthenticationFilter.class);


    public AuthenticationFilter () {

        super ();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.debug ("Starting AuthenticationFilter ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI ();
        logger.debug (String.format ("Requested Resource %s", uri));

        HttpSession session = req.getSession (false);

        if (session == null && !(uri.equals("/my-socials/login.jsp") || uri.equals("/my-socials/login"))) {

            logger.debug (String.format ("Unauthorized access request %s", uri));
            res.sendRedirect("login.jsp");

        } else {

            filterChain.doFilter (req, res);
        }
    }

    @Override
    public void destroy() {

        logger.debug ("Destroying AuthenticationFilter ...");
    }
}