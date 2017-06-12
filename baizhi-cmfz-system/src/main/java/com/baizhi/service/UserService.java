package com.baizhi.service;

import com.baizhi.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * user部门的业务接口
 */
public interface UserService {
	/**
	 * user的查询所有用户功能
	 */
	public List<User> QueryAllUser();
	
	/**
	 * user的查询一个用户功能
	 */
	public User QueryOneUser(String userid);
	/**
	/**
	 * user的添加用户功能
	 */
	public void addUser(User user);
	
	/**
	 * dept的修改用户功能
	 */
	public void changeUser(User user);
	/**
	 * dept的删除用户功能
	 */
	public void removeUser(String userid);


	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<User> queryByPage(Integer pageNum, Integer pageSize);
}
