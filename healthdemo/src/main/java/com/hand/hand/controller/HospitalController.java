package com.hand.hand.controller;


import com.hand.hand.domain.Chartdata;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Hospital;
import com.github.pagehelper.Page;
import com.hand.hand.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by nishuai on 2017/11/12.
 */
@CrossOrigin
@RestController /* @Controller + @ResponseBody*/
public class HospitalController {

    //注入Service服务对象
    @Autowired
    private HospitalService hospitalService;

    /**
     * 查询所有医院信息（未分页）
     */

    @RequestMapping(value = "findAllHospital",method = RequestMethod.GET)
    public  List<Hospital> findAllHospital(){
        List<Hospital> hospitalList= hospitalService.findAllHospital();
        return hospitalList;
    }

    /**
     * 查询所有医院信息（分页）
     */

    @RequestMapping(value = "findAllHospitalPage",method = RequestMethod.GET)
    public Map<String,Object> findAllHospitalPage(@RequestParam Integer page,@RequestParam Integer size){
       /* @RequestParam Integer page,@RequestParam Integer size*/
      /*  Integer page=2;
        Integer size=2;*/
       Page<Hospital> hospitalListpage= hospitalService.findAllHospitalPage(page,size);
       Map<String,Object> map= new HashMap<String,Object>();
       map.put("pagehospitaldata",hospitalListpage);
       map.put("total",hospitalListpage.getTotal());

        return map;
    }

    /**
     * 根据id查询医院信息
     */

    @RequestMapping(value = "getHospitalByHid/{hid}",method = RequestMethod.GET)
    public Hospital getHospitalByHid(@PathVariable Integer hid){
       /* *//**//*/
        Integer hid=104;*/
        Hospital hospital=hospitalService.getHospitalByHid(hid);
        return hospital;
    }

    /**
     * 根据hid,hanme,grade,模糊查询医院信息
     */

    @RequestMapping(value = "getHospitalLike/{selectword}",method = RequestMethod.GET)
    public List<Hospital> getHospitalLike(@PathVariable String selectword){
        List<Hospital> hospitals=hospitalService.getHospitalLike(selectword);
        return hospitals;
    }


    /**
     * 添加单个医院信息
     */

    @RequestMapping(value = "addHospital",method = RequestMethod.POST)  //post
    public Hospital addHospital(@RequestBody Hospital hospital){
         /*Hospital hospital=new Hospital(null,"9","9");*/
         System.out.println(hospital.getHname());
        System.out.println(hospital.getGrade());
         Hospital resulthospital= hospitalService.addHospital(hospital);
         return resulthospital;
    }

    /**
     * 编辑单个医院信息
     */

    @RequestMapping(value = "editHospital",method = RequestMethod.PUT)  //put
    public Hospital editHospital(@RequestBody Hospital hospital){
        System.out.println(hospital.getPicture()+"1111111111111");

       /* Hospital hospital=new Hospital(104,"name1","grade","address",11,22,"introduce");*/
        Hospital resulthospital= hospitalService.editHospital(hospital);
        return resulthospital;
    }

    /**
     * 根据id删除医院信息
     */

    @RequestMapping(value = "deleteHospital/{hid}",method = RequestMethod.DELETE) //delete
    public int deleteHospital(@PathVariable Integer hid){
        return hospitalService.deleteHospital(hid);
    }

    /**
     * 根据id集合，批量删除医院信息
     */

    @RequestMapping(value = "batchdeleteHospital",method = RequestMethod.POST) //POST
    public Boolean batchdeleteHospital(@RequestBody Integer[] hidlist){
      /*  Integer hidlist[]={129,130};*/
        return hospitalService.batchdeleteHospital(hidlist);
    }

    /**
     * 根据id，查询对应的所有科室信息(未分页)
     */

   @RequestMapping(value = "findAllDepartmentByHid/{hid}",method = RequestMethod.GET)
    public List<Department> findAllDepartmentByHid(@PathVariable Integer hid){
        return hospitalService.findAllDepartmentByHid(hid);
    }

    /**
     * 根据id，查询对应的所有科室信息(分页)
     */

    @RequestMapping(value = "findAllDepartmentPageByHid/{hid}",method = RequestMethod.GET)
    public Map<String,Object>  findAllDepartmentPageByHid(@PathVariable Integer hid,@RequestParam Integer page,@RequestParam Integer size){

        Page<Department> departmentListpage= hospitalService.findAllDepartmentPageByHid(hid,page,size);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("pagedepartmentdata",departmentListpage);
        map.put("total",departmentListpage.getTotal());

        return map;
    }


    /**
     * 查询医院各等级个数比例
     */
    @RequestMapping(value = "findHospitalnumberByGrade",method = RequestMethod.GET)
    public List<Chartdata> findHospitalnumberByGrade(){
        return hospitalService.findHospitalnumberByGrade();
    }






}
