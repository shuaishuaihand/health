package com.hand.hand.service;

import com.github.pagehelper.Page;
import com.hand.hand.domain.Department;
import com.hand.hand.domain.Doctor;

import java.util.List;

/**
 * Created by nishuai on 2017/12/19.
 */
public interface DoctorService {

      /*
      查询所有医生信息
     */

    public List<Doctor> findAllDoctor(Integer hid);

    /**
     * 查询所有医生信息（分页）
     */

    public Page<Doctor> findAllDoctorPage(Integer hid,Integer page,Integer size);

      /*
      添加单个医生的信息
     */

    public Doctor addDoctor(Doctor doctor);

      /*
     根据id删除医院信息
     */

    public int deleteDoctor(int id);

     /*
      根据id查询医院信息
     */

    public Doctor getDoctorById(Integer id);

     /*
      编辑单个医院信息
     */

    public Doctor editDoctor(Doctor doctor);

    /**
     * 根据id,name,idnumber,practicenumber,professionaltitle,gender,phone,speciality,introduce,age等医生字段,模糊查询医生信息
     */
    public List<Doctor> getDoctorLike(String selectword);





}
