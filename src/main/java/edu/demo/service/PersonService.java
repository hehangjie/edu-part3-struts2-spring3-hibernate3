package edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.demo.dao.PersonDao;
import edu.demo.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public List<Person> findList() {
		return personDao.findList();
	}

	public Person get(Integer userId) {
		return personDao.get(userId);
	}

	public void add(Person user) {
		personDao.add(user);
		personDao.flush();
	}

	public void delete(Integer userId) {
		personDao.delete(userId);
		personDao.flush();
	}

	public void update(Person user) {
		personDao.update(user);
		personDao.flush();
	}
}
