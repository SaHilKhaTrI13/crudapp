package com.harman.dao;

import java.util.List;

import com.harman.exception.PersonException;
import com.harman.models.Person;

public interface PersonDao {
	void add(Person detail) throws PersonException;
	List<Person> list() throws PersonException;
	void delete(int id) throws PersonException;
	void edit(Person prs) throws PersonException;
}
