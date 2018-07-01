package com.hand.hand.controller;


import com.github.pagehelper.Page;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.hand.hand.domain.Role;
import com.hand.hand.domain.User;
import com.hand.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by nishuai on 2017/11/12.
 */
@CrossOrigin
@RestController
public class UserController {

    //注入Service服务对象
    @Autowired
    private UserService userService;

    /*测试cookie */

  /*  @RequestMapping(value = "validateUser",method = RequestMethod.POST)  //post
    public void validateUser(@RequestBody User user){
        Cookie[] cookies=re
    }*/




     /*
        验证用户是否正确
     */
     @RequestMapping(value = "validateUser",method = RequestMethod.POST)  //post
     public Boolean validateUser(@RequestBody User user){
         Boolean  result= userService.validateUser(user);
         return result;
     }

    /**
     * 查询所有用户信息（未分页）
     */

  /*  @RequestMapping(value = "findAllUser",method = RequestMethod.GET)
    public List<User> findAllUser(){
        List<User> usersList= userService.findAllUser();
        return usersList;
    }*/

    /**
     *  查询所有系统管理用户（暂时为医院系统管理院）
     */

    @RequestMapping(value = "findAllSystemManagerUserPage",method = RequestMethod.GET)
    public Map<String,Object> findAllUserPage(@RequestParam Integer page, @RequestParam Integer size){
       /* @RequestParam Integer page,@RequestParam Integer size*/
      /*  Integer page=2;
        Integer size=2;*/
        Page<User> userListpage= userService.findAllSystemManagerUserPage(page,size);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("pageuserdata",userListpage);
        map.put("total",userListpage.getTotal());

        return map;
    }

    /**
     * 添加单个系统用户信息
     */

    @RequestMapping(value = "addUser",method = RequestMethod.POST)  //post
    public int addDoctor(@RequestBody User user){
        int resultuser= userService.addUser(user);
        return resultuser;
    }

    /**
     * 查询所有角色信息
     */

   @RequestMapping(value = "findAllUserRole",method = RequestMethod.GET)
    public List<Role> findAllUserRole(){
        List<Role> usersList= userService.findAllUserRole();
        return usersList;
    }

    /**
     * 根据id查询系统用户信息
     */

    @RequestMapping(value = "getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        User user=userService.getUserById(id);
        return user;
    }

    /**
     * 编辑单个系统用户信息
     */

    @RequestMapping(value = "editUser",method = RequestMethod.PUT)  //put
    public Integer editUser(@RequestBody User user){

        //@RequestBody User user
         /*User user=new User();
         user.setId(16L);
         user.setName("王五11");*/
         System.out.println("进入系统");
        Integer resultuser= userService.editUser(user);
        return resultuser;
    }

    /**
     * 根据id删除用户系统信息
     */

    @RequestMapping(value = "deleteUser/{id}",method = RequestMethod.DELETE) //delete
    public int deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    /**
     * 根据name,username,hname字段,模糊查询户系统信息
     */

    @RequestMapping(value = "getUserLike/{selectword}",method = RequestMethod.GET)
    public List<User> getUserLike(@PathVariable String selectword){
        List<User> users=userService.getUserLike(selectword);
        return users;
    }



    /**
     * 根据id删除医院信息
     */
    /*@RequestMapping(value = "deleteHospital/{hid}",method = RequestMethod.DELETE) //delete
    public int deleteHospital(@PathVariable Integer hid){
        return hospitalService.deleteHospital(hid);
    }*/



   /* *//*需求：返回基本类型json格式数据*//*

    @RequestMapping("hello")
    public String showHeelo() {
        return "hello world";
    }

    *//*
       需求：返回POJO对象
     *//*
    @RequestMapping("pojo")
    public User showUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三丰");
        user.setGender("男");
        user.setBirthday(new Date());
        user.setAddress("安徽芜湖");
        return user;
    }

      *//*
      需求：返回Map集合对象
       *//*

    @RequestMapping("maps")
    public Map<String, Object> showMaps() {
    Map<String,Object> maps=new HashMap<>();
    maps.put("username","张良");
    maps.put("age","18");

    return maps;
     }


        *//*
      需求：返回list集合对象
       *//*

    @RequestMapping("list")
    public List<User> showlists() {
        //创建一个List集合对象
        List<User> userList=new ArrayList<>();
        User user1=new User(1,"张三",new Date(),"男","合肥");
        User user2=new User(2,"李四",new Date(),"男","上海");
        userList.add(user1);
        userList.add(user2);

        return  userList;
    }

    *//*
      需求：整合SSM（Spring，SpringBoot，mybatis）
     *//*
    @RequestMapping("SSM")
    public List<User> find(){
        List<User> list= userService.findAll();
        return list;
    }*/



}
