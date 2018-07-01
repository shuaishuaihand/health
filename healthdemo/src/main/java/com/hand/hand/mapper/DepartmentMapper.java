package com.hand.hand.mapper;

import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nishuai on 2017/12/6
 */

@Mapper
public interface DepartmentMapper {

    /**
      * 添加单个科室信息
    */

     int addDepartment(Department department);

    /**
     * 根据id查询科室信息
     */

    Department getDepartmentByDid(String id);

    /**
     * 编辑单个医院信息
     */

    int editDepartment(Department department);

    /**
     * 根据id删除科室信息
     */
    int deleteDepartment(String did);

    /**
     * 根据did,danme,introduce,模糊查询科室信息
     */
    List<Department> getDepartmentLike(@Param("selectword") String selectword,@Param("hid") Integer hid);

    /**
     * 查询医院包含的所有科室名称集合
     */
    List<Department> getDepartmentDnamelist();

    /**
     *  查询医院包含的所有科室名称集合通过医院(hid)
     */
    List<Department> getDepartmentDnamelistByHid(Integer hid);

}
