package top.cdnpaper.service;

import java.util.Map;

import top.cdnpaper.model.PageView;
import top.cdnpaper.model.Result;
import top.cdnpaper.model.Role;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月24日 下午9:41:10
* @description 角色业务处理接口
*/
public interface RoleService {
	public Result<Role> addRole(Role role);
	
	public Result<Role> deleteRole(String id);
	
	public Result<Role> updateRole(Role role);
	
	public PageView<Role> getRoles(Role role, Map<String, String> order, Integer currentPage);
	
}
