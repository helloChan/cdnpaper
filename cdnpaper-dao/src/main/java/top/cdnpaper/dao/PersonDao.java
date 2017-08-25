package top.cdnpaper.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import top.cdnpaper.model.Person;

@Repository
public interface PersonDao extends BaseDao<Person> {

	List<Person> selectAll();
	
}
