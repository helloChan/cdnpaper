package top.cdnpaper.service;

import java.util.List;

import top.cdnpaper.model.Person;


public interface PersonService {
	public Boolean addPerson(Person person);

	public Boolean deletePersonById(Integer id);

	public Boolean updatePersonById(Person person);

	public List<Person> getAllPerson();
}
