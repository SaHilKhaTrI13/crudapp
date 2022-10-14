package com.harman.services;

import com.harman.exception.PersonException;
import com.harman.models.Person;
import java.util.List;

public interface CrudServices {
	void add(Person detail) throws PersonException;
	List<Person> ShowList() throws PersonException;
	void remove(int id) throws PersonException;
	void edit(Person prs) throws PersonException;
}
