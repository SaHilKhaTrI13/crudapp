package com.harman.services;

import java.util.List;

import com.harman.dao.PersonDao;
import com.harman.dao.PersonDaoImpl;
import com.harman.exception.PersonException;
import com.harman.models.Person;

public class CrudServicesImpl implements CrudServices{
	PersonDao personDao;
	
	public CrudServicesImpl()
	{
		personDao = new PersonDaoImpl();
	}
	
	public void add(Person detail) throws PersonException {
		// TODO Auto-generated method stub
		
		personDao.add(detail);
		
	}

	@Override
	public List<Person> ShowList() throws PersonException {
		// TODO Auto-generated method stub
		return personDao.list();
	}

	@Override
	public void remove(int id) throws PersonException {
		// TODO Auto-generated method stub
		personDao.delete(id); 
		
	}

	@Override
	public void edit(Person prs) throws PersonException {
		// TODO Auto-generated method stub
		personDao.edit(prs);
	}
}
