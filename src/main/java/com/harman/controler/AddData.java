package com.harman.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.exception.PersonException;
import com.harman.models.Person;
import com.harman.services.CrudServices;
import com.harman.services.CrudServicesImpl;

/**
 * Servlet implementation class AddData
 */
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CrudServices services;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		services = new CrudServicesImpl();
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		
		
		
		
//		This is our add method for adding the detail of any person 
//		and this method goes to the service package and calls the doadd methon which written in service package

		Person prs = new Person();
		prs.setName(request.getParameter("name"));
		prs.setEmail(request.getParameter("email"));
		prs.setAge(Integer.parseInt(request.getParameter("age")));
		
		try {
			services.add(prs);
			pt.print("<h3>Record Saved Successfully");
			request.getRequestDispatcher("add.jsp").include(request, response);
			
		}
		catch(PersonException excep )
		{
			System.err.println("Error"+ excep.getMessage());
		}
				
	}
	

}
