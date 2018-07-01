package com.hand.hand.controller;


import com.github.pagehelper.Page;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.hand.hand.service.DepartmentService;
import com.hand.hand.service.HospitalService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nishuai on 2017/11/12.
 */
@CrossOrigin
@RestController
public class DepartmentController {

    //注入Service服务对象
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login() {
        //HttpServletRequest request, User input, Model model
        System.out.println("11111");

        // 验证用户
        return "redirect:/";
    }


    /**
     * 添加单个科室信息
     */

    @RequestMapping(value = "addDepartment",method = RequestMethod.POST)  //post
    public Boolean addDepartment(@RequestBody Department department){
        System.out.print(department.getDid()+"|| "+department.getHid()+"|| "+department.getIntroduce());
        Boolean  result= departmentService.addDepartment(department);
        return result;
    }

    /**
     * 根据id查询科室信息
     */

    @RequestMapping(value = "getDepartmentByDid/{id}",method = RequestMethod.GET)
    public Department getDepartmentByDid(@PathVariable String id){
       Department department=departmentService.getDepartmentByDid(id);
        return department;
    }

    /**
     * 编辑单个科室信息
     */

    @RequestMapping(value = "editDepartment",method = RequestMethod.PUT)  //put
    public Department editDepartment(@RequestBody Department department){

       /* Hospital hospital=new Hospital(104,"name1","grade","address",11,22,"introduce");*/
      Department resultdepartment= departmentService.editDepartment(department);
        return resultdepartment;
    }

    /**
     * 根据id删除科室信息
     */

    @RequestMapping(value = "deleteDepartment/{did}",method = RequestMethod.DELETE) //delete
    public int deleteDepartment(@PathVariable String did){
        return departmentService.deleteDepartment(did);
    }

    /**
     * 根据id集合，批量删除科室信息
     */

    @RequestMapping(value = "batchdeleteDepartment",method = RequestMethod.POST) //POST
    public Boolean batchdeleteDepartment(@RequestBody String [] didlist){
        return departmentService.batchdeleteDepartment(didlist);
    }

    /**
     * 根据did,danme,introduce,模糊查询科室信息
     */

    @RequestMapping(value = "getDepartmentLike",method = RequestMethod.GET)
    public List<Department> getHospitalLike(@RequestParam String selectword, @RequestParam Integer hid){
        List<Department> departments=departmentService.getDepartmentLike(selectword,hid);
        return departments;
    }

    /**
     * 查询医院包含的所有科室名称集合
     */

    @RequestMapping(value = "getDepartmentDnamelist",method = RequestMethod.GET)
    public List<Department> getDepartmentDnamelist(){
        List<Department> departmentdnamelist=departmentService.getDepartmentDnamelist();
        return departmentdnamelist;
    }

    /**
     * 查询医院包含的所有科室名称集合通过医院(hid)
     */

    @RequestMapping(value = "getDepartmentDnamelistByHid/{hid}",method = RequestMethod.GET)
    public List<Department> getDepartmentDnamelistByHid(@PathVariable int hid){
        List<Department> departmentdnamelist=departmentService.getDepartmentDnamelistByHid(hid);
        System.out.print("进入接口");
        return departmentdnamelist;
    }








}
