package com.harman.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.services.CrudServices;
import com.harman.services.CrudServicesImpl;

/**
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CrudServices services;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		services = new CrudServicesImpl();
		int id= Integer.parseInt(request.getParameter("id"));
		try {
			services.remove(id);
		}catch(Exception e)
		{
			System.out.print(e);
		}
		response.sendRedirect("view");
	}

}
