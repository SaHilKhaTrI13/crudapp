package com.harman.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.exception.PersonException;
import com.harman.models.Person;
import com.harman.services.CrudServices;
import com.harman.services.CrudServicesImpl;

/**
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CrudServices services;
	private static PrintWriter pw;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		pw = response.getWriter();
		services = new CrudServicesImpl();
		Person prs = new Person();
		prs.setName(request.getParameter("name"));
		prs.setEmail(request.getParameter("email"));
		prs.setAge(Integer.parseInt(request.getParameter("age")));
		prs.setId(Integer.parseInt(request.getParameter("id")));
		
		try {
			services.edit(prs);
			
		}catch(PersonException e)
		{
			System.out.print(e);
		}
		response.sendRedirect("view");	
		
	}

}
