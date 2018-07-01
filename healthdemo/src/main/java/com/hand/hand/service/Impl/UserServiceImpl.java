package com.hand.hand.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hand.hand.domain.Hospital;
import com.hand.hand.domain.Role;
import com.hand.hand.domain.User;
import com.hand.hand.mapper.UserMapper;
import com.hand.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nishuai on 2017/11/12.
 */
@Service
public class UserServiceImpl implements UserService{

    //注入Mapper接口代理对象
   @Autowired
   private UserMapper userMapper;

    /*
        验证用户是否正确
     */
    public Boolean validateUser(User user){
        if(userMapper.validateUser(user)!=null){ //用户名，密码都相同，是唯一的
            System.out.println("该用户存在！");
            return true;
        }

        return false;
    }

     /*
         查询所有系统管理用户（暂时为医院系统管理院）
     */

     public List<User> findAllSystemManagerUser(){
         List<User> userslist=userMapper.findAllSystemManagerUser();
         System.out.print(userslist.get(0).getRole().getName()+"12345");
         return userslist;
     }

    /*
      查询所有系统管理用户（暂时为医院系统管理院）---（分页）
    */
    public Page<User> findAllSystemManagerUserPage(Integer page, Integer size){

        PageHelper.startPage(page, size);
        List<User> userslist=  this.findAllSystemManagerUser();
        Page<User> userlistPage= (Page<User>)userslist;

        return userlistPage;
    }

    /**
     * 添加单个系统用户信息
     */

    public int addUser(User user){
        int userresult=userMapper.addUser(user);
        System.out.println(user.getRole().getRid()+"----------------");
        int roleresult=userMapper.addUserRole(user.getId(),user.getRole().getRid());
        if(userresult>0&&roleresult>0){
            System.out.println("插入成功！");
            return 1;
        }
        return  0;
    }

    /**
     * 查询所有角色信息
     */
    public  List<Role> findAllUserRole(){
        List<Role> userrolelist=userMapper.findAllUserRole();
        return userrolelist;

     }

    /**
     * 根据id查询系统用户信息
     */
    public User getUserById(Long id){
        User user=userMapper.getUserById(id);
        return user;
    }

    /**
     * 编辑单个系统用户信息
     */

    public int editUser(User user){
        int userresult=userMapper.editUser(user);
        int userrole= userMapper.editUserRole(user.getId(),user.getRole().getRid());
        if(userresult>0&&userrole>0){
            System.out.println("修改成功！");
            return 1;
        }
        return  0;
    }

    /**
     * 根据id删除用户系统信息
     */

    public int deleteUser(Integer id){
        int result=userMapper.deleteUser(id);
        if(result>0){
            System.out.println("删除成功！");
            return result;
        }
        return  0;
    }

    /**
     * 根据name,username,hname字段,模糊查询户系统信息
     */
    public List<User> getUserLike(String selectword){
        List<User> users=  userMapper.getUserLike(selectword);
        return users;
    }


   /*
      测试：redis缓存
    */

   /* @Cacheable(value = "findAllCache")
    @Override
    public List<User> findAll(){
        System.out.println("如果第二次没有打印此文章，说明走了缓存，没有执行此方法！");
     List<User> list=userMapper.findAll();
     return list;
    }*/

}
