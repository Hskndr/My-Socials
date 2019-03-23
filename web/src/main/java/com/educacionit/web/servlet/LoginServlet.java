
package com.educacionit.web.servlet;


import com.educacionit.mysocials.beans.User;
import com.educacionit.mysocials.dao.DBConnectionManager;
import com.educacionit.mysocials.services.IAuth;
import com.educacionit.mysocials.services.SecutiryException;
import com.educacionit.mysocials.services.impl.AuthImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet ("/login")
public class LoginServlet extends HttpServlet {


    private static final Logger logger = Logger.getLogger (LoginServlet.class);


    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug ("Getting Servlet Context ...");
        ServletContext ctx = req.getServletContext ();

        logger.debug ("Getting DBManager from Servlet Context ...");
        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("db");

        logger.debug ("Getting Connection DB from DBManager ...");
        IAuth auth = new AuthImpl (dbManager.getConnection ());

        User user = null;
        try {

            logger.info (String.format ("Executing Login %s", req.getParameter ("user")));
            user = auth.login (req.getParameter ("user"), req.getParameter ("pw"));

            logger.info (String.format ("Login OK for %s", req.getParameter ("user")));
            HttpSession session = req.getSession ();
            session.setAttribute ("user", user);

            logger.info (String.format ("Session ID %s Created for %s", session.getId(), req.getParameter ("user")));
            resp.sendRedirect ("home.jsp");

        } catch (SecutiryException se) {

            logger.error (String.format ("Problems executing Login ==> %s", se.getMessage ()));
            resp.sendRedirect ("login.jsp?msg=ERR001");

        } catch (Exception e) {

            logger.error (String.format ("Problems executing Login ==> %s", e.getMessage ()));
            resp.sendRedirect ("login.jsp?msg=ERR000");
        }
    }
}