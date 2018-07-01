package com.hand.hand.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hand.hand.domain.Hospital;
import com.hand.hand.domain.Role;
import com.hand.hand.domain.User;

import java.util.List;

/**
 * Created by nishuai on 2017/11/12.
 */
public interface UserService {

     /*
        验证用户是否正确
     */
     public Boolean validateUser(User user);

     /*
         查询所有系统管理用户（暂时为医院系统管理院）
     */

    public List<User> findAllSystemManagerUser();

     /**
      * 查询所有系统管理用户（暂时为医院系统管理院）----（分页）
      */

     public Page<User> findAllSystemManagerUserPage(Integer page, Integer size);

    /**
     * 添加单个系统用户信息
     */

    public int addUser(User user);

    /**
     * 查询所有角色信息
     */
    public  List<Role> findAllUserRole();

    /**
     * 根据id查询系统用户信息
     */
    public User getUserById(Long id);

    /**
     * 编辑单个系统用户信息
     */

   public int editUser(User user);

    /**
     * 根据id删除用户系统信息
     */

   public int deleteUser(Integer id);

    /**
     * 根据name,username,hname字段,模糊查询户系统信息
     */
    public List<User> getUserLike(String selectword);





}
