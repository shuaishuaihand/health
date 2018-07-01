package com.hand.hand.mapper;

import com.hand.hand.domain.Department;
import com.hand.hand.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nishuai on 2017/12/19
 */

@Mapper
public interface DoctorMapper {

    /**
      * 查询所有医生信息
    */
    List<Doctor> findAllDoctor(Integer hid);

    /**
     * 添加单个医生信息
     */

    int addDoctor(Doctor doctor);

    /**
     * 根据id查询医生信息
     */

    Doctor getDoctorByDid(Integer did);

    /**
     * 根据id删除医生信息
     */

    int deleteDoctor(Integer id);

    /**
     * 编辑单个医生信息
     */

    int editDoctor(Doctor doctor);

    /**
     * 根据id,name,idnumber,practicenumber,professionaltitle,gender,phone,speciality,introduce,age等医生字段,模糊查询医生信息
     */
    List<Doctor> getDoctorLike(@Param("selectword") String selectword);






}
