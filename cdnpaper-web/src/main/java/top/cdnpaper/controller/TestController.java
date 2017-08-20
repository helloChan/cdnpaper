package top.cdnpaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cdnpaper.model.Person;
import top.cdnpaper.service.PersonService;

@Controller
public class TestController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addPerson(Person person){
		Boolean b = personService.addPerson(person);
		return b?"添加成功":"添加失败";
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public Object selectAllPerson(){
		List<Person> persons = personService.getAllPerson();
		return persons;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updatePerson(Person person){
		Boolean b = personService.updatePersonById(person);
		return b?"1":"0";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String updatePerson(Integer id){
		Boolean b = personService.deletePersonById(id);
		return b?"1":"0";
	}
	
}	
