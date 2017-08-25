package top.cdnpaper.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.cdnpaper.model.PageView;
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
		Person person = new Person();
		person.setName("aaa");
		int currentPage = 1;
		
		Map<String, String> order = new HashMap<String, String>();
		order.put("age", "asc");
		
		PageView<Person> pageView = personService.getPersons(person, currentPage, order);
		for (Person p : pageView.getResultList()) {
			System.out.println(p);
		}
		System.out.println(pageView.getTotalRecord());
	}
	
}
