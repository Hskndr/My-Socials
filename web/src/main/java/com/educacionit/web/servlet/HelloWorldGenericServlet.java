package com.educacionit.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldGenericServlet extends GenericServlet {

  public HelloWorldGenericServlet () {
      super ();
  }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();

        out.println("<h2>Hello World</h2>");
        out.println("<h3>GenericServlet</h3>");

        out.close();

    }
}
