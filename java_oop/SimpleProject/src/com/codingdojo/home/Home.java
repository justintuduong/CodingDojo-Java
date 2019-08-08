package com.codingdojo.home;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//...
@WebServlet("/Home")
public class Home extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // get the value for the query parameter
      String fName = request.getParameter("fname");
      String lName = request.getParameter("lname");
      String language = request.getParameter("language");
      String homeTown = request.getParameter("homeTown");
      PrintWriter out = response.getWriter();
      
      if (fName == null) {
    	  fName = "unknown";
      }
      if (lName == null) {
    	  lName = "unknown";
      }
      if (language == null) {
    	  language = "unknown";
      }
      if (homeTown == null) {
    	  homeTown = "unknown";
      }
      
      
      response.setContentType("text/html");
      
      
      out.write("<h1>Hello World, from " + fName + " " + lName + "</h1>");
      out.write("<h1>Hello World, from " + language + "</h1>");
      out.write("<h1>Hello World, from " + homeTown + "</h1>");
      
      
      
  }
//...
}
