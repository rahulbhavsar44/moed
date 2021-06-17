package com.moed;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.moed.dao.WebDao;

/**
 * Servlet implementation class Web
 */
@WebServlet("/Web")
public class Web extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		WebDao dao=new WebDao();
		
		
		if(dao.check(uname, pass)) 
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome1.jsp");
		}
		else 
		{
			response.sendRedirect("login1.jsp");
		}
		

	}

}
