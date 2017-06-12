package com.baizhi.service;


import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * user部门的业务实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    /**
     * emp的查询所有员工功能
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> QueryAllUser() {
        List<User> liste=userDAO.selectAllUser();
        return liste;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<User> queryByPage(Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum,pageSize);
        userDAO.selectAllUser();
        return page;
    }

    /**
     * emp的查询一个员工功能
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User QueryOneUser(String empid){
        User emp= userDAO.selectOneUser(empid);
        return emp;
    }

    /**
     * emp的添加员工功能
     */
    public void addUser(User emp) {
        try {
            emp.setUid(UUID.randomUUID().toString());
            userDAO.insertOneUser(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * emp的修改员工功能
     */
    public void changeUser(User emp) {
        try {
            userDAO.updateUser(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * emp的删除员工功能
     */
    public void removeUser(String empid) {

        try {
            userDAO.deleteUser(empid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

