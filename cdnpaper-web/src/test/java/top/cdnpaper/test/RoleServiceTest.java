package top.cdnpaper.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.cdnpaper.model.PageView;
import top.cdnpaper.model.Result;
import top.cdnpaper.model.Role;
import top.cdnpaper.service.RoleService;

public class RoleServiceTest {
	private ApplicationContext applicationContext;
	private RoleService roleService;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		roleService = (RoleService) applicationContext.getBean("roleService");
	}
	
	@Test
	public void testAddRole(){
		Role role = new Role();
		role.setName("operator");
		role.setDescription("操作员");
		role.setLevel(2);
		Result<Role> result = roleService.addRole(role);
		System.out.println(result);
	}
	
	@Test
	public void testDeleteRole(){
		Result<Role> result = roleService.deleteRole("6467c7bf79a34720bbb3b71f6ff07da8");
		System.out.println(result);
	}
	
	@Test
	public void testUpdateRole(){
		Role role = new Role();
		role.setId("77d4d363b37d4cb8a0752fea04b79936");
		role.setName("admin2");
		role.setDescription("21e");
		role.setLevel(1);
		Result<Role> result = roleService.updateRole(role);
		System.out.println(result);
	}
	
	@Test
	public void testGetRoles(){
		Role role = new Role();
		Map<String, String> order = new HashMap<String, String>();
		order.put("level", "desc");
		Integer currentPage = 1;
		
		PageView<Role> pageView = roleService.getRoles(role, order, currentPage);
		System.out.println("总记录数：" + pageView.getTotalRecord());
		System.out.println("总页数：" + pageView.getTotalPage());
		for(Role r : pageView.getResultList()){
			System.out.println(r);
		}
	}
	
}
