package com.hand.hand.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Doctor;
import com.hand.hand.domain.Hospital;
import com.hand.hand.mapper.DepartmentMapper;
import com.hand.hand.mapper.DoctorMapper;
import com.hand.hand.service.DepartmentService;
import com.hand.hand.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nishuai on 2017/12/19.
 */
@Service
public class DoctorServiceImpl implements DoctorService{

   @Autowired
   private DoctorMapper doctorMapper;


     /*
      查询所有医生信息
     */

    @Override
    public List<Doctor> findAllDoctor(Integer hid){
        List<Doctor> doctorslist=doctorMapper.findAllDoctor(hid);
        return doctorslist;
    }

    /*
    * 查询所有医生信息（分页）
    */
    public Page<Doctor> findAllDoctorPage(Integer hid,Integer page, Integer size){

        PageHelper.startPage(page, size);
        List<Doctor> doctorslist=  this.findAllDoctor(hid);
        Page<Doctor> doctorslistPage= (Page<Doctor>)doctorslist;

        return doctorslistPage;
    }

    /**
     * 添加单个医院信息
     */
    @Override
    public Doctor addDoctor(Doctor doctor){
        int result=doctorMapper.addDoctor(doctor);
        if(result>0){
            System.out.println("插入成功！");
            return doctorMapper.getDoctorByDid(doctor.getId());
        }
        return  null;
    }

    /**
     * 根据id删除医院信息
     */
    @Override
    public int deleteDoctor(int id){
        int result=doctorMapper.deleteDoctor(id);
        if(result>0){
            System.out.println("删除成功！");
            return result;
        }
        return  0;
    }

     /*
      根据id查询医生信息
     */

    public Doctor getDoctorById(Integer id){
       Doctor doctor=  doctorMapper.getDoctorByDid(id);
        return  doctor;
    }

    /**
     * 编辑单个医院信息
     */
    @Override
    public Doctor editDoctor(Doctor doctor){
        int result=doctorMapper.editDoctor(doctor);
        if(result>0){
            System.out.println("修改成功！");
            return doctorMapper.getDoctorByDid(doctor.getId());
        }
        return  null;
    }

    /**
     * 根据id,name,idnumber,practicenumber,professionaltitle,gender,phone,speciality,introduce,age等医生字段,模糊查询医生信息
     */
    public List<Doctor> getDoctorLike(String selectword){
        List<Doctor> doctors=  doctorMapper.getDoctorLike(selectword);
     /*   System.out.println("test");*/
        System.out.println(doctors.size());
        System.out.println(doctors.get(0).getName());
        return doctors;
    }




}
