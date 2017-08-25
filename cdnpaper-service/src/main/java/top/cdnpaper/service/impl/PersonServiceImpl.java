package top.cdnpaper.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cdnpaper.dao.PersonDao;
import top.cdnpaper.model.PageView;
import top.cdnpaper.model.Person;
import top.cdnpaper.model.QueryResult;
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

	public PageView<Person> getPersons(Person person, int currentPage, Map<String, String> order) {
		PageView<Person> pageView = new PageView<Person>();
		pageView.setCurrentPage(currentPage);
		pageView.setQueryResult(
				new QueryResult<Person>(
						personDao.select(person, pageView.getFirstIndex(), pageView.getPerPageResult(), order), 
						personDao.count(person)));
		return pageView;
		
	}

	public List<Person> getAllPerson() {
		return personDao.selectAll();
	}

}
