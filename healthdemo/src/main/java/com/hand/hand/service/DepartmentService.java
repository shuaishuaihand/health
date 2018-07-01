package com.hand.hand.service;

import com.github.pagehelper.Page;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;

import java.util.List;

/**
 * Created by nishuai on 2017/12/6.
 */
public interface DepartmentService {

      /*添加单个科室信息*/

    public Boolean addDepartment(Department department);

      /*
      根据id查询科室信息
     */

    public Department getDepartmentByDid(String id);

     /*
      编辑单个科室信息
     */

    public Department editDepartment(Department department);


     /*
       根据id删除科室信息
     */

    public int deleteDepartment(String hid);

    /**
     * 根据id集合，批量删除科室信息
     */
    public Boolean batchdeleteDepartment(String[] didlist);

    /**
     * 根据did,danme,introduce,模糊查询科室信息
     */
    public List<Department> getDepartmentLike(String selectword,Integer hid);

    /**
     * 查询医院包含的所有科室名称集合
     */
    public List<Department> getDepartmentDnamelist();

    /**
     * 查询医院包含的所有科室名称集合通过医院(hid)
     */
    public List<Department> getDepartmentDnamelistByHid(int hid);

}
