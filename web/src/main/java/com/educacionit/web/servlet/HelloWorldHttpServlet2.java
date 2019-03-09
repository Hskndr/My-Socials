package com.educacionit.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello3")
public class HelloWorldHttpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        resp.setContentType ("text/html;charset=UTF-8");


        PrintWriter out = resp.getWriter ();

        out.println ("<h2>Hello World2</h2>");
        out.println ("<h3>HttpServle2t</h3>");
        out.println ("<h4>GET2</h4>");
        out.close();

    }
}
