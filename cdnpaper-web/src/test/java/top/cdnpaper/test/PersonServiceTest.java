package top.cdnpaper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.cdnpaper.model.Person;
import top.cdnpaper.service.PersonService;

public class PersonServiceTest {
	private ApplicationContext applicationContext;
	private PersonService personService;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		personService = (PersonService) applicationContext.getBean("personService");
	}
	
	@Test
	public void testAddPerson(){
		Person person = new Person("aaa", 12);
		Boolean b = personService.addPerson(person);
		System.out.println(b?"添加成功："+person:"添加失败");
	}
	
	@Test
	public void testSelectPerson(){
		List<Person> persons = personService.getAllPerson();
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
}
