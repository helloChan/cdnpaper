package top.cdnpaper.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cdnpaper.dao.RoleDao;
import top.cdnpaper.model.PageView;
import top.cdnpaper.model.QueryResult;
import top.cdnpaper.model.Result;
import top.cdnpaper.model.Role;
import top.cdnpaper.service.RoleService;
import top.cdnpaper.utils.PageViewUtils;
import top.cdnpaper.utils.ResultUtils;
import top.cdnpaper.utils.UUID;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午9:43:36
 * @description
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;

	public Result<Role> addRole(Role role) {
		if (role != null) {
			Result<Role> r;

			if (StringUtils.isBlank(role.getName())) {
				return ResultUtils.error("名称不能为空");
			} else if (StringUtils.isBlank(role.getDescription())) {
				return ResultUtils.error("描述不能为空");
			} else if (role.getLevel() <= 0) {
				return ResultUtils.error("等级需大于0");
			} else {
				role.setId(UUID.uuidTrim());
				Boolean b = roleDao.insert(role);
				if (b) {
					r = ResultUtils.success();
				} else {
					r = ResultUtils.error();
					logger.error("添加角色在这里出现了错误: " + role);
				}
			}
			return r;
		}
		return ResultUtils.error("添加出现错误");
	}

	public Result<Role> deleteRole(String id) {
		Result<Role> r ;
		if (StringUtils.isNotBlank(id)) {
			Role role = new Role();
			role.setId(id);
			Boolean b = roleDao.delete(role);
			if(b){
				r = ResultUtils.success();
			}else{
				r = ResultUtils.error();
				logger.error("删除角色时在这里出现了错误: " + role);
			}
			return r;
		}
		r = ResultUtils.error("删除出现错误");
		return r;
	}

	public Result<Role> updateRole(Role role) {
		Result<Role> r ;
		if(role != null){
			if(StringUtils.isBlank(role.getName())){
				return ResultUtils.error("名称不能为空");
			} else if (StringUtils.isBlank(role.getDescription())) {
				return ResultUtils.error("描述不能为空");
			} else if (role.getLevel() <= 0) {
				return ResultUtils.error("等级需大于0");
			} else {
				Boolean b = roleDao.update(role);
				if(b){
					r = ResultUtils.success();
				}else{
					r = ResultUtils.error();
					logger.error("更新角色时在这里出现了错误: " + role);
				}
				return r; 
			}
		}
		r = ResultUtils.error("更新出现错误");
		return r;
	}

	public PageView<Role> getRoles(Role role, Map<String, String> order, Integer currentPage) {
		PageView<Role> pageView = PageViewUtils.getPageView(currentPage);
		QueryResult<Role> qr = new QueryResult<Role>(
				roleDao.select(role, pageView.getFirstIndex(), 
						pageView.getPerPageResult(), order), 
				roleDao.count(role));
		pageView.setQueryResult(qr);
		return pageView;
	}

}
