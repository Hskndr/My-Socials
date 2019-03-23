
package com.educacionit.web.servlet;


import com.educacionit.mysocials.beans.User;
import com.educacionit.mysocials.services.IAuth;
import com.educacionit.mysocials.services.impl.AuthImpl;

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


    private IAuth auth = new AuthImpl ();


    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        User user = this.auth.login (req.getParameter ("user"), req.getParameter ("pw"));

        HttpSession session = req.getSession ();

        session.setAttribute ("user", user);

        resp.sendRedirect("home.jsp");
    }
}