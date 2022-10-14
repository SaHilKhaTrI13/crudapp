package com.harman.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.models.Person;
import com.harman.services.CrudServices;
import com.harman.services.CrudServicesImpl;

/**
 * Servlet implementation class ViewData
 */
public class ViewData extends HttpServlet {
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
		pt.print("<html><head><style>\r\n"
				+ "		body\r\n"
				+ "		{\r\n"
				+ "		    counter-reset: Serial;          \r\n"
				+ "		}"
				+ "		tr td:first-child:before\r\n"
				+ "		{\r\n"
				+ "		  counter-increment: Serial;      \r\n"
				+ "		  content: counter(Serial); \r\n"
				+ "		}"
				+ "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "  width: 100%;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "td, th {\r\n"
				+ "  border: 1px solid #dddddd;\r\n"
				+ "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n"
				+ "}</style></head></html>");
		pt.print("<table>  <tr>\r\n"
				+ "	   <th>Sl.No</th>\r\n"
				+ "    <th>Name</th>\r\n"
				+ "    <th>Email</th>\r\n"
				+ "    <th>Age</th>\r\n"
				+ "    <th>Delete</th>\r\n"
				+ "    <th>Update</th>\r\n"
				+ "  </tr>");
		
		
		
		
		try {
			List<Person> detail = services.ShowList();
			if((detail==null) || detail.isEmpty())
			{
				System.out.println("NO List Found");
			}
			else
			{
				for(Person dt: detail)
				{
					pt.print("  <tr>\r\n"
							+ "    <td></td>\r\n"
							+ "    <td>"+dt.getName()+"</td>\r\n"
							+ "    <td>"+dt.getEmail()+"</td>\r\n"
							+ "    <td>"+dt.getAge()+"</td>\r\n"
							+ "    <td><a href= 'delete?id="+dt.getId()+"'>delete</a></td>\r\n"
							+ "    <td><a href= 'update.jsp?id="+dt.getId()+"'>update</a></td>\r\n"
							+ "  </tr>");
				}
			}
		}catch(Exception excep)
		{
			System.out.println(excep);
		}
	pt.print("</table>");
	}

}
