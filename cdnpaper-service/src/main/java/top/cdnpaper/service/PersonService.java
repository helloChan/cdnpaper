package top.cdnpaper.service;

import java.util.List;
import java.util.Map;

import top.cdnpaper.model.PageView;
import top.cdnpaper.model.Person;


public interface PersonService {
	public Boolean addPerson(Person person);

	public Boolean deletePersonById(Integer id);

	public Boolean updatePersonById(Person person);

	public PageView<Person> getPersons(Person person, int currentPage, Map<String, String> order);

	public List<Person> getAllPerson();
}
