package top.cdnpaper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cdnpaper.dao.PersonDao;
import top.cdnpaper.model.Person;
import top.cdnpaper.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	public Boolean addPerson(Person person) {
		return personDao.insert(person);
	}

	public Boolean deletePersonById(Integer id) {
		Person person = new Person();
		person.setId(id);
		return personDao.delete(person);
	}

	public Boolean updatePersonById(Person person) {
		return personDao.update(person);
	}

	public List<Person> getAllPerson() {
		return personDao.select(null);
	}

}
