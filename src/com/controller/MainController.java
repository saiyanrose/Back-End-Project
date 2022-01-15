package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Validate;


@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public MainController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		adminlogin(request, response);
	}


	
	private void adminlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(Validate.adminlogin(username, password)) {
			
			 out.print("Welcome, "+username);		 
			 request.getSession().invalidate();
			 HttpSession session=request.getSession(true);
			 session.setMaxInactiveInterval(300);//300sec
		     session.setAttribute("username",username);  
			request.getRequestDispatcher("panel.jsp").forward(request, response);
		
		}else {
		
				out.print("<span style='color:red'>Incorrect Password</span>");
				request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
			
		}
		
	}

}
