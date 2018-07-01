package com.hand.hand.controller;
import com.hand.hand.domain.Doctor;
import com.hand.hand.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.Page;

import java.util.*;

/**
 * Created by nishuai on 2017/11/12.
 */
@CrossOrigin
@RestController
public class DoctorController {

    //注入Service服务对象
    @Autowired
    private DoctorService doctorService;

    /**
     * 查询所有医院信息（未分页）
     */

    @RequestMapping(value = "findAllDoctor/{hid}",method = RequestMethod.GET)
    public List<Doctor> findAllDoctor(@PathVariable Integer hid){
        List<Doctor> doctorList= doctorService.findAllDoctor(hid);
        return doctorList;
    }

    /**
     * 查询所有医院信息（分页）
     */

    @RequestMapping(value = "findAllDoctorPage/{hid}",method = RequestMethod.GET)
    public Map<String,Object> findAllDoctorPage(@PathVariable Integer hid, @RequestParam Integer page,@RequestParam Integer size){
        Page<Doctor> doctorListpage= doctorService.findAllDoctorPage(hid,page,size);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("pagedoctordata",doctorListpage);
        map.put("total",doctorListpage.getTotal());

        return map;
    }

    /**
     * 添加单个医生信息
     */

    @RequestMapping(value = "addDoctor",method = RequestMethod.POST)  //post
    public Doctor addDoctor(@RequestBody Doctor doctor){
         /*Hospital hospital=new Hospital(null,"9","9");*/
         // @RequestBody Doctor doctor

        /* Doctor doctor=new Doctor();
         doctor.setDname("蒯医生");
         doctor.setIdnumber("1112");
        System.out.println(doctor.getDname());
        System.out.print(doctor.getIdnumber());*/
        System.out.print(doctor.getDepartment().getDname()+"name");

        Doctor resultdoctor= doctorService.addDoctor(doctor);
        return resultdoctor;
    }

    /**
     * 根据id删除医院信息
     */

    @RequestMapping(value = "deleteDoctor/{id}",method = RequestMethod.DELETE) //delete
    public int deleteDoctor(@PathVariable Integer id){
        return doctorService.deleteDoctor(id);
    }

    /**
     * 根据id查询医生信息
     */

    @RequestMapping(value = "getDoctorById/{id}",method = RequestMethod.GET)
    public Doctor getDoctorById(@PathVariable Integer id){
       /* *//**//*/
        Integer hid=104;*/
        Doctor doctor=doctorService.getDoctorById(id);
        System.out.print( doctor.getDepartment().getDname()+"deptname");
        return doctor;
    }

    /**
     * 编辑单个医院信息
     */

    @RequestMapping(value = "editDoctor",method = RequestMethod.PUT)  //put
    public Doctor editDoctor(@RequestBody Doctor doctor){
        System.out.println("1111111111111"+doctor.getDepartment().getDid()+"1111111111111");

       /* Hospital hospital=new Hospital(104,"name1","grade","address",11,22,"introduce");*/
       Doctor resultdoctor= doctorService.editDoctor(doctor);
       System.out.print(resultdoctor.getDepartment().getDname()+"deptname");
        return resultdoctor;
    }

    /**
     * 根据id,name,idnumber,practicenumber,professionaltitle,gender,phone,speciality,introduce,age等医生字段,模糊查询医生信息
     */

    @RequestMapping(value = "getDoctorLike/{selectword}",method = RequestMethod.GET)
    public List<Doctor> getDoctorLike(@PathVariable String selectword){
        List<Doctor> doctors=doctorService.getDoctorLike(selectword);
        return doctors;
    }







}
