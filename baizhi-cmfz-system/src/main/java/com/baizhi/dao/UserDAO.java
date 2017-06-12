package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * 员工dao层
 * @author GXL
 *
 */
public interface UserDAO {
	/**
	 * 查所有员工
	 */
	public List<User> selectAllUser();
	
	/**
	 * 查一个员工
	 */
	public  User selectOneUser(String id);
	
	/**
	 * 添加一个员工
	 */
	public  void insertOneUser(User emp);
	
	/**
	 * 修改一个员工
	 */
	public  void updateUser(User emp);
	
	/**
	 * 删除一个员工
	 */
	public  void deleteUser(String id);
}
