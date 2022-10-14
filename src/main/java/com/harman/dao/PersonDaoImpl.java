package com.harman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.harman.exception.PersonException;
import com.harman.models.Person;

public class PersonDaoImpl implements PersonDao {
	private static Connection con = null;
	private static PreparedStatement pst;
	private static final String INS_QRY = "INSERT INTO PERSONDETAILS(NAME, EMAIL, AGE) VALUES (?, ?,?)";
	private static final String SELECT_QRY = "SELECT * FROM PERSONDETAILS";
	private static final String DELETE_QRY = "DELETE FROM PERSONDETAILS WHERE PERSONID =?";
	private static final String UPDATE_QRY = "UPDATE PERSONDETAILS SET NAME= ?, EMAIL= ?, AGE= ? WHERE PERSONID=?";
	public void add(Person detail) throws PersonException {

		if(detail != null)
		{
			try
			{
				con = ConnectionProvider.getConnection();
				pst = con.prepareStatement(INS_QRY);
				pst.setString(1, detail.getName());
				pst.setString(2, detail.getEmail());
				pst.setInt(3, detail.getAge());
				pst.executeUpdate();
				System.out.println("Successfully Added");
				con.close();
			}catch(Exception excep)
			{
				System.out.println(excep);
			}
		}
	}

	@Override
	public List<Person> list() throws PersonException {
		// TODO Auto-generated method stub
		List<Person> detailList = new ArrayList<Person>();
		con = ConnectionProvider.getConnection();
		
		try {
			pst = con.prepareStatement(SELECT_QRY);
			ResultSet rs = pst.executeQuery();
			Person detail = null;
			
			while(rs.next())
			{
				detail = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				detailList.add(detail);
			}
			con.close();
		}catch(SQLException excep)
		{
			System.out.println("HEAR");
		}
		return detailList;
	}

	@Override
	public void delete(int id)throws PersonException {
		// TODO Auto-generated method stub
		con = ConnectionProvider.getConnection();
		try {
			pst= con.prepareStatement(DELETE_QRY);
			pst.setInt(1, id);
			pst.executeUpdate();
			con.close();
		}catch(SQLException e)
		{
			System.out.print(e);
		}
		
	}

	@Override
	public void edit(Person prs) throws PersonException {
		// TODO Auto-generated method stub
		con = ConnectionProvider.getConnection();
		try {
			pst = con.prepareStatement(UPDATE_QRY);
			pst.setString(1, prs.getName());
			pst.setString(2, prs.getEmail());
			pst.setInt(3, prs.getAge());
			pst.setInt(4, prs.getId());
			pst.executeUpdate();
			System.out.println("Successfully Updated");
			con.close();
		}catch(Exception e)
		{
			System.out.print(e);
		}
		
	}

}
