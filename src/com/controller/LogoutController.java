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


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		switch (action) {
		
		case "destroy":
			
			logout(request, response);
			
			break;

		default:
			
			errorPage(request,response);
			break;
		}
	}

	
	private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String username=null,sessionId=null;
		PrintWriter out=response.getWriter();
		request.getSession(false).invalidate();		
		request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
