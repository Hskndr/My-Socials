
package com.educacionit.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.educacionit.mysocials.dao.DBConnectionManager;


@WebListener
public class AppContextListener implements ServletContextListener {


    private static final Logger logger = Logger.getLogger (AppContextListener.class);


    public AppContextListener () {

        super ();
    }


    public void contextInitialized (ServletContextEvent servletContextEvent) {

        logger.info ("Starting My Socials Web App...");
    	ServletContext ctx = servletContextEvent.getServletContext ();

        logger.debug ("Reading Database Setup Parameters...");
    	String url = ctx.getInitParameter ("DBURL");
    	String u   = ctx.getInitParameter ("DBUSER");
    	String p   = ctx.getInitParameter ("DBPWD");
        String d   = ctx.getInitParameter ("DRIVER");

        logger.debug (String.format ("Starting Datasource USER %s, DB %s", u, url));
    	DBConnectionManager dbManager = new DBConnectionManager (url, u, p, d);
    	ctx.setAttribute ("db", dbManager);

        logger.info ("My Socials Web App Started !!!");
    }

    public void contextDestroyed (ServletContextEvent servletContextEvent) {

        logger.info ("Destroying My Socials Web App...");
    	ServletContext ctx = servletContextEvent.getServletContext ();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("db");

        logger.debug ("Closing Datasource...");
    	dbManager.closeConnection ();
        logger.info ("My Socials Web App Destroyed...");
    }
}