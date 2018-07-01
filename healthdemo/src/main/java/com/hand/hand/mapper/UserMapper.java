package com.hand.hand.mapper;

import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import com.hand.hand.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by nishuai on 2017/11/12.
 */

@Mapper
public interface UserMapper {

     /*
        验证用户是否正确
     */
    User validateUser(User user);

    /*
        查询所有系统管理用户（暂时为医院系统管理院）
     */

    List<User> findAllSystemManagerUser();

    /**
     * 添加单个系统用户信息
     */

    int addUser(User user);

    /**
     * 查询所有角色信息
     */
    List<Role> findAllUserRole();

    /**
     * 根据id查询角色信息
     */
    Role findRolById(@Param("rid") Long rid);


    /**
     * 将用户角色表插入数据
     */
    int addUserRole(@Param("hrid") Long hrid,@Param("rid") Long rid);

    /**
     *  根据id查询系统用户信息
     */
    User getUserById(Long id);

    /**
     * 编辑单个系统用户信息
     */

    int editUser(User user);

    /**
     * 编辑用户角色表信息(一个用户只有一个角色)
     */

    int editUserRole(@Param("hrid") Long hrid,@Param("rid") Long rid);

    /**
     * 根据id删除用户系统信息
     */

    int deleteUser(Integer id);


    /**
     * 根据name,username,hname字段,模糊查询户系统信息
     */
    List<User> getUserLike(@Param("selectword") String selectword);

       /*
      查询居民各年龄段的人数比例
     */

    List<Chartdata> findResidentproportionByAge();




}
